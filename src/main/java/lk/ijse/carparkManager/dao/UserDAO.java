package lk.ijse.carparkManager.dao;

import lk.ijse.carparkManager.dto.LoginDTO;
import lk.ijse.carparkManager.dto.RegistrationDTO;

import java.sql.SQLException;

public interface UserDAO {
    void save(RegistrationDTO registrationDTO) throws SQLException, ClassNotFoundException;
    String splitUserId(String currentUserId);
    String generateNextUserId() throws SQLException, ClassNotFoundException;
    boolean isValidUser(String userName, String pw) throws SQLException, ClassNotFoundException;
    boolean check(String userName, String pw) throws SQLException;
    boolean login(LoginDTO loginDTO) throws SQLException, ClassNotFoundException;
    LoginDTO getUserInfo(String userName) throws SQLException, ClassNotFoundException;
    String getLoggedInUserName();
}
