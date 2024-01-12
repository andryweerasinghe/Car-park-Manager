package lk.ijse.carparkManager.dao.Custom;

import com.jfoenix.controls.JFXButton;
import lk.ijse.carparkManager.dao.CrudDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.entity.ParkingSpace;
import lombok.experimental.SuperBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ParkingSpaceDAO extends CrudDAO<ParkingSpace>{
    void assignSlot(JFXButton[] buttonsArray) throws SQLException, ClassNotFoundException;
    void updateButtonStatus(JFXButton jfxButton, String status);
    void updateSlotStatus(int slotId) throws SQLException, ClassNotFoundException;
    void updateSlotVacant(int slotId) throws SQLException, ClassNotFoundException;
    boolean checkStatus(int slotId) throws SQLException, ClassNotFoundException;
}
