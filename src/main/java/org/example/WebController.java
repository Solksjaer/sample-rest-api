package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:opinilla@gmail.com">Oscar Pinilla</a>, <a href="https://github.com/Solksjaer">GitHub</a>
 */
@Validated
@Controller
public class WebController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.git}")
    private String appGit;

    @Value("${app.contact}")
    private String appContact;

    private static final AtomicInteger count = new AtomicInteger(0);
    @Value("${app.currency.bitcoin}")
    private List<Float> bitcoin;
    @Value("${app.currency.dogecoin}")
    private List<Float> dogecoin;

    @GetMapping(path = "/")
    public ModelAndView home(final ModelAndView modelAndView) {

        modelAndView.setViewName("home");

        modelAndView.addObject("appName", appName);
        modelAndView.addObject("appGit", appGit);
        modelAndView.addObject("appContact", appContact);

        return modelAndView;
    }

    @GetMapping(path = "/currency")
    public ResponseEntity<String> currency(final HttpServletRequest request,
                                           @Valid @NotBlank @RequestParam("currency") final String currency,
                                           @RequestParam("locale") final String localeIp) {

        final Locale locale = request.getLocale();
        final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

        final int currentCount = count.getAndIncrement();
        if (currentCount >= 5) {
            count.setPlain(0);
        }

        if (currency.equalsIgnoreCase("bitcoin")) {
            return new ResponseEntity<>(numberFormat.format(bitcoin.get(currentCount)), HttpStatus.OK);
        } else if (currency.equalsIgnoreCase("dogecoin")) {
            return new ResponseEntity<>(numberFormat.format(dogecoin.get(currentCount)), HttpStatus.OK);
        }

        return new ResponseEntity<>("coin not found", HttpStatus.NOT_IMPLEMENTED);
    }

}
