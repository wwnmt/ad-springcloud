package edu.nuaa.wwn.ad;

import edu.nuaa.wwn.ad.constant.CommonStatus;
import edu.nuaa.wwn.ad.dao.PlanPOMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-26
 * Time: 17:33
 */
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = "edu.nuaa.wwn.ad.dao")
public class SponsorApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SponsorApplication.class, args);
        PlanPOMapper planPOMapper = context.getBean(PlanPOMapper.class);
        System.out.println(planPOMapper.findAllByStatus(CommonStatus.VALID.getStatus()));
    }
}
