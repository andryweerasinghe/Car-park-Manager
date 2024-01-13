/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import com.jfoenix.controls.JFXButton;
import lk.ijse.carparkManager.dao.Custom.ParkingSpaceDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.entity.ParkingSpace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingSpaceDAOImpl implements ParkingSpaceDAO {
    public void assignSlot(JFXButton[] buttonsArray) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id, status FROM ParkingSpace");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String status = resultSet.getString("status");
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

    public void updateSlotStatus(int slotId) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("UPDATE ParkingSpace SET status = ? WHERE id = ?","Occupied", slotId);
    }

    public void updateSlotVacant(int slotId) throws SQLException, ClassNotFoundException {
        String status = "Available";
        SQLUtil.execute("UPDATE ParkingSpace SET status = ? WHERE id = ?",status, slotId);
    }
    public boolean checkStatus(int slotId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT status FROM ParkingSpace WHERE id = ?", slotId);

        if (resultSet.next()) {
            String status = resultSet.getString("status");
            return "occupied".equalsIgnoreCase(status);
        }
        return false;
    }

    @Override
    public boolean save(ParkingSpace dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException {
        return false;
    }
}
