/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/11/24

 */

package lk.ijse.carparkManager.bo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.carparkManager.dao.Custom.OutgoingVehiclesDAO;
import lk.ijse.carparkManager.dao.Custom.VehicleDAO;
import lk.ijse.carparkManager.dao.DAOFactory;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.dto.OutgoingVehiclesDTO;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.OutgoingVehicles;
import lk.ijse.carparkManager.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBoImpl implements VehicleBo {
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    OutgoingVehiclesDAO outgoingVehiclesDAO = (OutgoingVehiclesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.OUTGOING_VEHICLES);
    public VehicleDTO getVehicleDetails(int slotId) throws SQLException, ClassNotFoundException {
        return vehicleDAO.getVehicleDetails(slotId);
    }
    public ArrayList<OutgoingVehiclesDTO> getCheckOutData() throws SQLException, ClassNotFoundException {
        ArrayList<OutgoingVehicles> checkedOutVehicles = outgoingVehiclesDAO.getCheckOutData();
        ArrayList<OutgoingVehiclesDTO> outgoingVehiclesDTOS = new ArrayList<>();
        for(OutgoingVehicles outgoingVehicles:checkedOutVehicles){
            outgoingVehiclesDTOS.add(new OutgoingVehiclesDTO(outgoingVehicles.getOutgoing_vehicle_id(), outgoingVehicles.getSlot_id(), outgoingVehicles.getVehicle_owner(), outgoingVehicles.getVehicle_no()));
        }
        return outgoingVehiclesDTOS;
    }
}
