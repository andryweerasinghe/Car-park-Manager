/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/30/23

 */

package lk.ijse.carparkManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleTicketDetailsDTO {
    int vehicle_id;
    int ticket_id;

    public VehicleTicketDetailsDTO(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }
}
