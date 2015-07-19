package com.github.yin.spring.crafts.runtime;

public class HelloWorldPrinter {

	private HelloWorld helloWorld;
	
	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public void print() {
		System.out.println("Yout Message: " + helloWorld.getMessage());
	}
}
