package lk.ijse.carparkManager.dao.Custom;

import com.jfoenix.controls.JFXButton;
import lk.ijse.carparkManager.dao.CrudDAO;
import lombok.experimental.SuperBuilder;

import java.sql.SQLException;

public interface ParkingSpaceDAO {
    void assignSlot(JFXButton[] buttonsArray) throws SQLException, ClassNotFoundException;
    void updateButtonStatus(JFXButton jfxButton, String status);
    void updateSlotStatusById(String slotId) throws SQLException, ClassNotFoundException;
    void updateSlotVacant(int slotId) throws SQLException, ClassNotFoundException;
    boolean checkStatus(int slotId) throws SQLException, ClassNotFoundException;
}