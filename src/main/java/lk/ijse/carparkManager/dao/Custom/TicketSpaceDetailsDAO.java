package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.dao.CrudDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.dto.TicketSpaceDetailsDTO;
import lk.ijse.carparkManager.entity.TicketSpaceDetails;

import java.sql.*;
import java.time.LocalTime;

public interface TicketSpaceDetailsDAO extends CrudDAO<TicketSpaceDetails> {
    void saveCheckIn(TicketSpaceDetails ticketSpaceDetails) throws SQLException, ClassNotFoundException;
    void saveCheckOut(TicketSpaceDetails ticketSpaceDetails) throws SQLException, ClassNotFoundException;
    LocalTime getEntryTimeForVehicle(String id) throws SQLException, ClassNotFoundException;
    String getTicketId(String slot_id) throws SQLException, ClassNotFoundException;
}
