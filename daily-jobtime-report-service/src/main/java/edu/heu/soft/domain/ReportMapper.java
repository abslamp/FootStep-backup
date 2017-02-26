package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;

import java.util.Date;
import java.util.List;

/**
 * Created by mjrt on 2/26/2017.
 */
public interface ReportMapper {
    List<Report> findByProject(String project);
    List<Report> findByNameAndStateAndDate(String name,String state,Date startDate,Date endDate);
    List<Report> findByStateOrderByProjectAndName(String state);
    List<Report> findByNameAndDate(@Param("name") String name, @Param("startDate")Date startDate, @Param("endDate")Date endDate);
    int save(Report report);
}
