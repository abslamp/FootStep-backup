package edu.heu.soft.service;


import edu.heu.soft.domain.PersonSelectByProject;
import edu.heu.soft.domain.Report;
import springfox.documentation.service.ApiListingReference;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-23.
 */
public interface PersonSelectByProjectService {
    List<PersonSelectByProject> selectByProject(Date stratTime, Date endTime, String name, int page);
    int getCount(Date stratTime, Date endTime, String name);
    List<Report> getName();
}
