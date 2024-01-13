/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/12/24

 */

package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dao.Custom.*;
import lk.ijse.carparkManager.dao.DAOFactory;
import lk.ijse.carparkManager.dto.TicketDTO;
import lk.ijse.carparkManager.dto.TicketSpaceDetailsDTO;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.Ticket;
import lk.ijse.carparkManager.entity.TicketSpaceDetails;
import lk.ijse.carparkManager.entity.Vehicle;

import java.sql.*;

public class AddVehicleBoImpl implements AddVehicleBo{
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    ParkingSpaceDAO parkingSpaceDAO = (ParkingSpaceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PARKING_SPACE);
    TicketDAO ticketDAO = (TicketDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TICKET);
    TicketSpaceDetailsDAO ticketSpaceDetailsDAO = (TicketSpaceDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TICKET_SPACE_DETAILS);

    public String generateNextVehicleId() throws SQLException, ClassNotFoundException {
        return vehicleDAO.generateNextId();
    }
    public boolean isAvailableSlot(int slotId) throws SQLException, ClassNotFoundException {
        return vehicleDAO.isAvailableSlot(slotId);
    }
    public boolean saveNewVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException {
        Vehicle vehicle = new Vehicle(vehicleDTO.getId(), vehicleDTO.getVehicle_no(), vehicleDTO.getType(), vehicleDTO.getVehicle_owner(), vehicleDTO.getSlot_id(), vehicleDTO.getBrand(), vehicleDTO.getMobile_no(), vehicleDTO.getDate());
        return vehicleDAO.save(vehicle);
    }
    public void updateSlotStatusById(int slotId) throws SQLException, ClassNotFoundException {
        parkingSpaceDAO.updateSlotStatus(slotId);
    }
    public String generateNextTicketId() throws SQLException, ClassNotFoundException {
        return ticketDAO.generateNextId();
    }
    public boolean saveCheckIn(TicketDTO ticketDTO) throws SQLException, ClassNotFoundException {
        Ticket ticket = new Ticket(ticketDTO.getTicket_id(), ticketDTO.getStatus());
        return ticketDAO.save(ticket);
    }
    public void saveCheckInTime(TicketSpaceDetailsDTO ticketSpaceDetailsDTO) throws SQLException, ClassNotFoundException {
        TicketSpaceDetails ticketSpaceDetails = new TicketSpaceDetails(ticketSpaceDetailsDTO.getTicket_id(), ticketSpaceDetailsDTO.getSpace_id(), ticketSpaceDetailsDTO.getEntry_time());
        ticketSpaceDetailsDAO.saveCheckIn(ticketSpaceDetails);
    }
}
