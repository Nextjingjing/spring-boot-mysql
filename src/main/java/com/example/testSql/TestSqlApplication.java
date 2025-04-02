package com.example.testSql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TestSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSqlApplication.class, args);
    }

    @Component
    public class StartupMessage {
        @EventListener(ApplicationReadyEvent.class)
        public void onApplicationReady() {
            System.out.println("Connected to database successfully!");
			System.out.println("Server is listening on http://localhost:8080");
        }
    }
}
