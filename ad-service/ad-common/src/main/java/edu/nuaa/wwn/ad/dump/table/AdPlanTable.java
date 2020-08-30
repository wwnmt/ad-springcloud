package edu.nuaa.wwn.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 14:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanTable {

    private Long id;
    private Long userId;
    private Byte planStatus;
    private Date startDate;
    private Date endDate;
}
