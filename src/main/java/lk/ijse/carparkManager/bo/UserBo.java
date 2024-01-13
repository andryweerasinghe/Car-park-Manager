package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.dto.LoginDTO;
import lk.ijse.carparkManager.dto.RegistrationDTO;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserBo extends SuperBO{
    boolean save(RegistrationDTO registrationDTO) throws SQLException, ClassNotFoundException;
    public String generateNextUserId() throws SQLException, ClassNotFoundException;
    public boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException;
    public boolean login(LoginDTO loginDTO) throws SQLException, ClassNotFoundException;
    public LoginDTO getUserInfo(String userName) throws SQLException, ClassNotFoundException;
}
