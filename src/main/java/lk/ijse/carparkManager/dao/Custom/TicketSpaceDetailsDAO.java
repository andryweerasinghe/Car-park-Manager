package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.dto.TicketSpaceDetailsDTO;

import java.sql.*;
import java.time.LocalTime;

public interface TicketSpaceDetailsDAO {
    void saveCheckIn(TicketSpaceDetailsDTO ticketSpaceDetailsDTO) throws SQLException, ClassNotFoundException;
    void saveCheckOut(TicketSpaceDetailsDTO ticketSpaceDetailsDTO) throws SQLException, ClassNotFoundException;
    LocalTime getEntryTimeForVehicle(int id) throws SQLException, ClassNotFoundException;
}
