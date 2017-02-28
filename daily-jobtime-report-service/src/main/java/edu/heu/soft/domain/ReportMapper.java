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



    Report findReportCond(Date start,Date end,String project, String prp ,String task, String state);
    List<Report> findReport(@Param ("start")Date start,@Param("end")Date end,@Param("cond") Report cond,@Param("offset") int offset,@Param("total") int total);
    int getCount(@Param ("start")Date start,@Param("end")Date end,@Param("cond") Report cond);
    List<Report> findReportProject();
    List<Report> findReportPrp();
    int insert(@Param("jmt") Date jmt, @Param("name") String name,@Param("project") String project,@Param("task") String task,@Param("prp") String prp,@Param("workLoad") double workLoad,@Param("overTime") double overTime);
    void delete(@Param("id") Long id);
    void update( @Param("id") Long id,@Param("jmt")Date jmt,@Param("project") String project,@Param("task") String task,@Param("prp") String prp, @Param("workLoad")double workLoad, @Param("overTime")double overTime);
    Report findById( Long id);
    List<ProjectAndPrp>findPapPrp();
    List<ProjectAndUser>findPauProject();
}
