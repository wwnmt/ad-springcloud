package edu.nuaa.wwn.ad.mysql;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.constant.OpType;
import edu.nuaa.wwn.ad.dto.ParseTemplate;
import edu.nuaa.wwn.ad.dto.TableTemplate;
import edu.nuaa.wwn.ad.dto.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 10:49
 */
@Slf4j
@Component
public class TemplateHolder {

    private ParseTemplate template;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TemplateHolder(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    private void init() {
        loadJson("template.json");
    }

    public TableTemplate getTable(String tableName) {
        return template.getTableTemplateMap().get(tableName);
    }

    private void loadJson(String path) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader .getResourceAsStream(path);
        try {
            assert inputStream != null;
            Template template = JSON.parseObject(
                    inputStream,
                    Charset.defaultCharset(),
                    Template.class
            );
            this.template = ParseTemplate.parse(template);
            loadMeta();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException("fail to parse json file");
        }
    }

    private void loadMeta() {
        for (Map.Entry<String, TableTemplate> entry :
                template.getTableTemplateMap().entrySet()) {
            TableTemplate tableTemplate = entry.getValue();
            List<String> updateFields = tableTemplate.getOpTypeFieldSetMap().get(
                    OpType.UPDATE
            );
            List<String> addFields = tableTemplate.getOpTypeFieldSetMap().get(
                    OpType.ADD
            );
            List<String> deleteFields = tableTemplate.getOpTypeFieldSetMap().get(
                    OpType.DELETE
            );

            String SQL_SCHEMA = "select table_schema, table_name, " +
                    "column_name, ordinal_position from information_schema.columns " +
                    "where table_schema= ? and table_name = ?";

            jdbcTemplate.query(SQL_SCHEMA, new Object[]{
                    template.getDatabase(), tableTemplate.getTableName()
            }, (resultSet,  i) -> {
                int pos = resultSet.getInt("ORDINAL_POSITION");
                String colName = resultSet.getString("COLUMN_NAME");

                if ((null != updateFields && updateFields.contains(colName))
                        || (null != addFields && addFields.contains(colName))
                        || (null != deleteFields && deleteFields.contains(colName))) {
                            tableTemplate.getPosMap().put(pos-1, colName);
                }
                return null;
            });
        }
    }
}
