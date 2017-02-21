package tech.jinhaoma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jinhaoma.domain.LoginResponse;
import tech.jinhaoma.service.AuthorizationService;

/**
 * Created by mjrt on 2/20/2017.
 */
@RestController
@RequestMapping(value = "/login")
public class AuthorizationController {

    @Autowired
    AuthorizationService service;

    @PostMapping
    public LoginResponse login(String userName , String passWord){
        return service.login(userName,passWord);
    }

}
