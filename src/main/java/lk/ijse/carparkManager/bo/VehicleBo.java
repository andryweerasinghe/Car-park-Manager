package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBo {
    public ArrayList<VehicleDTO> getVehicleData() throws SQLException, ClassNotFoundException;
    public boolean isAvailableSlot(String slotId) throws SQLException, ClassNotFoundException;
    public VehicleDTO retrieveType(String id) throws SQLException, ClassNotFoundException;
    public void deleteVehicleRecord(String id) throws SQLException, ClassNotFoundException;
    public int getVehicleCount() throws SQLException, ClassNotFoundException;
    public VehicleDTO loadAllVehicleDetails(int slotId) throws SQLException, ClassNotFoundException;
    public boolean saveVehicle(VehicleDTO vehicleDTO) throws SQLException, ClassNotFoundException;
    public String generateNextVehicleId() throws SQLException, ClassNotFoundException;
}
