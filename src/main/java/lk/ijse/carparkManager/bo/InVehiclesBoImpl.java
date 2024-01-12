/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/12/24

 */

package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dao.Custom.*;
import lk.ijse.carparkManager.dao.DAOFactory;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.dto.PaymentsDTO;
import lk.ijse.carparkManager.dto.TicketDTO;
import lk.ijse.carparkManager.dto.TicketSpaceDetailsDTO;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.Payment;
import lk.ijse.carparkManager.entity.Ticket;
import lk.ijse.carparkManager.entity.TicketSpaceDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class InVehiclesBoImpl implements InVehiclesBo{
    TicketDAO ticketDAO = (TicketDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TICKET);
    TicketSpaceDetailsDAO ticketSpaceDetailsDAO = (TicketSpaceDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TICKET_SPACE_DETAILS);
    ParkingSpaceDAO parkingSpaceDAO = (ParkingSpaceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PARKING_SPACE);
    RatesDAO ratesDAO = (RatesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RATES);
    PaymentsDAO paymentsDAO = (PaymentsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENTS);
    VehicleTicketDetailsDAO vehicleTicketDetailsDAO = (VehicleTicketDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE_TICKET_DETAILS);
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    public boolean saveDuration(TicketDTO ticketDTO) throws SQLException, ClassNotFoundException {
        Ticket ticket = new Ticket(ticketDTO.getTicket_id(), ticketDTO.getStatus(), ticketDTO.getDuration());
        return ticketDAO.saveCheckOut(ticket);
    }
    public LocalTime getEntryTimeForVehicle(String id) throws SQLException, ClassNotFoundException {
        return ticketSpaceDetailsDAO.getEntryTimeForVehicle(id);
    }
    public void saveCheckOut(TicketSpaceDetailsDTO ticketSpaceDetailsDTO) throws SQLException, ClassNotFoundException {
        TicketSpaceDetails ticketSpaceDetails = new TicketSpaceDetails(ticketSpaceDetailsDTO.getSpace_id(), ticketSpaceDetailsDTO.getExit_time());
        ticketSpaceDetailsDAO.saveCheckOut(ticketSpaceDetails);
    }
    public void updateSlotVacant(int slotId) throws SQLException, ClassNotFoundException {
        parkingSpaceDAO.updateSlotVacant(slotId);
    }
    public double getRate(String type) throws SQLException, ClassNotFoundException {
        return ratesDAO.getRate(type);
    }
    public String generateNextPaymentId() throws SQLException, ClassNotFoundException {
        return parkingSpaceDAO.generateNextId();
    }
    public boolean savePayment(PaymentsDTO paymentsDTO) throws SQLException, ClassNotFoundException {
        Payment payment = new Payment(paymentsDTO.getId(), paymentsDTO.getAmount(), paymentsDTO.getTicket_id());
        return paymentsDAO.save(payment);
    }
    public String getTicketId(String vehicleId) throws SQLException, ClassNotFoundException {
        return vehicleTicketDetailsDAO.getTicketId(vehicleId);
    }
    public VehicleDTO retrieveType(String id) throws SQLException, ClassNotFoundException {
        return vehicleDAO.retrieveType(id);
    }
    public void deleteVehicleRecord(String id) throws SQLException, ClassNotFoundException {
        vehicleDAO.deleteVehicleRecord(id);
    }
}
