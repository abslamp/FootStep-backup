package edu.heu.soft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mjrt on 2/19/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prp {

    private Long id;
    private String abbreviation;
    private String name;
    private String remark;
}
