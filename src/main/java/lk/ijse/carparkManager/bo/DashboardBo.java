package lk.ijse.carparkManager.bo;

import java.sql.SQLException;

public interface DashboardBo extends SuperBO{
    int getVehiclesInCount() throws SQLException, ClassNotFoundException;
    int getOutgoingVehiclesCount() throws SQLException, ClassNotFoundException;
}
