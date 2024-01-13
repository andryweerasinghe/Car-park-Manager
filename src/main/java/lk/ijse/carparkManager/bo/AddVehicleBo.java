package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dto.TicketDTO;
import lk.ijse.carparkManager.dto.TicketSpaceDetailsDTO;
import lk.ijse.carparkManager.dto.VehicleDTO;

import java.sql.SQLException;

public interface AddVehicleBo extends SuperBO{
    String generateNextVehicleId() throws SQLException, ClassNotFoundException;
    boolean isAvailableSlot(int slotId) throws SQLException, ClassNotFoundException;
    boolean saveNewVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;
    void updateSlotStatusById(int slotId) throws SQLException, ClassNotFoundException;
    String generateNextTicketId() throws SQLException, ClassNotFoundException;
    boolean saveCheckIn(TicketDTO ticketDTO) throws SQLException, ClassNotFoundException;
    void saveCheckInTime(TicketSpaceDetailsDTO ticketSpaceDetailsDTO) throws SQLException, ClassNotFoundException;
}
