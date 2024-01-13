/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/1/23

 */

package lk.ijse.carparkManager.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import lk.ijse.carparkManager.bo.BOFactory;
import lk.ijse.carparkManager.bo.VehicleBo;
import lk.ijse.carparkManager.dto.VehicleDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SlotButtonFormController implements Initializable {
    @FXML
    private Label lblMobileNo;

    @FXML
    private Label lblSlotId;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblVehicleBrand;

    @FXML
    private Label lblVehicleNo;

    @FXML
    private Label lblVehicleOwner;

    @FXML
    private Label lblVehicleType;

    private int slotId;

    VehicleBo vehicleBo = (VehicleBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.VEHICLE);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println(slotId);
        VehicleDTO vehicleDetails = null;
        try {
            vehicleDetails = vehicleBo.getVehicleDetails(slotId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String vehicleNo = vehicleDetails.getVehicle_no();
        String type = vehicleDetails.getType();
        String brand = vehicleDetails.getBrand();
        String vehicleOwner = vehicleDetails.getVehicle_owner();
        String mobileNo = vehicleDetails.getMobile_no();

        lblVehicleNo.setText(vehicleNo);
        lblVehicleType.setText(type);
        lblVehicleBrand.setText(brand);
        lblVehicleOwner.setText(vehicleOwner);
        lblMobileNo.setText(mobileNo);
        lblStatus.setText("Occupied");
    }

    @FXML
    void btnBackToSlotsOnAction(ActionEvent event) {

    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;

    }
}
