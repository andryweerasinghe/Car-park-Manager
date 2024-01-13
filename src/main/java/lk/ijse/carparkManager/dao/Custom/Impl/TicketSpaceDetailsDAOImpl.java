/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.TicketSpaceDetailsDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.TicketSpaceDetailsDTO;
import lk.ijse.carparkManager.entity.TicketSpaceDetails;

import java.sql.*;
import java.time.LocalTime;

public class TicketSpaceDetailsDAOImpl implements TicketSpaceDetailsDAO {
    public void saveCheckIn(TicketSpaceDetails ticketSpaceDetails) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("INSERT INTO TicketSpaceDetails (ticket_id, space_id, entry_time) VALUES (?, ?, ?)", ticketSpaceDetails.getTicket_id(), ticketSpaceDetails.getSpace_id(), ticketSpaceDetails.getEntry_time());
    }
    public void saveCheckOut(TicketSpaceDetails ticketSpaceDetails) throws SQLException, ClassNotFoundException {
        SQLUtil.execute("UPDATE TicketSpaceDetails SET exit_time = ? WHERE space_id = ?", ticketSpaceDetails.getExit_time(), ticketSpaceDetails.getSpace_id());
    }

    public LocalTime getEntryTimeForVehicle(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT entry_time FROM TicketSpaceDetails WHERE space_id = ?", id);

        if (resultSet.next()) {
            // Retrieve the entry time for the vehicle from the database
            return resultSet.getTime("entry_time").toLocalTime();
        }
        return null; // Return null if entry time is not found
    }

    @Override
    public String getTicketId(String slot_id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT ticket_id FROM TicketSpaceDetails WHERE space_id = ?", Integer.parseInt(slot_id));
        if (resultSet.next()){
            return resultSet.getString("ticket_id");
        }
        return null;
    }

    @Override
    public boolean save(TicketSpaceDetails dto) throws SQLException, ClassNotFoundException {
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
