package edu.heu.soft.service.impl;

import edu.heu.soft.domain.Report;
import edu.heu.soft.domain.ReportMapper;
import edu.heu.soft.domain.User;
import edu.heu.soft.domain.UserMapper;
import edu.heu.soft.service.ReportAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by mjrt on 2/26/2017.
 */
@Service
public class ReportAuditServiceImpl implements ReportAuditService {
    @Autowired
    ReportMapper reportMapper;
    @Autowired
    UserMapper userMapper;
//    subordinate
    @Override
    public List<Report> query(String name, String state, Date startDate, Date endDate) {
        return reportMapper.findByNameAndStateAndDate(name,state,startDate,endDate);
    }

    @Override
    public Map<String,List<Report>> queryBatch(List<String> names, String state, Date startDate, Date endDate){
        Map<String,List<Report>> res = new HashMap<>();

        for(String name : names){
            res.put(name,query(name,state,startDate,endDate));
        }
        return res;
    }
    @Override
    public Map<String,List<Report>> queryBySubordinate(String leaderName,String state, Date startDate, Date endDate){
        String department = userMapper.findByName(leaderName).getDepartment();
        List<User> users = userMapper.findByDepartment(department);

        List<String> names = new ArrayList<>();
        for(User user: users){
            if(!user.getName().equals(leaderName)){
                names.add(user.getName());
            }
        }
        return queryBatch(names,state,startDate,endDate);
    }

    @Override
    public int update(Report report) {
        return reportMapper.save(report);
    }
}
