package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = "org.example")
@ComponentScan
@Slf4j
public class MyConfiguration {

    @PostConstruct
    public void announceLoaded() {
        log.info(" ***** Application loaded. *****");
    }

}
