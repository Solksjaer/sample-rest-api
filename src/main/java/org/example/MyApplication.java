package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author <a href="mailto:opinilla@gmail.com">Oscar Pinilla</a>, <a href="https://github.com/Solksjaer">GitHub</a>
 */
@SpringBootApplication(scanBasePackages = "org.example")
public class MyApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyApplication.class);
    }
}