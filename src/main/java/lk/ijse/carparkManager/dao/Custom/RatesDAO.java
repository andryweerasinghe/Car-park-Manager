package lk.ijse.carparkManager.dao.Custom;

import lk.ijse.carparkManager.dao.CrudDAO;
import lk.ijse.carparkManager.entity.Rates;

import java.sql.SQLException;

public interface RatesDAO  {
    double getRate(String type) throws SQLException, ClassNotFoundException;
}
