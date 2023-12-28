/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao;

import com.jfoenix.controls.JFXButton;
import lk.ijse.carparkManager.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingSpaceDAOImpl implements ParkingSpaceDAO {
    public void assignSlot(JFXButton[] buttonsArray) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, status FROM ParkingSpace");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String status = resultSet.getString("status");

            // Use the id and status to update buttons in the array
            updateButtonStatus(buttonsArray[id - 1], status);
        }
    }
    public void updateButtonStatus(JFXButton jfxButton, String status) {
        if (status.equalsIgnoreCase("occupied")) {
            jfxButton.setText("Occupied");
            // Set other properties or styles as needed
        } else {
            jfxButton.setText("Available");
            // Set other properties or styles as needed
        }
    }

    public void updateSlotStatusById(String slotId) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        //Updating the status column based on the id
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ParkingSpace SET status = ? WHERE id = ?");
        preparedStatement.setString(1, "occupied");
        preparedStatement.setInt(2, Integer.parseInt(slotId));
        preparedStatement.executeUpdate();

    }

    public void updateSlotVacant(int slotId) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ParkingSpace SET status = ? WHERE id = ?");
        preparedStatement.setString(1, "Vacant");
        preparedStatement.setInt(2, slotId);
        preparedStatement.executeUpdate();
    }
    public boolean checkStatus(int slotId) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT status FROM ParkingSpace WHERE id = ?");
        preparedStatement.setInt(1, slotId);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String status = resultSet.getString("status");
            return "occupied".equalsIgnoreCase(status);
        }
        return false;
    }
}
