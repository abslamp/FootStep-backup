package edu.heu.soft.service.impl;

import edu.heu.soft.domain.PersonSelectByProject;
import edu.heu.soft.domain.PersonSelectByProjectMapper;

import edu.heu.soft.domain.Report;
import edu.heu.soft.service.PersonSelectByProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-23.
 */
@Service
public class PersonSelectByProjectServiceImpl implements PersonSelectByProjectService {
    @Autowired
    PersonSelectByProjectMapper mapper;
    static  int pagesize=5;

    @Override
    public List<PersonSelectByProject> selectByProject(Date stratTime, Date endTime, String name,int page) {
        int offset=(page-1)*pagesize;
        return mapper.selectByProject(stratTime,endTime,name,offset,pagesize);
    }


    @Override
    public int getCount(Date stratTime, Date endTime, String name) {
        return mapper.getCount(stratTime,endTime,name);
    }

    @Override
    public List<Report> getName() {
        return mapper.getName();
    }
}
