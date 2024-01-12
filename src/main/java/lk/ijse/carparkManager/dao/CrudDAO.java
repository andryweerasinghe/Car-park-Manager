package lk.ijse.carparkManager.dao;

import lk.ijse.carparkManager.dto.RegistrationDTO;

import java.sql.SQLException;

public interface CrudDAO<T> {
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    String generateNextId() throws SQLException, ClassNotFoundException;
    boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException;
}
