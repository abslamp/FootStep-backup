package tech.timer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.timer.domain.Report;
import tech.timer.domain.ReportMapper;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/24/2017.
 */
@RestController
@RequestMapping(value = "/reminder")
public class ReminderController {

    @Autowired
    ReportMapper mapper;

    @GetMapping
    List<Report> query(Date jmt){
        return mapper.queryDateOrderByDate(jmt);
    }

}
