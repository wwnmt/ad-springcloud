package edu.nuaa.wwn.ad.index.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 13:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitDistrictObject {

    private Long unitId;
    private String province;
    private String city;
}
