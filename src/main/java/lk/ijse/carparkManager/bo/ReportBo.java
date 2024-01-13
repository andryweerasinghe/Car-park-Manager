package lk.ijse.carparkManager.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface ReportBo extends SuperBO{
    ResultSet getDataBetweenDates(LocalDate startDate, LocalDate endDate) throws SQLException, ClassNotFoundException;
}
