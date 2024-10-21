package groupExecution;

import org.testng.annotations.Test;

public class Test2 {

	@Test(groups = "regression")
	public void Demo1() {
		System.out.println("Test2 - demo1 - rergression");
	}
	@Test(groups = {"smoke","regression"})
	public void Demo2() {
		System.out.println("Test2 - demo2 - smoke and Regression");
	}
	@Test(groups = "smoke")
	public void Demo3() {
		System.out.println("Test2 - demo3 - smoke");
	}
}
