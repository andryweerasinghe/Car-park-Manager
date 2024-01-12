/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/8/24

 */

package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dao.Custom.UserDAO;
import lk.ijse.carparkManager.dao.Custom.VehicleDAO;
import lk.ijse.carparkManager.dao.DAOFactory;
import lk.ijse.carparkManager.dto.LoginDTO;
import lk.ijse.carparkManager.dto.RegistrationDTO;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.User;
import lk.ijse.carparkManager.entity.Vehicle;

import java.sql.SQLException;

public class UserBoImpl implements UserBo{
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean save(RegistrationDTO registrationDTO) throws SQLException, ClassNotFoundException {
        User user= new User(registrationDTO.getId(), registrationDTO.getName(), registrationDTO.getJobRole(), registrationDTO.getUserName(), registrationDTO.getEmail(), registrationDTO.getPassword(), registrationDTO.getMobile());
        return userDAO.save(user);
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return userDAO.generateNextId();
    }

    @Override
    public boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException {
        return userDAO.isValid(userName, pw);
    }

    @Override
    public boolean login(LoginDTO loginDTO) throws SQLException, ClassNotFoundException {
        return userDAO.login(loginDTO);
    }

    @Override
    public LoginDTO getUserInfo(String userName) throws SQLException, ClassNotFoundException {
        return userDAO.getUserInfo(userName);
    }
}
