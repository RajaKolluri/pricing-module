package org.hareram.springboot.pricemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages="org.hareram.springboot")
@EnableAutoConfiguration
@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/
{
    public static void main( String[] args )
    {
    	System.out.println(":::: HareRam Pricing Module started ::::");
        SpringApplication.run(Application.class, args);
    }
    
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	return application.sources(Application.class);
    }
}
