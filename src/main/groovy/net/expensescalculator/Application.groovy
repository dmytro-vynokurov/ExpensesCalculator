package net.expensescalculator

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@ComponentScan
@EnableAutoConfiguration
class Application {
    public static void main(String[] args) {
        SpringApplication.run((new ArrayList<Object>([Application.class,"applicationContext.xml"])).toArray(),args)
    }
}
