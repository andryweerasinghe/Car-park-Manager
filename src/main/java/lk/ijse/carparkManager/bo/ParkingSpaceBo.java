package lk.ijse.carparkManager.bo;

import java.sql.SQLException;

public interface ParkingSpaceBo extends SuperBO{
    boolean checkSlotStatus(int slotId) throws SQLException, ClassNotFoundException;
}
