package cn.bw.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MallCanalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallCanalServiceApplication.class, args);
    }

}
