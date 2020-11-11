package com.chuweizi.script;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author 36536
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SmartCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartCommunityApplication.class, args);
    }
}
