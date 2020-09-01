package edu.nuaa.wwn.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 17:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    //设备id
    private String deviceCode;
    //设备mac
    private String mac;
    //设备ip
    private String ip;
    //机型编码
    private String model;
    //分辨率尺寸
    private String displaySize;
    //屏幕尺寸
    private String screenSize;
    //设备序列号
    private String serialNumber;
}
