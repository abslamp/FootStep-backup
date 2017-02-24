package edu.heu.soft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by mjrt on 2/19/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    private Long id;
    private String name;
    private String project;
    private String task;     //length = 4096
    private Date jwt;
    private double workLoad;
    private double overTime;
    private String state = "UNAUDITED";

}
