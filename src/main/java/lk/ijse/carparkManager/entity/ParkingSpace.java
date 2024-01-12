/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/12/24

 */

package lk.ijse.carparkManager.entity;

public class ParkingSpace {
    String id;
    String status;

    public ParkingSpace(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
