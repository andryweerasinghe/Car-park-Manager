/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/14/23

 */

package lk.ijse.carparkManager.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import lk.ijse.carparkManager.model.AddVehicleModel;
import lk.ijse.carparkManager.model.OutgoingVehiclesModel;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {
    public PieChart piechart1;
    public PieChart piechart2;

    @FXML
    private Label lblParkedVehicles;

    @FXML
    private Label lblVehiclesIn;

    @FXML
    private Label lblVehiclesOut;

    private final AddVehicleModel addVehicleModel = new AddVehicleModel();

    private final OutgoingVehiclesModel outgoingVehiclesModel = new OutgoingVehiclesModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int vehiclesIn = addVehicleModel.getCount();
        int vehiclesOut = outgoingVehiclesModel.getCount();
        lblParkedVehicles.setText(String.valueOf(vehiclesIn + vehiclesOut));
        lblVehiclesIn.setText(String.valueOf(vehiclesIn));
        lblVehiclesOut.setText(String.valueOf(vehiclesOut));
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Vehicles In", vehiclesIn),
                new PieChart.Data("Vehicles Out", vehiclesOut)
        );

        piechart1.setData(pieChartData);

        piechart1.getData().forEach(data -> {
            // Set the name and percentage for each slice
            data.setName(data.getName() + ": " + String.format("%.1f%%", (data.getPieValue() / getTotal(pieChartData)) * 100));
            // Set the style for each section
            data.getNode().setStyle(getChartStyle(data.getName().split(":")[0]));
        });
    }

    private double getTotal(ObservableList<PieChart.Data> data) {
        double total = 0;
        for (PieChart.Data d : data) {
            total += d.getPieValue();
        }
        return total;
    }

    private String getChartStyle(String name) {
        switch (name) {
            case "Vehicles In":
                return "-fx-pie-color: #FF6347;";
            case "Vehicles Out":
                return "-fx-pie-color: #FFA500;";
            default:
                return "";
        }
    }
}