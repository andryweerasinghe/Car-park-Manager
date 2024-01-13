/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/11/23

 */

package lk.ijse.carparkManager.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.carparkManager.model.AddVehicleModel;
import lk.ijse.carparkManager.model.ParkingSlotModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ParkingSlotFormController implements Initializable {

    @FXML
    private JFXButton btnSlot1;

    @FXML
    private JFXButton btnSlot10;

    @FXML
    private JFXButton btnSlot11;

    @FXML
    private JFXButton btnSlot12;

    @FXML
    private JFXButton btnSlot13;

    @FXML
    private JFXButton btnSlot14;

    @FXML
    private JFXButton btnSlot15;

    @FXML
    private JFXButton btnSlot16;

    @FXML
    private JFXButton btnSlot17;

    @FXML
    private JFXButton btnSlot18;

    @FXML
    private JFXButton btnSlot19;

    @FXML
    private JFXButton btnSlot2;

    @FXML
    private JFXButton btnSlot20;

    @FXML
    private JFXButton btnSlot21;

    @FXML
    private JFXButton btnSlot22;

    @FXML
    private JFXButton btnSlot23;

    @FXML
    private JFXButton btnSlot24;

    @FXML
    private JFXButton btnSlot25;

    @FXML
    private JFXButton btnSlot26;

    @FXML
    private JFXButton btnSlot27;

    @FXML
    private JFXButton btnSlot28;

    @FXML
    private JFXButton btnSlot29;

    @FXML
    private JFXButton btnSlot3;

    @FXML
    private JFXButton btnSlot30;

    @FXML
    private JFXButton btnSlot4;

    @FXML
    private JFXButton btnSlot5;

    @FXML
    private JFXButton btnSlot6;

    @FXML
    private JFXButton btnSlot7;

    @FXML
    private JFXButton btnSlot8;

    @FXML
    private JFXButton btnSlot9;

    private final ParkingSlotModel parkingSlotModel = new ParkingSlotModel();

    private final AddVehicleModel addVehicleModel = new AddVehicleModel();

    @FXML
    private void handleButtonAction(ActionEvent event) {
        JFXButton clickedButton = (JFXButton) event.getSource();
        int buttonIndex = getButtonIndex(clickedButton);
        int slotId = buttonIndex + 1;
        boolean isOccupied = parkingSlotModel.checkStatus(slotId);
        if(!isOccupied){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Information");
            alert.setContentText("There's no vehicle parked in this slot");
            alert.showAndWait();
        }
        else {
            SlotButtonFormController slotButtonFormController = new SlotButtonFormController();
            System.out.println(slotId);

            // Set the slotId value in the controller
            slotButtonFormController.setSlotId(slotId);
            //i want to pass the slotId to the controller of thebelow form too
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/slot_button_form.fxml"));
                Parent root = loader.load();


                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace(); // Handle or log the exception appropriately
            }
        }
    }
    private int getButtonIndex(JFXButton clickedButton) {
        // Retrieve the array of buttons
        JFXButton[] buttonsArray = new JFXButton[]{
                btnSlot1, btnSlot2, btnSlot3, btnSlot4, btnSlot5, btnSlot6, btnSlot7, btnSlot8, btnSlot9,
                btnSlot10, btnSlot11, btnSlot12, btnSlot13, btnSlot14, btnSlot15, btnSlot16, btnSlot17, btnSlot18,
                btnSlot19, btnSlot20, btnSlot21, btnSlot22, btnSlot23, btnSlot24, btnSlot25, btnSlot26, btnSlot27,
                btnSlot28, btnSlot29, btnSlot30
        };

        // Find the index of the clicked button in the array
        for (int i = 0; i < buttonsArray.length; i++) {
            if (buttonsArray[i] == clickedButton) {
                return i; // Return the index of the clicked button
            }
        }

        return -1; // If the button is not found in the array
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JFXButton[] buttonsArray = new JFXButton[]{
                btnSlot1, btnSlot2, btnSlot3, btnSlot4, btnSlot5, btnSlot6, btnSlot7, btnSlot8, btnSlot9, btnSlot10, btnSlot11, btnSlot12, btnSlot13, btnSlot14, btnSlot15, btnSlot16, btnSlot17, btnSlot18, btnSlot19, btnSlot20, btnSlot21, btnSlot22, btnSlot23, btnSlot24, btnSlot25, btnSlot26, btnSlot27, btnSlot28, btnSlot29, btnSlot30
        };
        for (JFXButton button : buttonsArray) {
            button.setOnAction(this::handleButtonAction);
            button.getStyleClass().add("button-style");
            button.getStyleClass().add("button-style:hover");
            button.getStyleClass().add("button-style .container");
        }
        ParkingSlotModel parkingSlotModel = new ParkingSlotModel();

        try {
            parkingSlotModel.assignSlot(buttonsArray);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
    }
    public void btnSlot1OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot2OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot3OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot4OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot5OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot6OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot7OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot8OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot9OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot10OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot11OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot12OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot13OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot14OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot15OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot16OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot17OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot19OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot18OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot20OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot21OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot22OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot23OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot24OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot25OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot26OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot27OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot28OnAction(ActionEvent actionEvent) {

    }
    public void btnSlot29OnAction(ActionEvent actionEvent) {

    }

    public void btnSlot30OnAction(ActionEvent actionEvent) {

    }
}
