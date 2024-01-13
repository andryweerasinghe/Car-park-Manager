/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/13/24

 */

package lk.ijse.carparkManager.tm;

public class VehiclesInTm {
    String vehicle_id;
    String slot_id;
    String vehicle_owner;
    String vehicle_no;

    public VehiclesInTm(String vehicle_id, String slot_id, String vehicle_owner, String vehicle_no) {
        this.vehicle_id = vehicle_id;
        this.slot_id = slot_id;
        this.vehicle_owner = vehicle_owner;
        this.vehicle_no = vehicle_no;
    }

    @Override
    public String toString() {
        return "VehiclesInTm{" +
                "vehicle_id='" + vehicle_id + '\'' +
                ", slot_id=" + slot_id +
                ", vehicle_owner='" + vehicle_owner + '\'' +
                ", vehicle_no='" + vehicle_no + '\'' +
                '}';
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(String slot_id) {
        this.slot_id = slot_id;
    }

    public String getVehicle_owner() {
        return vehicle_owner;
    }

    public void setVehicle_owner(String vehicle_owner) {
        this.vehicle_owner = vehicle_owner;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }
}
