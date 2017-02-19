package edu.heu.soft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mjrt on 2/19/2017.
 */
@SpringBootApplication
@MapperScan("edu.heu.soft.domain")
public class DailyJobtimeReportApplication {
    public static void main(String[] args) {
        SpringApplication.run(DailyJobtimeReportApplication.class,args);
    }
}
