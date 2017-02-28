package edu.heu.soft.controller;

import edu.heu.soft.domain.DepartmentUnauditedSelect;
import edu.heu.soft.domain.PersonSelectByDate;
import edu.heu.soft.service.DepartmentUnauditedSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by new on 17-2-26.
 */
@RestController
@RequestMapping("/DepartmentUnauditedSelect")
public class DepartmentUnauditedSelectController {

    @Autowired
    DepartmentUnauditedSelectService service;



    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    * @return List<DepartmentUnauditedSelect> queryByDate 部门未审核查询返回数据源
    */

    /*
    *
    * @param DepartmentSelect 数据源
    * @param page 分页查询的页数
    * @return List<DepartmentUnauditedSelect> SelectNum 返回所查询的数据
    */

    /*
    *
    * @param startTime 开始时间
    * @param endTime 截止时间
    * @param department 部门
    * return  返回行数
     */


    @RequestMapping(value = "/select")
    public List<DepartmentUnauditedSelect> queryByDate(Date startTime, Date endTime, String department){
        System.out.println(startTime.toString());
        System.out.println(endTime.toString());
        System.out.println(department);

        List<DepartmentUnauditedSelect> datas = service.QueryByDate(startTime,endTime,department);

        return datas;
    }


    @RequestMapping(value = "/work")
    public List<DepartmentUnauditedSelect> selectByDate( DepartmentUnauditedSelect DepartmentSelect,Integer page){


        return service.SelectByDate(DepartmentSelect,page);


    }

    @RequestMapping(value = "/rows")

    public int rowsCount(Date startTime,Date endTime,String department)
    {
        return service.getCount(startTime,endTime,department);
    }

}
