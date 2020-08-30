package edu.nuaa.wwn.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class AdUnitTable {

    private Long unitId;
    private Byte unitStatus;
    private Byte positionType;

    private Long planId;
}
