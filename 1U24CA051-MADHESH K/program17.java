// Practical 17: REST API with GET method - prints "Hello Java"
//
// Spring Boot project (Maven/Gradle) with the "Spring Web" dependency.
// Run the main method, then open:  http://localhost:8080/hello
package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class program17 {

    public static void main(String[] args) {
        SpringApplication.run(program17.class, args);
    }

    @RestController
    @RequestMapping("/hello")
    public static class HelloController {

        @GetMapping
        public String sayHello() {
            return "Hello Java";
        }
    }
}
