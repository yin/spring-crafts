package com.github.yin.spring.crafts.runtime;

import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void test_getMessage() {
		// Mocking out the stdout
		System.setOut(new PrintStream(System.out) {
			@Override
			public void println(String msg) {
				super.println(msg);
				// Performing the check in the mock, :(
				Assert.assertEquals("Should print Message previously set", "Your Message: Test msg", msg);
			}
		});
		HelloWorld tested = new HelloWorld();
		tested.setMessage("Test msg");
		// Executing the test, effectively
		tested.getMessage();
	}

}
