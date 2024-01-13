/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 11/28/23

 */

package lk.ijse.carparkManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RatesDTO {
    int id;
    String vehicle_type;
    double rate_per_hour;
}
