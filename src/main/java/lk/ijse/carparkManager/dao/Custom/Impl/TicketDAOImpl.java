/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.TicketDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.TicketDTO;
import lk.ijse.carparkManager.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAOImpl implements TicketDAO {

    public boolean saveCheckOut(Ticket ticket) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Ticket SET duration = ?, status = ? WHERE id = ?",ticket.getDuration(),ticket.getStatus(),ticket.getTicket_id());
    }

    @Override
    public boolean save(Ticket ticket) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Ticket (id, status) VALUES (?,?)",ticket.getTicket_id(),ticket.getStatus());
    }
    public ResultSet getTicketData(int slot_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT * FROM Ticket WHERE slot_id = ?", slot_id);
    }

    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM Ticket ORDER BY id DESC LIMIT 1");
        if (resultSet.next()){
            String code = resultSet.getString("id");
            int newItemId = Integer.parseInt(code.replace("T00-", "")) + 1;
            return String.format("T00-%03d", newItemId);
        } else {
            return "T00-001";
        }
    }

    @Override
    public boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException {
        return false;
    }
}
