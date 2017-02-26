package timer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mjrt on 2/19/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAndUser {

    private Long id;
    private String project;
    private String userName;
    private String userJob;


}
