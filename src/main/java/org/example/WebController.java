package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

    @GetMapping(path = "/currency", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String currency(final HttpServletRequest request,
                    @RequestParam("currency") final String currency,
                    @RequestParam("locale") final String locale) throws IOException {
        return "someResponse";
    }

}
