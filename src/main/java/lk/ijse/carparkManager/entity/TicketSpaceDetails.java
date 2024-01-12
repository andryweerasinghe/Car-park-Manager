/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/12/24

 */

package lk.ijse.carparkManager.entity;

import java.time.LocalTime;

public class TicketSpaceDetails {
    String ticket_id;
    String space_id;
    LocalTime entry_time;
    LocalTime exit_time;

    public TicketSpaceDetails(String ticket_id, String space_id, LocalTime entry_time, LocalTime exit_time) {
        this.ticket_id = ticket_id;
        this.space_id = space_id;
        this.entry_time = entry_time;
        this.exit_time = exit_time;
    }

    public TicketSpaceDetails(String ticketId, String spaceId, LocalTime entryTime) {
        this.ticket_id = ticketId;
        this.space_id = spaceId;
        this.entry_time = entryTime;
    }

    public TicketSpaceDetails(String spaceId, LocalTime exitTime) {
        this.space_id = spaceId;
        this.exit_time = exitTime;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getSpace_id() {
        return space_id;
    }

    public void setSpace_id(String space_id) {
        this.space_id = space_id;
    }

    public LocalTime getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(LocalTime entry_time) {
        this.entry_time = entry_time;
    }

    public LocalTime getExit_time() {
        return exit_time;
    }

    public void setExit_time(LocalTime exit_time) {
        this.exit_time = exit_time;
    }
}
