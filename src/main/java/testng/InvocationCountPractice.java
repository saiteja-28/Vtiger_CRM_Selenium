package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCountPractice {

	@Test(invocationCount = 3)
	public void Demo1() {
		Reporter.log("demo1", true);
	}
	
	@Test(invocationCount = -3)
	public void Demo2() {
		Reporter.log("demo1", true);
	}
	
	@Test(invocationCount = 2)
	public void Demo3() {
		Reporter.log("demo1", true);
	}
	
	@Test(invocationCount = 0)
	public void Demo4() {
		Reporter.log("demo1", true);
	}
}
