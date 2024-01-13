/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/15/23

 */

package lk.ijse.carparkManager.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageVehiclesFormController implements Initializable {
    public JFXButton vehiclesIn;
    public JFXButton vehiclesOut;
    public BorderPane bp;
    public AnchorPane ap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage("/view/vehicles_in_form");
    }
    public void btnVehiclesInOnAction(ActionEvent actionEvent) {
        loadPage("/view/vehicles_in_form");
    }
    public void btnVehiclesOutOnAction(ActionEvent actionEvent) {
        loadPage("/view/vehicles_out_form");
    }

    private void loadPage(String page){
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));

            if (bp.getCenter() != null && bp.getCenter().equals(root)) {
                return; // Do not reload the same page
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bp.setCenter(root);
    }
}
