package tech.jinhaoma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jinhaoma.service.AuthorizationService;

/**
 * Created by mjrt on 2/20/2017.
 */
@RestController
@RequestMapping(value = "login")
public class AuthorizationController {

    @Autowired
    AuthorizationService service;

    public String login(String name , String passWord){
        return service.login(name,passWord);
    }

}
