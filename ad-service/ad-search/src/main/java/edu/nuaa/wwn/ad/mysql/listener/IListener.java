package edu.nuaa.wwn.ad.mysql.listener;

import edu.nuaa.wwn.ad.mysql.dto.BinlogRowData;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 11:09
 */
public interface IListener {

    void register();

    void onEvent(BinlogRowData eventData);
}
