/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/17/23

 */

package lk.ijse.carparkManager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ParkingSlotDTO {
    String id;
    String status;
}
