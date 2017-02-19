package edu.heu.soft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mjrt on 2/19/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAndPrp {

    private Long id;
    private String project;
    private String prpName;
    private String prpAbbreviation;

}
