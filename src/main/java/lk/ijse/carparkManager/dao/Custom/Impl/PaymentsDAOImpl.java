/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.PaymentsDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.PaymentsDTO;
import lk.ijse.carparkManager.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentsDAOImpl implements PaymentsDAO {
    public boolean save(Payment payment) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Payment (id, amount, ticket_id) VALUES (?,?,?)", payment.getId(), payment.getAmount(), payment.getTicket_id());
    }
    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM Payment ORDER BY id DESC LIMIT 1");
        if (resultSet.next()){
            String code = resultSet.getString("id");
            int newVehicleId = Integer.parseInt(code.replace("P00-", "")) + 1;
            return String.format("P00-%03d", newVehicleId);
        } else {
            return "P00-001";
        }
    }
    @Override
    public boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException {
        return false;
    }
}
