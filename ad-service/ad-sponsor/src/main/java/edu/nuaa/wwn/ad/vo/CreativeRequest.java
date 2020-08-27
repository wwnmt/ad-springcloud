package edu.nuaa.wwn.ad.vo;

import edu.nuaa.wwn.ad.entity.CreativePO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 11:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeRequest {

    private String name;
    private Byte type;
    private Byte materialType;
    private Integer height;
    private Integer width;
    private Long size;
    private Integer duration;
    private Long userId;
    private String url;

    public boolean validate() {
        return name != null && type != null && materialType != null
                && height != null && width != null && size != null
                && duration != null && userId != null && url != null;
    }

    public CreativePO convertToEntity() {
        CreativePO creativePO = new CreativePO();
        creativePO.setWidth(width);
        creativePO.setUserId(userId);
        creativePO.setUrl(url);
        creativePO.setUpdateTime(new Date());
        creativePO.setType(type);
        creativePO.setSize(size);
        creativePO.setName(name);
        creativePO.setMaterialType(materialType);
        creativePO.setHeight(height);
        creativePO.setDuration(duration);
        creativePO.setCreateTime(creativePO.getUpdateTime());
        return creativePO;
    }
}
