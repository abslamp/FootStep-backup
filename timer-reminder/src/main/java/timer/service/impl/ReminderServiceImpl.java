package timer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import timer.domain.Report;
import timer.domain.ReportMapper;
import timer.service.ReminderService;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/24/2017.
 */
@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    ReportMapper mapper;

    @Override
    public List<Report> queryReport(Date jmt) {
        return mapper.queryDateOrderByDate(jmt);
    }

    @Override
    public void setMessage(int role) {
        List<Report> reports = queryReport(new Date());


    }
}
