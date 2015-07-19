package com.github.yin.spring.crafts.runtime;

import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void test_print() {
		// Mocking out the stdout
		System.setOut(new PrintStream(System.out) {
			@Override
			public void println(String msg) {
				super.println(msg);
				// Performing the check in the mock, :(
				Assert.assertEquals("Should print Message previously set", "Test msg", msg);
			}
		});
		HelloWorldPrinter tested = new HelloWorldPrinter();
		HelloWorld hw = new HelloWorld();
		tested.setHelloWorld(hw);
		hw.setMessage("Test msg");
		// Executing the test, effectively
		tested.print();
	}

	@Test
	public void test_getMessage() {
		HelloWorld tested = new HelloWorld();
		tested.setMessage("Test msg 2");
		// Executing the test, effectively
		Assert.assertEquals("shoult return set message", "Test msg 2", tested.getMessage());
	}

}
