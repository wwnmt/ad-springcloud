package edu.nuaa.wwn.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 14:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeTable {

    private Long adId;
    private String name;
    private Byte type;
    private Byte materialType;
    private Integer height;
    private Integer width;
    private Byte auditStatus;
    private String url;
}
