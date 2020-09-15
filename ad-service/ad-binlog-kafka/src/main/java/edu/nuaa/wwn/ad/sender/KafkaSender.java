package edu.nuaa.wwn.ad.sender;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.binlog.MysqlRowData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-31
 * Time: 15:16
 */
@Slf4j
@Component
public class KafkaSender implements ISender{

    @Value("${adconf.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

//    @Autowired
    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(MysqlRowData rowData) {
        log.info("binlog kafka service send MySQL data.");
        kafkaTemplate.send(
                topic, JSON.toJSONString(rowData)
        );
    }

//    @KafkaListener(topics = {"kk"}, groupId = "ad-search")
//    public void processMysqlRowData(ConsumerRecord<?, ?> record) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            MysqlRowData rowData = JSON.parseObject(
//                    message.toString(),
//                    MysqlRowData.class
//            );
//            System.out.println("kafka processMysqlRowData: " +
//                    JSON.toJSONString(rowData));
//        }
//    }
}
