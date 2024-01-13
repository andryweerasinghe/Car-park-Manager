/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/13/24

 */

package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dao.Custom.OutgoingVehiclesDAO;
import lk.ijse.carparkManager.dao.DAOFactory;
import lk.ijse.carparkManager.dao.SQLUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReportBoImpl implements ReportBo{
    OutgoingVehiclesDAO outgoingVehiclesDAO = (OutgoingVehiclesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.OUTGOING_VEHICLES);
    public ResultSet getDataBetweenDates(LocalDate startDate, LocalDate endDate) throws SQLException, ClassNotFoundException {
        return outgoingVehiclesDAO.getDataBetweenDates(startDate, endDate);
    }
}
