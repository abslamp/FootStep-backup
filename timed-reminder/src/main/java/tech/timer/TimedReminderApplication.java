package tech.timer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mjrt on 2/21/2017.
 */
@SpringBootApplication
@MapperScan("tech.timer")
public class TimedReminderApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimedReminderApplication.class,args);
    }
}
