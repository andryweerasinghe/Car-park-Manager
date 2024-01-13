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
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.carparkManager.dto.OutgoingVehiclesDTO;
import lk.ijse.carparkManager.model.OutgoingVehiclesModel;

import java.net.URL;
import java.util.ResourceBundle;

public class VehiclesOutFormController implements Initializable {

    @FXML
    private TableColumn<OutgoingVehiclesDTO, String> checkoutId;

    @FXML
    private TableColumn<OutgoingVehiclesDTO, Void> columnDetails;

    @FXML
    private TableColumn<OutgoingVehiclesDTO, String> columnOwnersName;

    @FXML
    private TableColumn<OutgoingVehiclesDTO, String> columnSlot;

    @FXML
    private TableColumn<OutgoingVehiclesDTO, String> columnVehicle;

    @FXML
    private TableView<OutgoingVehiclesDTO> tblVehicleOut;

    private final OutgoingVehiclesModel outgoingVehiclesModel = new OutgoingVehiclesModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<OutgoingVehiclesDTO> list =FXCollections.observableArrayList(outgoingVehiclesModel.getCheckOutData());

        checkoutId.setCellValueFactory(cellData -> cellData.getValue().outgoing_vehicle_idProperty());
        columnSlot.setCellValueFactory(cellData -> cellData.getValue().slot_idProperty());
        columnOwnersName.setCellValueFactory(cellData -> cellData.getValue().vehicle_ownerProperty());
        columnVehicle.setCellValueFactory(cellData -> cellData.getValue().vehicle_noProperty());

        columnDetails.setCellFactory(param -> new TableCell<>());
//
            final Button button = new Button("View More");
//
//            {
//                button.setOnAction(event -> {
//
//                }
//            });
//        }
        tblVehicleOut.setItems(list);
        tblVehicleOut.getColumns().addAll(checkoutId, columnSlot, columnOwnersName, columnVehicle, columnDetails);
    }
}
