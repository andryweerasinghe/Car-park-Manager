/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.VehicleDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;

public class VehicleDAOImpl implements VehicleDAO {
    public ArrayList<Vehicle> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Vehicle");
        ArrayList<Vehicle> vehicleDTOArrayList = new ArrayList<>();

        while (resultSet.next()){
            Vehicle vehicle = new Vehicle(resultSet.getString("id"), resultSet.getString("vehicle_no"), resultSet.getString("type"), resultSet.getString("vehicle_owner"), resultSet.getString("slot_id"), resultSet.getString("brand"),resultSet.getString("mobile_no"), resultSet.getString("date"));
            vehicleDTOArrayList.add(vehicle);
        }
        return vehicleDTOArrayList;
    }

    public boolean isAvailableSlot(String slotId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT slot_id FROM Vehicle WHERE slot_id = ?",slotId);
    }

    public VehicleDTO retrieveType(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT type, date FROM Vehicle WHERE id = ?",id);
        if (resultSet.next()) {
            String type = resultSet.getString("type");
            String date = resultSet.getString("date");
            return new VehicleDTO(type, date);
        }
        return null;
    }
    public void deleteVehicleRecord(String id) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("DELETE FROM Vehicle WHERE id = ?",id);
    }
    public int getCount() throws SQLException, ClassNotFoundException {
        int count = 0;

        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) FROM Vehicle");

        if (resultSet.next()){
            count = resultSet.getInt(1);
            return count;
        }
        return count;
    }

    public Vehicle getVehicleDetails(int slotId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id, vehicle_no, type, vehicle_owner, slot_id, brand, mobile_no FROM Vehicle WHERE slot_id = ?",slotId);

        if (resultSet.next()) {

            return new Vehicle(
                    resultSet.getString("id"),
                    resultSet.getString("vehicle_no"),
                    resultSet.getString("type"),
                    resultSet.getString("vehicle_owner"),
                    resultSet.getString("slot_id"),
                    resultSet.getString("brand"),
                    resultSet.getString("mobile_no")
            );
        }
        resultSet.close();
        return null;
    }

    @Override
    public boolean save(Vehicle vehicle) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Vehicle VALUES (?,?,?,?,?,?,?,?)",vehicle);
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM Vehicle ORDER BY id DESC LIMIT 1");
        if (resultSet.next()){
            String code = resultSet.getString("id");
            int newVehicleId = Integer.parseInt(code.replace("V00-", "")) + 1;
            return String.format("V00-%03d", newVehicleId);
        } else {
            return "V00-001";
        }
    }

    @Override
    public boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException {
        return false;
    }
}
