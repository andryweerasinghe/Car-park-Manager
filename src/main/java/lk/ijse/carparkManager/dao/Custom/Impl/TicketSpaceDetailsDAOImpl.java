/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.TicketSpaceDetailsDAO;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.TicketSpaceDetailsDTO;

import java.sql.*;
import java.time.LocalTime;

public class TicketSpaceDetailsDAOImpl implements TicketSpaceDetailsDAO {
    public void saveCheckIn(TicketSpaceDetailsDTO ticketSpaceDetailsDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TicketSpaceDetails (ticket_id, space_id, entry_time) VALUES (?, ?, ?)");

        preparedStatement.setInt(1, ticketSpaceDetailsDTO.getTicket_id());
        preparedStatement.setInt(2, ticketSpaceDetailsDTO.getSpace_id() );
        preparedStatement.setTime(3, Time.valueOf(ticketSpaceDetailsDTO.getEntry_time()));

        preparedStatement.execute();
    }
    public void saveCheckOut(TicketSpaceDetailsDTO ticketSpaceDetailsDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TicketSpaceDetails SET exit_time = ? WHERE space_id = ?");

        preparedStatement.setTime(1, Time.valueOf(ticketSpaceDetailsDTO.getExit_time()));
        preparedStatement.setInt(2, ticketSpaceDetailsDTO.getSpace_id());

        preparedStatement.execute();
    }

    public LocalTime getEntryTimeForVehicle(int id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT entry_time FROM TicketSpaceDetails WHERE space_id = ?");

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Retrieve the entry time for the vehicle from the database
            return resultSet.getTime("entry_time").toLocalTime();
        }
        return null; // Return null if entry time is not found
    }
}
