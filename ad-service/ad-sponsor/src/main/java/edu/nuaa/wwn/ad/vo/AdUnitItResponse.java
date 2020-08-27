package edu.nuaa.wwn.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 10:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitItResponse {
    private List<Long> ids;
}
