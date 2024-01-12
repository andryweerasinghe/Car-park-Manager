/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/12/24

 */

package lk.ijse.carparkManager.entity;

public class VehicleTicketDetails {
    String vehicle_id;
    String ticket_id;

    public VehicleTicketDetails(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public VehicleTicketDetails(String vehicle_id, String ticket_id) {
        this.vehicle_id = vehicle_id;
        this.ticket_id = ticket_id;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }
}
