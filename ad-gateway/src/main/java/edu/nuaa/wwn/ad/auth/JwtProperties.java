package edu.nuaa.wwn.ad.auth;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-09-03
 * Time: 16:31
 */
@Data
@Configuration
@ConfigurationProperties(prefix = JwtProperties.JWT_PREFIX)
public class JwtProperties {

    public static final String JWT_PREFIX = "jwt";

    @Value(value = "${jwt.header}")
    private String header;

    @Value(value = "${jwt.secret}")

    private String secret;

    @Value(value = "${jwt.expiration}")
    private Long expiration;

    @Value(value = "${jwt.auth-path}")
    private String authPath;

    @Value(value = "${jwt.md5-key}")
    private String md5Key;
}
