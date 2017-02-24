package timer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mjrt on 2/24/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReminderMessage {

    private Long id;
    private String message;
    private boolean state;
    private Long UserName;

}