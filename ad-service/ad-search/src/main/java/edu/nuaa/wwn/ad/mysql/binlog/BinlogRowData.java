package edu.nuaa.wwn.ad.mysql.binlog;

import com.github.shyiko.mysql.binlog.event.EventType;
import edu.nuaa.wwn.ad.mysql.dto.TableTemplate;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 11:07
 */
@Data
public class BinlogRowData {

    private TableTemplate table;

    private EventType eventType;

    private List<Map<String, String>> after;

    private List<Map<String, String>> before;
}
