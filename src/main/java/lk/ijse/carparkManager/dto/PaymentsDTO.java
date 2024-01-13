/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/28/23

 */

package lk.ijse.carparkManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PaymentsDTO {
    int id;
    String type;
    double amount;
    int ticket_id;

    public PaymentsDTO(int id, double amount, int ticket_id) {
        this.id = id;
        this.amount = amount;
        this.ticket_id = ticket_id;
    }
}