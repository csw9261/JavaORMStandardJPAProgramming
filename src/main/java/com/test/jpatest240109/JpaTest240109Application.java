package com.test.jpatest240109;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JpaTest240109Application {

    public static void main(String[] args) {
        SpringApplication.run(JpaTest240109Application.class, args);
    }

}
