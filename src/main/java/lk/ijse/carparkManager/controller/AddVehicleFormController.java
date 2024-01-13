/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/11/23

 */

package lk.ijse.carparkManager.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.carparkManager.bo.AddVehicleBo;
import lk.ijse.carparkManager.bo.BOFactory;
import lk.ijse.carparkManager.dto.TicketDTO;
import lk.ijse.carparkManager.dto.TicketSpaceDetailsDTO;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.dto.VehicleTicketDetailsDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AddVehicleFormController implements Initializable {
    @FXML
    private TextField owner;

    @FXML
    private TextField slot_id;

    @FXML
    private TextField vehicle_id;

    @FXML
    private TextField vehicle_no;

    @FXML
    private TextField brand;

    @FXML
    private TextField mobile_no;

    @FXML
    private ChoiceBox<String> vehicle_types;

    @FXML
    private JFXButton vehicleAdded;

    private final String[] types = {"Car", "Lorry(6 wheel)", "ThreeWheel", "MotorBike", "SUV", "Van"};
    AddVehicleBo addVehicleBo = (AddVehicleBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ADD_VEHICLE);
    public void setTextFieldErrorStyle(TextField textField) {
        textField.getStyleClass().add("error-text-field");
    }

    public void clearTextFieldErrorStyle(TextField textField) {
        textField.getStyleClass().remove("error-text-field");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vehicle_types.getItems().addAll(types);
        String vehicleId = null;
        try {
            vehicleId = addVehicleBo.generateNextVehicleId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        vehicle_id.setText(String.valueOf(vehicleId));
    }
    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        String ownerText = owner.getText();
        String slotIdText = slot_id.getText();
        String vehicleNoText = vehicle_no.getText();
        String vehicleTypeText = vehicle_types.getSelectionModel().getSelectedItem();
        String vehicleIdText = vehicle_id.getText();
        String mobileNoText = mobile_no.getText();
        String brandText = brand.getText();

        String ticketId = addVehicleBo.generateNextTicketId();

        boolean availableSlot = addVehicleBo.isAvailableSlot(Integer.parseInt(slotIdText.trim()));
        if (availableSlot) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("The slot you entered is already in use. Please try again!");
            alert.showAndWait();

            // Setting the red border style for the text field
            setTextFieldErrorStyle(slot_id);

            return;
        } else {
            // Clearing the red border style for the text field if there's no error
            clearTextFieldErrorStyle(slot_id);
        }
        if (ownerText.trim().isEmpty() || vehicleNoText.trim().isEmpty() || vehicleTypeText.trim().isEmpty() || slotIdText.trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("All fields must not be empty!");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Saved!");
            alert.setContentText("Vehicle Added");

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.seconds(1.5), // Adjust the duration as needed
                    event -> alert.close()));

            // Set the cycle count to 1 so that the timeline stops after closing the alert
            timeline.setCycleCount(1);

            System.out.println(ticketId);
            {TicketDTO ticketDTO = new TicketDTO(ticketId, "pending");
                addVehicleBo.saveCheckIn(ticketDTO);
            }
            // i get the following error message when trying to save the below details
            LocalTime now = LocalTime.now();
            TicketSpaceDetailsDTO ticketSpaceDetailsDTO = new TicketSpaceDetailsDTO(ticketId, Integer.parseInt(slotIdText), now);
            addVehicleBo.saveCheckInTime(ticketSpaceDetailsDTO);

            VehicleDTO vehicleDTO = new VehicleDTO(vehicleIdText, vehicleNoText, vehicleTypeText, ownerText, slotIdText, brandText, mobileNoText);

            addVehicleBo.updateSlotStatusById(Integer.parseInt(slotIdText));
            addVehicleBo.saveNewVehicle(vehicleDTO);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/main_form.fxml"));

            try {
                Parent root = fxmlLoader.load();

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);

                stage.show();
                ((Stage) vehicleAdded.getScene().getWindow()).close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            alert.show();
            timeline.play();
        }
    }
}
