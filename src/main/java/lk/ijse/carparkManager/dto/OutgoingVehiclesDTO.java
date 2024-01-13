/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/30/23

 */

package lk.ijse.carparkManager.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OutgoingVehiclesDTO {
    private final StringProperty outgoing_vehicle_id= new SimpleStringProperty();
    private final StringProperty vehicle_no = new SimpleStringProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final StringProperty vehicle_owner = new SimpleStringProperty();
    private final StringProperty slot_id = new SimpleStringProperty();
    private final StringProperty duration = new SimpleStringProperty();
    private final StringProperty parking_fee = new SimpleStringProperty();
    private final StringProperty ticket_id = new SimpleStringProperty();

    public String getTicket_id() {
        return ticket_id.get();
    }

    public StringProperty ticket_idProperty() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id.set(ticket_id);
    }

    public void setOutgoing_vehicle_id(String outgoing_vehicle_id) {
        this.outgoing_vehicle_id.set(outgoing_vehicle_id);
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no.set(vehicle_no);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setVehicle_owner(String vehicle_owner) {
        this.vehicle_owner.set(vehicle_owner);
    }

    public void setSlot_id(String slot_id) {
        this.slot_id.set(slot_id);
    }

    public void setDuration(String duration) {
        this.duration.set(duration);
    }

    public void setParking_fee(String parking_fee) {
        this.parking_fee.set(parking_fee);
    }

    public String getOutgoing_vehicle_id() {
        return outgoing_vehicle_id.get();
    }

    public StringProperty outgoing_vehicle_idProperty() {
        return outgoing_vehicle_id;
    }

    public String getVehicle_no() {
        return vehicle_no.get();
    }

    public StringProperty vehicle_noProperty() {
        return vehicle_no;
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public String getVehicle_owner() {
        return vehicle_owner.get();
    }

    public StringProperty vehicle_ownerProperty() {
        return vehicle_owner;
    }

    public String getSlot_id() {
        return slot_id.get();
    }

    public StringProperty slot_idProperty() {
        return slot_id;
    }

    public String getDuration() {
        return duration.get();
    }

    public StringProperty durationProperty() {
        return duration;
    }

    public String getParking_fee() {
        return parking_fee.get();
    }

    public StringProperty parking_feeProperty() {
        return parking_fee;
    }

    public OutgoingVehiclesDTO(String outgoing_vehicle_id, String slot_id, String vehicle_owner, String vehicle_no) {
        setOutgoing_vehicle_id(outgoing_vehicle_id);
        setSlot_id(slot_id);
        setVehicle_owner(vehicle_owner);
        setVehicle_no(vehicle_no);
    }
    public OutgoingVehiclesDTO(String outgoing_vehicle_id, String vehicle_no, String type, String vehicle_owner, String slot_id, String duration, String parking_fee, String ticket_id){
        setOutgoing_vehicle_id(outgoing_vehicle_id);
        setVehicle_no(vehicle_no);
        setType(type);
        setVehicle_owner(vehicle_owner);
        setSlot_id(slot_id);
        setDuration(duration);
        setParking_fee(parking_fee);
        setTicket_id(ticket_id);
    }
}
