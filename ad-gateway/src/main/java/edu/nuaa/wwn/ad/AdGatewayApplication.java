package edu.nuaa.wwn.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-25
 * Time: 11:36
 */

@EnableZuulProxy
@SpringBootApplication
public class AdGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdGatewayApplication.class, args);
    }
}
