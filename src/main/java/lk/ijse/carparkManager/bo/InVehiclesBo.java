package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dto.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

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
    ArrayList<VehicleDTO> getVehicleData() throws SQLException, ClassNotFoundException;
    boolean saveCheckoutVehicle(OutgoingVehiclesDTO outgoingVehiclesDTO) throws SQLException, ClassNotFoundException;
    ResultSet getTicketData(int slot_id) throws SQLException, ClassNotFoundException;
}
