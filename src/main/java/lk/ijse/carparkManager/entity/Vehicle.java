/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/10/24

 */

package lk.ijse.carparkManager.entity;

public class Vehicle {
    String id;
    String vehicle_no;
    String type;
    String vehicle_owner;
    String slot_id;
    String brand;
    String mobile_no;
    String date;

    public Vehicle(String id, String vehicle_no, String type, String vehicle_owner, String slot_id, String brand, String mobile_no, String date) {
        this.id = id;
        this.vehicle_no = vehicle_no;
        this.type = type;
        this.vehicle_owner = vehicle_owner;
        this.slot_id = slot_id;
        this.brand = brand;
        this.mobile_no = mobile_no;
        this.date = date;
    }

    public Vehicle(String id, String vehicle_no, String type, String vehicle_owner, String slot_id, String brand, String mobile_no) {
        this.id = id;
        this.vehicle_no = vehicle_no;
        this.type = type;
        this.vehicle_owner = vehicle_owner;
        this.slot_id = slot_id;
        this.brand = brand;
        this.mobile_no = mobile_no;
    }

    public Vehicle(String id) {
        this.id=id;
    }

    public Vehicle(String type, String date) {
        this.type=type;
        this.date=date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
