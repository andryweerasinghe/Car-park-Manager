/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.VehicleTicketDetailsDAO;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.VehicleTicketDetailsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleTicketDetailsDAOImpl implements VehicleTicketDetailsDAO {
    public void save(VehicleTicketDetailsDTO vehicleTicketDetailsDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO VehicleTicketDetails VALUES (?,?)");
        preparedStatement.setInt(1, vehicleTicketDetailsDTO.getVehicle_id());
        preparedStatement.setInt(2, vehicleTicketDetailsDTO.getTicket_id());

        preparedStatement.execute();
    }
    public int getTicketId(VehicleTicketDetailsDTO vehicleTicketDetailsDTO) throws SQLException, ClassNotFoundException {
        int ticketId = -1;
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ticket_id FROM VehicleTicketDetails WHERE vehicle_id = ?");
        preparedStatement.setInt(1, vehicleTicketDetailsDTO.getVehicle_id());

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            ticketId = resultSet.getInt("ticket_id");
        }
        return ticketId;
    }
}
