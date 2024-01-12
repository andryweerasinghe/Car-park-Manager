package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.dao.CrudDAO;
import lk.ijse.carparkManager.db.DbConnection;
import lk.ijse.carparkManager.dto.PaymentsDTO;
import lk.ijse.carparkManager.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentsDAO extends CrudDAO<Payment> {

}
