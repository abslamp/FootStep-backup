package tech.jinhaoma.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mjrt on 2/19/2017.
 */


/*
       role : Boss     1
              Leader   2
              Employee 3
              Admin    4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String passWord;
    private String gender;
    private int role;
    private String department;
    private String edu;

}
