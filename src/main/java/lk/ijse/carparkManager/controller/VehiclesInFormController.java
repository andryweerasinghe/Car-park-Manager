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
import lk.ijse.carparkManager.bo.BOFactory;
import lk.ijse.carparkManager.bo.InVehiclesBo;
import lk.ijse.carparkManager.dto.*;
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

    InVehiclesBo inVehiclesBo = (InVehiclesBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.VEHICLES_IN);

    ObservableList<VehicleDTO> list;

    int index = -1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<VehicleDTO> list = null;
        try {
            list = FXCollections.observableArrayList(inVehiclesBo.getVehicleData());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

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

                    String ticketId = null;
                    try {
                        ticketId = inVehiclesBo.getTicketId(vehicleDTO.getSlot_id());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }


                    LocalTime entryTime = null;
                    try {
                        entryTime = inVehiclesBo.getEntryTimeForVehicle(vehicleDTO.getSlot_id());
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    LocalDateTime entryDateTime = LocalDateTime.of(LocalDate.now(), entryTime);
                    LocalDateTime exitDateTime = LocalDateTime.of(LocalDate.now(), now);
                    Duration duration = Duration.between(entryDateTime, exitDateTime);

                    //below is how I get the duration in the string format
                    long hours = duration.toHours();
                    long minutes = duration.toMinutesPart();
                    long seconds = duration.toSecondsPart();

                    double totalHours = hours + (double) minutes / 60 + (double) seconds / 3600;
                    double parkingFee = 0;
                    VehicleDTO typeAndDate = null;
                    try {
                        typeAndDate = inVehiclesBo.retrieveType(vehicleDTO.getId());
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    double parkingRatePerHour = 0;
                    try {
                        parkingRatePerHour = inVehiclesBo.getRate(typeAndDate.getType());
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    //if totalHours < 1 i need to update the parkingFee as the parkingRatePerHour itself
                    if(totalHours < 1){
                        parkingFee = parkingRatePerHour;
                    }else {
                        parkingFee = totalHours * parkingRatePerHour;
                    }

                    String nextAvailablePaymentId = null;
                    try {
                        nextAvailablePaymentId = inVehiclesBo.generateNextPaymentId();
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    String formattedDuration = String.format("%02d:%02d:%02d", hours, minutes, seconds);

                    TicketDTO ticketDTO = new TicketDTO(ticketId ,formattedDuration, "paid");
                    try {
                        inVehiclesBo.saveDuration(ticketDTO);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    PaymentsDTO paymentsDTO = new PaymentsDTO(nextAvailablePaymentId, parkingFee, ticketId);
                    try {
                        inVehiclesBo.savePayment(paymentsDTO);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    TicketSpaceDetailsDTO ticketSpaceDetailsDTO = new TicketSpaceDetailsDTO(Integer.parseInt(vehicleDTO.getSlot_id()), now);
                    try {
                        inVehiclesBo.saveCheckOut(ticketSpaceDetailsDTO);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        inVehiclesBo.updateSlotVacant(Integer.parseInt(vehicleDTO.getSlot_id()));
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    OutgoingVehiclesDTO outgoingVehiclesDTO = new OutgoingVehiclesDTO(vehicleDTO.getId(), vehicleDTO.getVehicle_no(), typeAndDate.getType(), vehicleDTO.getVehicle_owner(), vehicleDTO.getSlot_id(), formattedDuration, String.valueOf(parkingFee), String.valueOf(ticketId), typeAndDate.getDate());
                    try {
                        inVehiclesBo.saveCheckoutVehicle(outgoingVehiclesDTO);
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        JasperDesign load = JRXmlLoader.load(this.getClass().getResourceAsStream("/reports/ticket.jrxml"));

                        JasperReport jasperReport = JasperCompileManager.compileReport(load);

                        ResultSet ticketData = inVehiclesBo.getTicketData(Integer.parseInt(vehicleDTO.getId()));

                        JRResultSetDataSource jrResultSetDataSource = new JRResultSetDataSource(ticketData);

                        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrResultSetDataSource);

                        JasperViewer.viewReport(jasperPrint, false);
                    } catch (JRException | ClassNotFoundException | SQLException e) {
                        throw new RuntimeException(e);
                    }
                    tblVehiclesIn.getItems().remove(getIndex());
                    try {
                        inVehiclesBo.deleteVehicleRecord(vehicleDTO.getId());
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
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
