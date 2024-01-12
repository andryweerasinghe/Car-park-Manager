/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.RatesDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatesDAOImpl implements RatesDAO {
    public double getRate(String type) throws SQLException, ClassNotFoundException {
//        Connection connection = DbConnection.getInstance().getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT rate_per_hour FROM Rates WHERE vehicle_type = ?");
//        preparedStatement.setString(1, type); // Set the vehicle type

        ResultSet resultSet = SQLUtil.execute("SELECT rate_per_hour FROM Rates WHERE vehicle_type = ?");

        if (resultSet.next()) {
            return resultSet.getDouble("rate_per_hour");
        }
        return 0.0;
    }
}
