package edu.heu.soft.controller;

import edu.heu.soft.common.CookieUtils;
import edu.heu.soft.domain.Report;
import edu.heu.soft.service.ReportAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mjrt on 2/26/2017.
 */
@RestController
@RequestMapping("/audit")
public class ReportAuditController {
    @Autowired
    ReportAuditService service;

    @GetMapping
    Map<String,List<Report>> query(HttpServletRequest request , String name , String state , Date startDate,Date endDate){

        if (name == null){
            String leaderName = CookieUtils.findCookieByName("userName",request).getValue();
            return service.queryBySubordinate(leaderName,state,startDate,endDate);
        }

        Map<String,List<Report>> res = new HashMap<>();
        res.put(name,service.query(name,state,startDate,endDate));
        return res;
    }

    @PutMapping
    int update(Report report){
        return service.update(report);
    }

}
