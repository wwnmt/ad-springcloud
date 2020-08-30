package edu.nuaa.wwn.ad.index.creative;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 13:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeObject {

    private Long adId;
    private String creativeName;
    private Byte type;
    private Byte materialType;
    private Integer height;
    private Integer width;
    private Byte auditStatus;
    private String adUrl;

    public void update(CreativeObject newObject) {
        if (null != newObject.getAdId()) {
            this.adId = newObject.getAdId();
        }
        if (null != newObject.getCreativeName()) {
            this.creativeName = newObject.getCreativeName();
        }
        if (null != newObject.getType()) {
            this.type = newObject.getType();
        }
        if (null != newObject.getMaterialType()) {
            this.materialType = newObject.getMaterialType();
        }
        if (null != newObject.getHeight()) {
            this.height = newObject.getHeight();
        }
        if (null != newObject.getWidth()) {
            this.width = newObject.getWidth();
        }
        if (null != newObject.getAuditStatus()) {
            this.auditStatus = newObject.getAuditStatus();
        }
        if (null != newObject.getAdUrl()) {
            this.adUrl = newObject.getAdUrl();
        }
    }
}
