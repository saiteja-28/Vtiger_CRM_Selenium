package groupExecution;

import org.testng.annotations.Test;

public class Test3 {

	@Test(groups = {"sanity","regression"})
	public void Demo1() {
		System.out.println("Test3 - demo1 - sanity and regression");
	}
	@Test(groups = {"smoke","sanity"})
	public void Demo2() {
		System.out.println("Test3 - demo2 - smoke and sanity");
	}
	@Test(groups = {"smoke","sanity","regression"})
	public void Demo3() {
		System.out.println("Test3 - demo3 - smoke,sanity and regression");
	}
}
