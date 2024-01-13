/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/21/23

 */

package lk.ijse.carparkManager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketSpaceDetailsDTO {
    int ticket_id;
    int space_id;
    LocalTime entry_time;
    LocalTime exit_time;

    public TicketSpaceDetailsDTO(int space_id, LocalTime exit_time) {
        this.space_id = space_id;
        this.exit_time = exit_time;
    }

    public TicketSpaceDetailsDTO(int ticket_id, int space_id, LocalTime entry_time) {
        this.ticket_id = ticket_id;
        this.space_id = space_id;
        this.entry_time = entry_time;
    }
}
