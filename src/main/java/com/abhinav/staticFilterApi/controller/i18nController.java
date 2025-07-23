package com.abhinav.staticFilterApi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Locale;

@RestController
@Tag(description = "Give localized Greeting to user", name = "GreetAPI")
public class i18nController {

    final MessageSource messageSource;

    public i18nController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/greet")
    public String getHelloInternationalized(@RequestParam String userName) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message", new String[]{userName}, locale);
    }
}
