package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-21.
 */

@Service
public interface PersonSelectByDateMapper {

     /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param name 名字
    */

    /*
    *
    * @param SelectByDate 数据源
    * @param offset 分页页数
    * @param total 总计
    */

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param name 名字
     */

    List<PersonSelectByDate> QueryByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("name") String name);
    List<PersonSelectByDate> SelectByDate(@Param("PersonSelect") PersonSelectByDate PersonSelect, @Param("offset") int offset, @Param("total") int total);

    int getCount(@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("name") String name);



}