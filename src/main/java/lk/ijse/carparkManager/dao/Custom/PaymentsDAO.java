package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.PaymentsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentsDAO {
    void save(PaymentsDTO paymentsDTO) throws SQLException, ClassNotFoundException;
    int getNextAvailableId() throws SQLException, ClassNotFoundException;
}
