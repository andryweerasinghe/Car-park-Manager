package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dto.PaymentsDTO;
import lk.ijse.carparkManager.dto.TicketDTO;
import lk.ijse.carparkManager.dto.TicketSpaceDetailsDTO;
import lk.ijse.carparkManager.dto.VehicleDTO;

import java.sql.SQLException;
import java.time.LocalTime;

public interface InVehiclesBo extends SuperBO{
    boolean saveDuration(TicketDTO ticketDTO) throws SQLException, ClassNotFoundException;
    LocalTime getEntryTimeForVehicle(String id) throws SQLException, ClassNotFoundException;
    void saveCheckOut(TicketSpaceDetailsDTO ticketSpaceDetailsDTO) throws SQLException, ClassNotFoundException;
    void updateSlotVacant(int slotId) throws SQLException, ClassNotFoundException;
    double getRate(String type) throws SQLException, ClassNotFoundException;
    String generateNextPaymentId() throws SQLException, ClassNotFoundException;
    boolean savePayment(PaymentsDTO paymentsDTO) throws SQLException, ClassNotFoundException;
    String getTicketId(String vehicleId) throws SQLException, ClassNotFoundException;
    VehicleDTO retrieveType(String id) throws SQLException, ClassNotFoundException;
    void deleteVehicleRecord(String id) throws SQLException, ClassNotFoundException;
}
