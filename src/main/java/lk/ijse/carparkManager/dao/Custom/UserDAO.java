package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.dao.CrudDAO;
import lk.ijse.carparkManager.dto.LoginDTO;
import lk.ijse.carparkManager.dto.RegistrationDTO;
import lk.ijse.carparkManager.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {
    boolean login(LoginDTO loginDTO) throws SQLException, ClassNotFoundException;
    LoginDTO getUserInfo(String userName) throws SQLException, ClassNotFoundException;
}
