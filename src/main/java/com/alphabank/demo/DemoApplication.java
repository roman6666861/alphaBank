package com.alphabank.demo;

import com.alphabank.demo.entity.Storage;
import com.alphabank.demo.service.MainService;
import com.alphabank.demo.service.MainServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
        Parser parser = context.getBean(Parser.class);
        MainServiceImpl mainService = (MainServiceImpl) context.getBean(MainService.class);
        try {
            parser.parse(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Storage storage = parser.parse(args[0]);
            log.info("Storage is " + storage);
            mainService.save(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        return dataSource;
    }
}
