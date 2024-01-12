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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentsDAOImpl implements PaymentsDAO {
    public void save(PaymentsDTO paymentsDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Payment (id, amount, ticket_id) VALUES (?,?,?)");
        preparedStatement.setInt(1, paymentsDTO.getId());
        preparedStatement.setDouble(2, paymentsDTO.getAmount());
        preparedStatement.setInt(3, paymentsDTO.getTicket_id());

        preparedStatement.execute();
    }
    public int getNextAvailableId() throws SQLException, ClassNotFoundException {
        int nextAvailableId = 1; // Default value if no records exist

        ResultSet resultSet = SQLUtil.execute("SELECT MAX(id) FROM Payment");

        if (resultSet.next()) {
            nextAvailableId = resultSet.getInt(1) + 1;
        }
        return nextAvailableId;
    }
}
