/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/11/24

 */

package lk.ijse.carparkManager.bo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.carparkManager.dao.Custom.VehicleDAO;
import lk.ijse.carparkManager.dao.DAOFactory;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleBoImpl implements VehicleBo {
    VehicleDAO vehicleDAO = (VehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLE);
    public ArrayList<VehicleDTO> getVehicleData() throws SQLException, ClassNotFoundException {
        ArrayList<Vehicle> vehicles = vehicleDAO.getAll();
        ArrayList<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for(Vehicle vehicle:vehicles){
            vehicleDTOS.add(new VehicleDTO(vehicle.getId(), vehicle.getSlot_id(), vehicle.getVehicle_owner(), vehicle.getVehicle_no()));
        }
        return vehicleDTOS;
    }
    public boolean isAvailableSlot(String slotId) throws SQLException, ClassNotFoundException {
        return vehicleDAO.isAvailableSlot(slotId);
    }

    public VehicleDTO retrieveType(String id) throws SQLException, ClassNotFoundException {
        return vehicleDAO.retrieveType(id);
    }
    public void deleteVehicleRecord(String id) throws SQLException, ClassNotFoundException {
        vehicleDAO.deleteVehicleRecord(id);
    }
    public int getVehicleCount() throws SQLException, ClassNotFoundException {
        return vehicleDAO.getCount();
    }

    public VehicleDTO loadAllVehicleDetails(int slotId) throws SQLException, ClassNotFoundException {
        return vehicleDAO.getVehicleDetails(slotId);
    }
    public VehicleDTO getVehicleDetails(int slotId) throws SQLException, ClassNotFoundException {
        return vehicleDAO.getVehicleDetails(slotId);
    }
}
