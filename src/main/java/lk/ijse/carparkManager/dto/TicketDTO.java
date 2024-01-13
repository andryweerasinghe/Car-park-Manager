/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/23/23

 */

package lk.ijse.carparkManager.dto;

import lombok.*;

import java.time.Duration;
import java.time.LocalTime;

//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class TicketDTO {
    int ticket_id;
    String status;
    String duration;

    public TicketDTO(int ticket_id, String duration, String status) {
        this.ticket_id = ticket_id;
        this.duration = duration;
        this.status = status;
    }
    public TicketDTO(int ticket_id, String status) {
        this.ticket_id = ticket_id;
        this.status = status;
    }
}
