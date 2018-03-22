package com.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
@SpringBootApplication
@EnableAutoConfiguration
public class App {
    public static void main(String[]a)
    {
        SpringApplication.run(App.class,a);
    }
}
