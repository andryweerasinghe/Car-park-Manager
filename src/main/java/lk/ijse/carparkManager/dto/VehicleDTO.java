package lk.ijse.carparkManager.dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VehicleDTO {
    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty vehicle_no = new SimpleStringProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final StringProperty vehicle_owner = new SimpleStringProperty();
    private final StringProperty slot_id = new SimpleStringProperty();
    private final StringProperty brand = new SimpleStringProperty();
    private final StringProperty mobile_no = new SimpleStringProperty();
    private final StringProperty date = new SimpleStringProperty();

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getBrand() {
        return brand.get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getMobile_no() {
        return mobile_no.get();
    }

    public StringProperty mobile_noProperty() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no.set(mobile_no);
    }

    public String getVehicle_no() {
        return vehicle_no.get();
    }

    public StringProperty vehicle_noProperty() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no.set(vehicle_no);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getVehicle_owner() {
        return vehicle_owner.get();
    }

    public StringProperty vehicle_ownerProperty() {
        return vehicle_owner;
    }

    public void setVehicle_owner(String vehicle_owner) {
        this.vehicle_owner.set(vehicle_owner);
    }

    public String getSlot_id() {
        return slot_id.get();
    }

    public StringProperty slot_idProperty() {
        return slot_id;
    }

    public void setSlot_id(String slot_id) {
        this.slot_id.set(slot_id);
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }
    public VehicleDTO(String id, String vehicle_no, String type , String vehicle_owner, String slot_id, String brand, String mobile_no) {
        setId(id);
        setVehicle_no(vehicle_no);
        setType(type);
        setVehicle_owner(vehicle_owner);
        setSlot_id(slot_id);
        setBrand(brand);
        setMobile_no(mobile_no);
    }
    public VehicleDTO(String id, String slot_id ,String vehicle_owner, String vehicle_no) {
        setId(id);
        setVehicle_no(vehicle_no);
        setVehicle_owner(vehicle_owner);
        setSlot_id(slot_id);
    }
    public VehicleDTO(String type, String date){
        setType(type);
        setDate(date);
    }
    public VehicleDTO(String id){
        setId(id);
    }

}
