package com.github.yin.spring.crafts.runtime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorldPrinter printer = (HelloWorldPrinter) context.getBean("printer");
		printer.print();
		printer.print();
		printer.print();
		printer.print();
		checkBeanInstance2x(context, "helloWorldSingleton");
		checkBeanInstance2x(context, "helloWorld");
	}
	
	public static void checkBeanInstance2x(ApplicationContext context, String bean) {
		checkBeanInstance(context, bean);
		checkBeanInstance(context, bean);
	}

	public static void checkBeanInstance(ApplicationContext context, String bean) {
		HelloWorld obj = (HelloWorld) context.getBean(bean);
		System.out.println(bean + " >> " + obj.getClass().getSimpleName() + "#" + obj.hashCode());
	}

}
