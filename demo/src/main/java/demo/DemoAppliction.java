package demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by new on 17-2-15.
 */
@SpringBootApplication
@MapperScan("demo.domain")
public class DemoAppliction {
    public static void main(String[] args) {
        SpringApplication.run(DemoAppliction.class,args);
    }
}

