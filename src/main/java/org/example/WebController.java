package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="mailto:opinilla@gmail.com">Oscar Pinilla</a>, <a href="https://github.com/Solksjaer">GitHub</a>
 */
@Controller
public class WebController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.git}")
    private String appGit;

    @Value("${app.contact}")
    private String appContact;

    @GetMapping(path = "/")
    public ModelAndView home(final ModelAndView modelAndView) {

        modelAndView.setViewName("home");

        modelAndView.addObject("appName", appName);
        modelAndView.addObject("appGit", appGit);
        modelAndView.addObject("appContact", appContact);

        return modelAndView;
    }

}
