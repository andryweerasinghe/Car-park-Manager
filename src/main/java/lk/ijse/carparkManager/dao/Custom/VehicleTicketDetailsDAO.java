package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.dao.CrudDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.VehicleTicketDetailsDTO;
import lk.ijse.carparkManager.entity.VehicleTicketDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface VehicleTicketDetailsDAO extends CrudDAO<VehicleTicketDetails> {
    public boolean save(VehicleTicketDetails vehicleTicketDetails) throws SQLException, ClassNotFoundException;
    public String getTicketId(String vehicleId) throws SQLException, ClassNotFoundException;
}
