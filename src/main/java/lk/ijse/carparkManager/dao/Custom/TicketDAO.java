package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.dao.CrudDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.dto.TicketDTO;
import lk.ijse.carparkManager.entity.Ticket;

import java.sql.SQLException;

public interface TicketDAO extends CrudDAO<Ticket> {
    boolean saveCheckOut(Ticket ticket) throws SQLException, ClassNotFoundException;
}
