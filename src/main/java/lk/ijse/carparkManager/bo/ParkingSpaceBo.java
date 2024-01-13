package lk.ijse.carparkManager.bo;

import com.jfoenix.controls.JFXButton;

import java.sql.SQLException;

public interface ParkingSpaceBo extends SuperBO{
    boolean checkSlotStatus(int slotId) throws SQLException, ClassNotFoundException;
    void assignSlot(JFXButton[] buttonsArray) throws SQLException, ClassNotFoundException;
}
