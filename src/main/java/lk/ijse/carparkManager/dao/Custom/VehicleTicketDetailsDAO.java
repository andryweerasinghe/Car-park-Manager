package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.VehicleTicketDetailsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface VehicleTicketDetailsDAO {
    void save(VehicleTicketDetailsDTO vehicleTicketDetailsDTO) throws SQLException, ClassNotFoundException;
    int getTicketId(VehicleTicketDetailsDTO vehicleTicketDetailsDTO) throws SQLException, ClassNotFoundException;
}
