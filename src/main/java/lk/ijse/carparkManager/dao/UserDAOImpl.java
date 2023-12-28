/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 12/29/23

 */

package lk.ijse.carparkManager.dao;

import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.LoginDTO;
import lk.ijse.carparkManager.dto.RegistrationDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    public void save(RegistrationDTO registrationDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into User values (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, registrationDTO.getId());
        preparedStatement.setString(2, registrationDTO.getName());
        preparedStatement.setString(3, registrationDTO.getJobRole());
        preparedStatement.setString(4, registrationDTO.getEmail());
        preparedStatement.setInt(5, registrationDTO.getMobile());
        preparedStatement.setString(6, registrationDTO.getPassword());
        preparedStatement.setString(7, registrationDTO.getUserName());

        preparedStatement.execute();

    }
    public String splitUserId(String currentUserId){
        if(currentUserId != null){
            String[] splitId = currentUserId.split("00");
            int id = Integer.parseInt(splitId[1]);
            id++;
            return "E00" + id;
        } else {
            return "E001";
        }
    }
    public String generateNextUserId() throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM User ORDER BY id DESC LIMIT 1");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return splitUserId(resultSet.getString(1));
        }else {
            return splitUserId(null);
        }
    }
    public boolean isValidUser(String userName, String pw) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM User WHERE user_name = ? AND password = ?";
        PreparedStatement ptsm = connection.prepareStatement(sql);
        ptsm.setString(1, userName);
        ptsm.setString(2,pw);

        ResultSet resultSet = ptsm.executeQuery();

        return resultSet.next();
    }
    public boolean check(String userName, String pw) throws SQLException {
        try {
            return isValidUser(userName,pw);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private String loggedInUserName;
    public boolean login(LoginDTO loginDTO) throws SQLException, ClassNotFoundException {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from User where password=? and user_name=?");
            preparedStatement.setString(1, loginDTO.getUsername());
            preparedStatement.setString(2, loginDTO.getPassword());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Process the result set, validate login, and return true/false accordingly
                return resultSet.next(); // For simplicity, assuming a match if any result is found
            }
    }

    public LoginDTO getUserInfo(String userName) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User WHERE user_name=?")) {
            preparedStatement.setString(1, userName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String retrievedUserName = resultSet.getString("user_name");
                    return new LoginDTO(retrievedUserName);
                }
            }
        }
        return null;
    }
    public String getLoggedInUserName() {
        return loggedInUserName;
    }
}
