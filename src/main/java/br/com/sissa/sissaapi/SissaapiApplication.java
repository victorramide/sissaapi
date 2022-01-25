package br.com.sissa.sissaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class SissaapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SissaapiApplication.class, args);
    }

}
