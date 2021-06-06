package com.zhonyang.scrum.backlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author alan
 */
@EnableOpenApi
@SpringBootApplication
public class ScrumBacklogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrumBacklogApplication.class, args);
    }

}
