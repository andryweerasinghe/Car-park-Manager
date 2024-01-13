/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/19/23

 */

package lk.ijse.carparkManager.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.carparkManager.dto.*;
import lk.ijse.carparkManager.model.*;
import javafx.scene.control.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class VehiclesInFormController implements Initializable{
    @FXML
    private TableColumn<VehicleDTO, Void> columnAction;

    @FXML
    private TableColumn<VehicleDTO, String> columnId;

    @FXML
    private TableColumn<VehicleDTO, String> columnOwner;

    @FXML
    private TableColumn<VehicleDTO, String> columnSlot;

    @FXML
    private TableColumn<VehicleDTO, String> columnVehicleNo;

    @FXML
    private TableView<VehicleDTO> tblVehiclesIn;

    private final TicketSpaceDetailsModel ticketSpaceDetailsModel = new TicketSpaceDetailsModel();

    private final TicketModel ticketModel = new TicketModel();

    private final ParkingSlotModel parkingSlotModel = new ParkingSlotModel();

    private final RatesModel ratesModel = new RatesModel();

    private final PaymentsModel paymentsModel = new PaymentsModel();

    private final VehicleTicketDetailsModel vehicleTicketDetailsModel = new VehicleTicketDetailsModel();

    private final AddVehicleModel addVehicleModel = new AddVehicleModel();

    private final OutgoingVehiclesModel outgoingVehiclesModel = new OutgoingVehiclesModel();

    ObservableList<VehicleDTO> list;

    int index = -1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddVehicleModel vehicleModel = new AddVehicleModel();
        ObservableList<VehicleDTO> list = FXCollections.observableArrayList(vehicleModel.getVehicleData());

        columnId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        columnSlot.setCellValueFactory(cellData -> cellData.getValue().slot_idProperty());
        columnOwner.setCellValueFactory(cellData -> cellData.getValue().vehicle_ownerProperty());
        columnVehicleNo.setCellValueFactory(cellData -> cellData.getValue().vehicle_noProperty());

        columnAction.setCellFactory(param -> new TableCell<>() {
            final Button button = new Button("CheckOut");

            {
                button.setOnAction(event -> {
                    VehicleDTO vehicleDTO = getTableView().getItems().get(getIndex());
                    LocalTime now = LocalTime.now();
                    //below i need to pass the index of the same row as above to the ticket model
                    VehicleTicketDetailsDTO vehicleTicketDetailsDTO = new VehicleTicketDetailsDTO(Integer.parseInt(vehicleDTO.getId()));
                    int ticketId = vehicleTicketDetailsModel.getTicketId(vehicleTicketDetailsDTO);


                    LocalTime entryTime = ticketSpaceDetailsModel.getEntryTimeForVehicle(Integer.parseInt(vehicleDTO.getSlot_id()));
                    LocalDateTime entryDateTime = LocalDateTime.of(LocalDate.now(), entryTime);
                    LocalDateTime exitDateTime = LocalDateTime.of(LocalDate.now(), now);
                    Duration duration = Duration.between(entryDateTime, exitDateTime);

                    //below is how I get the duration in the string format
                    long hours = duration.toHours();
                    long minutes = duration.toMinutesPart();
                    long seconds = duration.toSecondsPart();

                    double totalHours = hours + (double) minutes / 60 + (double) seconds / 3600;
                    double parkingFee = 0;
                    VehicleDTO vehicleDTO1 = new VehicleDTO(vehicleDTO.getId());
                    String type = addVehicleModel.retrieveType(vehicleDTO1);
                    double parkingRatePerHour = ratesModel.getRate(type);
                    //if totalHours < 1 i need to update the parkingFee as the parkingRatePerHour itself
                    if(totalHours < 1){
                        parkingFee = parkingRatePerHour;
                    }else {
                        parkingFee = totalHours * parkingRatePerHour;
                    }

                    int nextAvailableId = paymentsModel.getNextAvailableId();

                    String formattedDuration = String.format("%02d:%02d:%02d", hours, minutes, seconds);

                    TicketDTO ticketDTO = new TicketDTO(ticketId ,formattedDuration, "paid");
                    ticketModel.saveCheckOut(ticketDTO);

                    PaymentsDTO paymentsDTO = new PaymentsDTO(nextAvailableId, parkingFee, ticketId);
                    paymentsModel.save(paymentsDTO);

                    TicketSpaceDetailsDTO ticketSpaceDetailsDTO = new TicketSpaceDetailsDTO(Integer.parseInt(vehicleDTO.getSlot_id()), now);
                    ticketSpaceDetailsModel.saveCheckOut(ticketSpaceDetailsDTO);

                    parkingSlotModel.updateSlotVacant(Integer.parseInt(vehicleDTO.getSlot_id()));

                    OutgoingVehiclesDTO outgoingVehiclesDTO = new OutgoingVehiclesDTO(vehicleDTO.getId(), vehicleDTO.getVehicle_no(), type, vehicleDTO.getVehicle_owner(), vehicleDTO.getSlot_id(), formattedDuration, String.valueOf(parkingFee), String.valueOf(ticketId));
                    outgoingVehiclesModel.save(outgoingVehiclesDTO);
                    try {
                        JasperDesign load = JRXmlLoader.load(this.getClass().getResourceAsStream("/reports/ticket.jrxml"));

                        JasperReport jasperReport = JasperCompileManager.compileReport(load);

                        ResultSet ticketData = outgoingVehiclesModel.getTicketData(Integer.parseInt(vehicleDTO.getId()));

                        JRResultSetDataSource jrResultSetDataSource = new JRResultSetDataSource(ticketData);

                        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrResultSetDataSource);

                        JasperViewer.viewReport(jasperPrint, false);
                    } catch (JRException e) {
                        throw new RuntimeException(e);
                    }
                    list.remove(vehicleDTO);
                    addVehicleModel.deleteVehicleRecord(vehicleDTO);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });

        tblVehiclesIn.setItems(list);
        tblVehiclesIn.getColumns().addAll(columnId, columnSlot, columnOwner, columnVehicleNo, columnAction);
    }
}
