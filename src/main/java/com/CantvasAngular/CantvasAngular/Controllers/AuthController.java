package com.CantvasAngular.CantvasAngular.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class AuthController {
    @PostMapping("/login")
    public RedirectView openCognitoLoginPage() {
        String redirectUrl = System.getProperty("cognito_domain") + "/login";
        return new RedirectView(redirectUrl);
    }
}
