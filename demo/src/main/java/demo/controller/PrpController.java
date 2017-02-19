package demo.controller;

import demo.domain.Prp;
import demo.service.PrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LZMA on 2017/2/19.
 */

@RestController
@RequestMapping("/prp")
public class PrpController {

    @Autowired
    PrpService prpService;

    @RequestMapping(value="/{id}" ,method= RequestMethod.GET)
    public Prp queryById(@PathVariable Long id) {
        return prpService.queryById(id);
    }

    @RequestMapping(value="/all")
    public List<Prp> queryAll(Prp cond, int page) {
//        System.out.println(cond);
//        System.out.println(page);
        return prpService.query(null,0);
    }

    @RequestMapping(value="rowscount")
    public int rowsCount(Prp cond) {
        return prpService.getCount(cond);
    }

}
