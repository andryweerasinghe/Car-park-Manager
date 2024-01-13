/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/13/24

 */

package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dao.Custom.ParkingSpaceDAO;
import lk.ijse.carparkManager.dao.DAOFactory;
import lk.ijse.carparkManager.dao.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingSpaceBoImpl implements ParkingSpaceBo{
    ParkingSpaceDAO parkingSpaceDAO = (ParkingSpaceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PARKING_SPACE);
    public boolean checkSlotStatus(int slotId) throws SQLException, ClassNotFoundException {
        return parkingSpaceDAO.checkStatus(slotId);
    }
}
