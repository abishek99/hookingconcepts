package org.hookingconcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"org.hookingconcepts.repo"})
@EnableCaching
public class HookingconceptsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HookingconceptsApplication.class, args);
    }

}