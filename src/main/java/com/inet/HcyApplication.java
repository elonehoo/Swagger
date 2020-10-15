package com.inet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author HCY
 */
@EnableOpenApi
@SpringBootApplication
public class HcyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HcyApplication.class, args);
    }

}
