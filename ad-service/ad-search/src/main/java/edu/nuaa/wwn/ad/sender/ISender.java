package edu.nuaa.wwn.ad.sender;


import edu.nuaa.wwn.ad.binlog.MysqlRowData;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 14:25
 */
public interface ISender {

    void send(MysqlRowData rowData);
}
