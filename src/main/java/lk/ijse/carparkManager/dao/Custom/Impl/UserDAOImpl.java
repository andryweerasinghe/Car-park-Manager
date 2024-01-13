/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.UserDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.LoginDTO;
import lk.ijse.carparkManager.dto.RegistrationDTO;
import lk.ijse.carparkManager.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO User VALUES (?,?,?,?,?,?,?)");
    }
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT id FROM User ORDER BY id DESC LIMIT 1");
        if (resultSet.next()){
            String id = resultSet.getString("id");
            int newVehicleId = Integer.parseInt(id.replace("U00-", "")) + 1;
            return String.format("U00-%03d", newVehicleId);
        } else {
            return "U00-001";
        }
    }
    public boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT * FROM User WHERE user_name = ? AND password = ?");
    }
    public boolean login(LoginDTO loginDTO) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM User WHERE user_name=? AND password=?", loginDTO.getPassword(), loginDTO.getUsername());
        return resultSet.next();
    }

    public LoginDTO getUserInfo(String userName) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM User WHERE user_name=?", userName);
        if (resultSet.next()) {
            String retrievedUserName = resultSet.getString("user_name");
            return new LoginDTO(retrievedUserName);
        }
        return null;
    }
}
