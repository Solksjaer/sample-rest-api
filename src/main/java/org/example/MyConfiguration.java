package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author <a href="mailto:opinilla@gmail.com">Oscar Pinilla</a>, <a href="https://github.com/Solksjaer">GitHub</a>
 */
@Configuration
@ComponentScan(basePackages = "org.example")
@Slf4j
public class MyConfiguration {

    @PostConstruct
    public void announceLoaded() {
        log.info(" ***** Application loaded. *****");
    }

}
