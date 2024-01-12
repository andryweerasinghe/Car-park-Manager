/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/13/24

 */

package lk.ijse.carparkManager.entity;

public class Payment {
    String id;
    double amount;
    String ticket_id;

    public Payment(String id, double amount, String ticket_id) {
        this.id = id;
        this.amount = amount;
        this.ticket_id = ticket_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }
}
