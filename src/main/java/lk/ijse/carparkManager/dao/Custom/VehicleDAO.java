package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.dao.CrudDAO;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;

public interface VehicleDAO extends CrudDAO<Vehicle> {
    boolean isAvailableSlot(String slotId) throws SQLException, ClassNotFoundException;
    ArrayList<Vehicle> getAll() throws SQLException, ClassNotFoundException;
    VehicleDTO retrieveType(String id) throws SQLException, ClassNotFoundException;
    void deleteVehicleRecord(String id) throws SQLException, ClassNotFoundException;
    int getCount() throws SQLException, ClassNotFoundException;
    Vehicle getVehicleDetails(int slotId) throws SQLException, ClassNotFoundException;
}
