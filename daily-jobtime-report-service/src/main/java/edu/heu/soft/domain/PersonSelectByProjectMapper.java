package edu.heu.soft.domain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-23.
 */
@Repository
public interface PersonSelectByProjectMapper {
    List<PersonSelectByProject>  selectByProject(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("name") String name, @Param("offset") int offset, @Param("total") int total);
    int getCount(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("name") String name);



    List<Report> getName();
}
