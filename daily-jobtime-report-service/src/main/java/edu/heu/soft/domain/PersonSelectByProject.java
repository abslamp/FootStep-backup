package edu.heu.soft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by new on 17-2-23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonSelectByProject {


    private String project;
    private double sumworkLoad;
    private double sumoverTime;



}
