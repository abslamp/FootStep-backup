package edu.heu.soft.domain;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-21.
 */

@Service
public interface PersonSelectNameMapper {


      /*
    *
    * @param PersonSelectName  SelectNotLeader  不是leader的查询结果
    * @param PersonSelectName  SelectLeader  是leader的查询结果
    * @param Integer Leader 判断是否为leader，0为否，1为是
    * @return List<PersonSelectName> SelectName 返回查询后的结果，作为下拉框的数据
    */

    /*
    *@param Leader 查找leader
    * return int Select 返回leader的值
    */

    /*
    * @param PersonSelectName SelectNotLeader 不是leader的查询方法
    * @return PersonSelectName 返回查询结果
     */

    /*
    * @param PersonSelectName SelectLeader 是leader的查询方法
    * @return PersonSelectName 返回查询结果
     */



    List<PersonSelectName>SelectName(PersonSelectName SelectNotLeader, PersonSelectName SelectLeader, Integer Leader);
    Integer SelectLeader(Integer Leader);

    List<PersonSelectName>SelectNameNotLeader(PersonSelectName SelectNotLeader);
    List<PersonSelectName>SelectNameLeader(PersonSelectName SelectLeader);
}