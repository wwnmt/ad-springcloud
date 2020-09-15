package edu.nuaa.wwn.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-09-14
 * Time: 17:21
 */
@EnableEurekaClient
@SpringBootApplication
public class BinlogKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BinlogKafkaApplication.class, args);
    }
}
