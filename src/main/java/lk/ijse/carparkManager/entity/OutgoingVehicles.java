/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/13/24

 */

package lk.ijse.carparkManager.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OutgoingVehicles {
    String outgoing_vehicle_id;
    String vehicle_no;
    String type;
    String vehicle_owner;
    String slot_id;
    String duration;
    String parking_fee;
    String ticket_id;
    String date;

    public OutgoingVehicles(String outgoing_vehicle_id, String vehicle_no, String type, String vehicle_owner, String slot_id, String duration, String parking_fee, String ticket_id, String date) {
        this.outgoing_vehicle_id = outgoing_vehicle_id;
        this.vehicle_no = vehicle_no;
        this.type = type;
        this.vehicle_owner = vehicle_owner;
        this.slot_id = slot_id;
        this.duration = duration;
        this.parking_fee = parking_fee;
        this.ticket_id = ticket_id;
        this.date = date;
    }

    public OutgoingVehicles(String outgoing_vehicle_id, String slot_id, String vehicle_owner, String vehicle_no) {
        this.outgoing_vehicle_id = outgoing_vehicle_id;
        this.vehicle_no = vehicle_no;
        this.vehicle_owner = vehicle_owner;
        this.slot_id = slot_id;
    }

    public String getOutgoing_vehicle_id() {
        return outgoing_vehicle_id;
    }

    public void setOutgoing_vehicle_id(String outgoing_vehicle_id) {
        this.outgoing_vehicle_id = outgoing_vehicle_id;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVehicle_owner() {
        return vehicle_owner;
    }

    public void setVehicle_owner(String vehicle_owner) {
        this.vehicle_owner = vehicle_owner;
    }

    public String getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(String slot_id) {
        this.slot_id = slot_id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getParking_fee() {
        return parking_fee;
    }

    public void setParking_fee(String parking_fee) {
        this.parking_fee = parking_fee;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
