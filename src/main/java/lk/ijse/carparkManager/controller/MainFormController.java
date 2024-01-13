package lk.ijse.carparkManager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import lk.ijse.carparkManager.dto.LoginDTO;
import lk.ijse.carparkManager.model.AddVehicleModel;
import lk.ijse.carparkManager.model.LoginModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFormController implements Initializable {

    public Label lblDisplayLoggedUser;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;

    private final LoginModel loginModel = new LoginModel();

    private LoginDTO loginDTO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage("/view/dashboard_form");
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) {
        loadPage("/view/dashboard_form");
    }

    public void btnAddVehicleOnAction(ActionEvent actionEvent) {
        loadPage("/view/add_vehicle_form");
    }

    public void btnManageVehiclesOnAction(ActionEvent actionEvent) {
        loadPage("/view/manage_vehicles_form");
    }
    public void btnReportsOnAction(ActionEvent actionEvent) {
        loadPage("/view/reports_form");
    }
    public void btnParkingSlotOnAction(ActionEvent actionEvent) {
        loadPage("/view/parkingslots_form");
    }
    public void btnCategoriesOnAction(ActionEvent actionEvent) {
        loadPage("/view/categories_form");
    }
    private void loadPage(String page){
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bp.setCenter(root);
    }
    public void setUser(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
        loadUserName();
        loadPage("/view/dashboard_form"); // Load dashboard upon setting the user
    }

    private void loadUserName() {
        if (loginDTO != null){
            String userName = loginDTO.getUsername();
            lblDisplayLoggedUser.setText(userName);
        }
    }

    public void lblLoggedUserOnAction(MouseEvent mouseEvent) {

    }

    public void imgLogOutOnAction(MouseEvent mouseEvent) {

    }
}
