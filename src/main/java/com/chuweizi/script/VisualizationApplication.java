package com.chuweizi.script;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class VisualizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisualizationApplication.class, args);
    }
}
