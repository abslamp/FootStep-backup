package demo.controller;

import demo.domain.UserXmlMapper;
import demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by new on 17-2-16.
 */
@RestController
@RequestMapping("/mb")
public class testController {

    @Autowired
    UserXmlMapper mapper;

    @RequestMapping(value = "/{sb}",method = RequestMethod.GET)
    public User query(@PathVariable String sb){
        return mapper.findByName(sb);
    }
}
