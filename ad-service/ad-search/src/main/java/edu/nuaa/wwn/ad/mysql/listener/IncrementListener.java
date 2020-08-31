package edu.nuaa.wwn.ad.mysql.listener;

import com.github.shyiko.mysql.binlog.event.EventType;
import edu.nuaa.wwn.ad.mysql.constant.Constant;
import edu.nuaa.wwn.ad.mysql.constant.OpType;
import edu.nuaa.wwn.ad.mysql.dto.BinlogRowData;
import edu.nuaa.wwn.ad.mysql.dto.MysqlRowData;
import edu.nuaa.wwn.ad.mysql.dto.TableTemplate;
import edu.nuaa.wwn.ad.sender.ISender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 14:25
 */
@Slf4j
@Component
public class IncrementListener implements IListener{

    @Resource(name = "indexSender")
    private ISender sender;

    private final AggregationListener aggregationListener;

    @Autowired
    public IncrementListener(AggregationListener aggregationListener) {
        this.aggregationListener = aggregationListener;
    }

    @Override
    @PostConstruct
    public void register() {
        log.info("IncrementList register db and table info");
        Constant.table2Db.forEach(
                (k, v) -> aggregationListener.register(v, k, this));
    }

    @Override
    public void onEvent(BinlogRowData eventData) {
        TableTemplate table = eventData.getTable();
        EventType eventType = eventData.getEventType();

        //包装数据
        MysqlRowData rowData = new MysqlRowData();

        rowData.setTableName(table.getTableName());
        rowData.setLevel(eventData.getTable().getLevel());
        OpType opType = OpType.to(eventType);
        rowData.setOpType(opType);

        //取出模板中该操作对应的字段列表
        List<String> fieldList = table.getOpTypeFieldSetMap().get(opType);
        if (null == fieldList) {
            log.warn("{} not support for {}", opType, table.getTableName());
            return;
        }

        for (Map<String, String> afterMap : eventData.getAfter()) {
            Map<String, String> _afterMap = new HashMap<>();

            for (Map.Entry<String, String> entry : afterMap.entrySet()) {
                String colName = entry.getKey();
                String colValue = entry.getValue();
                _afterMap.put(colName, colValue);
            }

            rowData.getFieldValueMap().add(_afterMap);
        }

        sender.send(rowData);
    }
}
