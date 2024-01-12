/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/11/24

 */

package lk.ijse.carparkManager.entity;

public class Ticket {
    String ticket_id;
    String status;
    String duration;

    public Ticket(String ticket_id, String status, String duration) {
        this.ticket_id = ticket_id;
        this.status = status;
        this.duration = duration;
    }

    public Ticket(String ticketId, String status) {
        this.ticket_id = ticketId;
        this.status = status;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
