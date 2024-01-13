/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.RatesDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.entity.Rates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatesDAOImpl implements RatesDAO {
    public double getRate(String type) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT rate_per_hour FROM Rates WHERE vehicle_type = ?", type);
        if (resultSet.next()) {
            return resultSet.getDouble("rate_per_hour");
        }
        return -1;
    }

    @Override
    public boolean save(Rates dto) throws SQLException, ClassNotFoundException {
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
