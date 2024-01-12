/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.VehicleTicketDetailsDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.entity.VehicleTicketDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleTicketDetailsDAOImpl implements VehicleTicketDetailsDAO {
    public boolean save(VehicleTicketDetails vehicleTicketDetails) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO VehicleTicketDetails VALUES (?,?)", vehicleTicketDetails);
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException {
        return false;
    }

    public String getTicketId(String vehicleId) throws SQLException, ClassNotFoundException {
        String ticketId = null;
        ResultSet resultSet = SQLUtil.execute("SELECT ticket_id FROM VehicleTicketDetails WHERE vehicle_id = ?", vehicleId);

        if (resultSet.next()){
            ticketId = resultSet.getString("ticket_id");
        }
        return ticketId;
    }
}
