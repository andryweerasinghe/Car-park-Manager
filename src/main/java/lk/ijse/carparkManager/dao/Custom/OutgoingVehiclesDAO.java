package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.dao.CrudDAO;
import lk.ijse.carparkManager.entity.OutgoingVehicles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface OutgoingVehiclesDAO extends CrudDAO<OutgoingVehicles> {
    ArrayList<OutgoingVehicles> getCheckOutData() throws SQLException, ClassNotFoundException;
    int getCount() throws SQLException, ClassNotFoundException;
    ResultSet getTicketData(int slot_id) throws SQLException, ClassNotFoundException;
    ResultSet getDataBetweenDates(LocalDate startDate, LocalDate endDate) throws SQLException, ClassNotFoundException;
}
