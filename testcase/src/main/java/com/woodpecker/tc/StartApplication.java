package com.woodpecker.tc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 类描述:〈启动程序〉
 *
 * @author: sword
 */
@SpringBootApplication
@ComponentScan({"com.woodpecker.tc", "com.sword.autotest.framework"})
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
