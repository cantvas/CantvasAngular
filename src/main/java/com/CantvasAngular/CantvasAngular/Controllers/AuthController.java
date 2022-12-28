package com.CantvasAngular.CantvasAngular.Controllers;

import org.apache.juli.logging.Log;
import org.hibernate.sql.Template;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RestController
public class AuthController {

    String cognitoLoginURL = "https://cantvas.auth.us-west-2.amazoncognito.com/login";
//    String cognitoLoginURL = "https://cantvas.auth.us-west-2.amazoncognito.com/login?response_type=token&client_id=5jtouutkvdsnv3gvg8o28okh5v&redirect_uri=https://localhost:8080/*";
    @GetMapping("/login")
    public String openCognitoLoginPage() throws URISyntaxException {
    return "redirect:" + cognitoLoginURL;

        //        String token = null;
//        try {
//            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//            requestFactory.createRequest(new URL(cognitoLoginURL).toURI(), HttpMethod.GET);
//
//            RestTemplate restTemplate = new RestTemplate(requestFactory);
//            token = restTemplate.getForEntity(cognitoLoginURL, String.class, new HashMap<String, String>()).getBody();
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return token;
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public ResponseEntity<String> bingbong(){
        String myBody =
                """
                {
                "grant_type": "authorization_code",
                "code": "336ced6e-53fe-4b16-bee7-5da816743453",
                "redirect_uri": "https://localhost:8080/*",
                "client_id": "5jtouutkvdsnv3gvg8o28okh5v",
                "client_secret": "vje4gkan8v99pcvlhujdri71vvls2n9ed7j2j0g80e8t6ktoeqh"
                }
                """;
        RequestEntity<String> request = RequestEntity
                .post(cognitoLoginURL)
                .accept(MediaType.APPLICATION_JSON)
                .body(myBody);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.exchange(request, String.class);
        return response;
    }
}
