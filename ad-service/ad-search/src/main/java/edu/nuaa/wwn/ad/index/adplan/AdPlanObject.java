package edu.nuaa.wwn.ad.index.adplan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 12:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanObject {

    private Long planId;
    private Long userId;
    private Byte planStatus;
    private Date startDate;
    private Date endDate;

    public void update(AdPlanObject newObject) {
        if (null != newObject.getPlanId()) {
            this.planId = newObject.getPlanId();
        }
        if (null != newObject.getUserId()) {
            this.userId = newObject.getUserId();
        }
        if (null != newObject.getPlanStatus()) {
            this.planStatus = newObject.getPlanStatus();
        }
        if (null != newObject.getStartDate()) {
            this.startDate = newObject.getStartDate();
        }
        if (null != newObject.getEndDate()) {
            this.endDate = newObject.getEndDate();
        }
    }
}
