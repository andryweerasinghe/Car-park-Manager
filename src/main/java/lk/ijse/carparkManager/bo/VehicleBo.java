package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBo extends SuperBO{
    ArrayList<VehicleDTO> getVehicleData() throws SQLException, ClassNotFoundException;
    VehicleDTO retrieveType(String id) throws SQLException, ClassNotFoundException;
    void deleteVehicleRecord(String id) throws SQLException, ClassNotFoundException;
    int getVehicleCount() throws SQLException, ClassNotFoundException;
    VehicleDTO loadAllVehicleDetails(int slotId) throws SQLException, ClassNotFoundException;
    VehicleDTO getVehicleDetails(int slotId) throws SQLException, ClassNotFoundException;


}
