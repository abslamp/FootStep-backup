package timer.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timer.common.DateUtils;
import timer.domain.*;
import timer.service.ReminderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/24/2017.
 */
@Service
@Log4j2
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    ReportMapper reportMapper;
    @Autowired
    ReminderMessageMapper messageMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Report> queryReport(Date jmt,int role) {
        List<Report> reports = reportMapper.findByDateOrderByDate(jmt);

        List<Report> res = new ArrayList<>();
        for (Report report : reports){
            if(userMapper.findByName(report.getName()).getRole() == role ){
                res.add(report);
            }
        }
        return res;
    }

    @Override
    public void setMessage(String name, int role) {

        if (role == 3){
            remindEmployee();
        } else if (role < 3){
            remindLeader(name);
        }
    }

    private void remindLeader(String name) {
        List<Report> reports = getReportByState("UNAUDITED");
        if(reports != null && reports.size() != 0){
            ReminderMessage message = new ReminderMessage();
            message.setMessage("您有未审批的日报");
            message.setLack(new Date());
            message.setState(false);
            message.setUserName(name);
            messageMapper.insert(message);
        }
    }

    private void remindEmployee(){
        Date now = new Date();
        List<Report> reports = queryReport(now,3);
        List<Date> lacks = null;
        if(!reports.get(0).getName().equals(reports.get(1).getName())){
            if((lacks = getLackDates(reports.get(0).getJmt(),now)) != null){
                addMessageByDates(lacks,reports.get(0).getName());
            }
        }

        for(int i = 1 ; i < reports.size() ; i++){
            log.error("index"+i+":");
            if(reports.get(i-1).getName().equals(reports.get(i).getName())){
                if((lacks = getLackDates(reports.get(i-1).getJmt(),reports.get(i).getJmt())) != null){
                    addMessageByDates(lacks,reports.get(i-1).getName());
                }
            } else {
                if((lacks = getLackDates(reports.get(i-1).getJmt(),now)) != null){
                    addMessageByDates(lacks,reports.get(i-1).getName());
                }
            }
        }
    }

    private List<Report> getReportByState(String state){
        return reportMapper.findByState(state);
    }

    private List<Date> getLackDates(Date start , Date end){

        System.out.println(start.getTime() + "--" + DateUtils.getFormatString(start));
        System.out.println(end.getTime() + "--" + DateUtils.getFormatString(end));

        if (start.getTime() > end.getTime()){
            System.out.println("swaped");
            Date tmp = start;
            start = end;
            end = tmp;
        }

        if (DateUtils.getWeek(end) == 1){
            end = DateUtils.getNextOrBeforeDay(end,-2);
        }

        end = DateUtils.getNextOrBeforeDay(end,-1);
        if(start.equals(end)){
            return null;
        }

        List<Date> res = new ArrayList<>();

        int tot = 0;
        while(!start.equals(end) ){
            tot++;
            System.out.println("start:"+DateUtils.getFormatString(start) +"***"+"end:"+DateUtils.getFormatString(end));

            int week = DateUtils.getWeek(end);
            if(week !=6 && week != 0){
                res.add(end);
            }
            end = DateUtils.getNextOrBeforeDay(end,-1);
        }

        return res;
    }

    private void addMessageByDates(List<Date> dates,String name){
        for (Date lack : dates){
            ReminderMessage message = new ReminderMessage();
            message.setUserName(name);
            message.setLack(lack);
            message.setMessage(message.getUserName()+":"+DateUtils.getFormatString(lack)+"没有完成日报");
            message.setState(false);
            messageMapper.insert(message);
        }
    }
}
