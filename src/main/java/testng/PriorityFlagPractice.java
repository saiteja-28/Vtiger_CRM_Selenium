package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityFlagPractice {
	@Test(priority = 1)
	public void demo() {
		Reporter.log("Hello World!", true);
	}
	@Test(priority = 2)
	public void demo2(){
		Reporter.log("Hello Srikanth!", true);
	}
	@Test(priority = 4)
	public void demo3() {
		Reporter.log("Hello World!", true);
	}
	@Test(priority = 3)
	public void demo4() {
		Reporter.log("Hello Srikanth!", true);
	}
}
