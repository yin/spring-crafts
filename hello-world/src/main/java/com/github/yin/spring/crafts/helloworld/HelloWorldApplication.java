package com.github.yin.spring.crafts.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Hello world Spring Application
 */
@Configuration
@ComponentScan
public class HelloWorldApplication
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("com.github.yin.spring.crafts");
        context.registerShutdownHook();
        HelloWorldGreeter greeter = context.getBean(HelloWorldGreeter.class);
        greeter.sayHelloWorld();
        context.close();
    }
    
    static interface HelloWorldService {
    	public String getHelloWorld();
    }
    
    @Component
    static class HelloWorldGreeter {
    	private HelloWorldService helloWorldService;
    	
    	@Autowired
    	public HelloWorldGreeter(HelloWorldService helloWorldService) {
    		this.helloWorldService = helloWorldService;
    	}
    	
    	public void sayHelloWorld() {
    		System.out.println(helloWorldService.getHelloWorld());
    	}
    }
    
    @Bean
    HelloWorldService myHelloWorldService() {
    	return new HelloWorldService() {
			public String getHelloWorld() {
				return "Hello World!";
			}
		};
    }
}
