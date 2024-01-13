/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/13/24

 */

package lk.ijse.carparkManager.dao.Custom.Impl;

import lk.ijse.carparkManager.dao.Custom.OutgoingVehiclesDAO;
import lk.ijse.carparkManager.dao.SQLUtil;
import lk.ijse.carparkManager.entity.OutgoingVehicles;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OutgoingVehiclesDAOImpl implements OutgoingVehiclesDAO {
    public boolean save(OutgoingVehicles outgoingVehicles) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OutgoingVehicles VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", outgoingVehicles.getOutgoing_vehicle_id(),
                outgoingVehicles.getVehicle_no(), outgoingVehicles.getType(), outgoingVehicles.getVehicle_owner(), outgoingVehicles.getSlot_id(), outgoingVehicles.getDuration(), outgoingVehicles.getParking_fee(), outgoingVehicles.getTicket_id(), outgoingVehicles.getDate());
    }

    public ArrayList<OutgoingVehicles> getCheckOutData() throws SQLException, ClassNotFoundException {
        ArrayList<OutgoingVehicles> list = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT outgoing_vehicle_id, slot_id, vehicle_owner, vehicle_no FROM OutgoingVehicles");

        while (resultSet.next()){
            list.add(new OutgoingVehicles(String.valueOf(resultSet.getString("outgoing_vehicle_id")), String.valueOf(resultSet.getInt("slot_id")), resultSet.getString("vehicle_owner"), resultSet.getString("vehicle_no")));
        }

        return list;
    }

    public int getCount() throws SQLException, ClassNotFoundException {
        int count = 0;
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) FROM OutgoingVehicles");

        if (resultSet.next()){
            count = resultSet.getInt(1);
            return count;
        }
        return -1;
    }
    public ResultSet getTicketData(int slot_id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT ticket_id, duration, parking_fee FROM OutgoingVehicles WHERE slot_id = ?", slot_id);
    }
    public ResultSet getDataBetweenDates(LocalDate startDate, LocalDate endDate) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT * FROM OutgoingVehicles WHERE date BETWEEN ? AND ?", Date.valueOf(startDate), Date.valueOf(endDate));
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean isValid(String userName, String pw) throws SQLException, ClassNotFoundException {
        return false;
    }
}
