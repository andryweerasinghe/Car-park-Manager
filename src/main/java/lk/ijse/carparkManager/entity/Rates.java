/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/11/24

 */

package lk.ijse.carparkManager.entity;

public class Rates {
    int id;
    String vehicle_type;
    double rate_per_hour;

    public Rates(int id, String vehicle_type, double rate_per_hour) {
        this.id = id;
        this.vehicle_type = vehicle_type;
        this.rate_per_hour = rate_per_hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public double getRate_per_hour() {
        return rate_per_hour;
    }

    public void setRate_per_hour(double rate_per_hour) {
        this.rate_per_hour = rate_per_hour;
    }
}
