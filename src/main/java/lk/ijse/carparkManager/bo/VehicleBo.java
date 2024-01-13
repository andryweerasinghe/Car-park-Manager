package lk.ijse.carparkManager.bo;

import lk.ijse.carparkManager.dto.OutgoingVehiclesDTO;
import lk.ijse.carparkManager.dto.VehicleDTO;
import lk.ijse.carparkManager.entity.OutgoingVehicles;
import lk.ijse.carparkManager.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleBo extends SuperBO{
    VehicleDTO getVehicleDetails(int slotId) throws SQLException, ClassNotFoundException;
    ArrayList<OutgoingVehiclesDTO> getCheckOutData() throws SQLException, ClassNotFoundException;
}
