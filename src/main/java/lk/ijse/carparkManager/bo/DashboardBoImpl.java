/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/13/24

 */

package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dao.Custom.OutgoingVehiclesDAO;
import lk.ijse.carparkManager.dao.Custom.VehicleDAO;
import lk.ijse.carparkManager.dao.DAOFactory;
import lk.ijse.carparkManager.dao.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardBoImpl implements DashboardBo{
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    OutgoingVehiclesDAO outgoingVehiclesDAO = (OutgoingVehiclesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.OUTGOING_VEHICLES);

    public int getVehiclesInCount() throws SQLException, ClassNotFoundException {
        return vehicleDAO.getCount();
    }
    public int getOutgoingVehiclesCount() throws SQLException, ClassNotFoundException {
        return outgoingVehiclesDAO.getCount();
    }
}
