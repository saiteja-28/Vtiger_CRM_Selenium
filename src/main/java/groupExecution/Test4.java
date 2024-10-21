package groupExecution;

import org.testng.annotations.Test;

public class Test4 {
	@Test(groups = {"smoke","sanity","regression"})
	public void Demo1() {
		System.out.println("Test4 - demo1 - smoke, sanity and regression");
	}
}
