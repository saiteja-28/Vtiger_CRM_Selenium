package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class SampleTest {

	@Test(priority = 1)
	public void demo() {
		Reporter.log("Hello World!", true);
	}
	@Test(priority = 2)
	public void demo1() {
		Reporter.log("Hello Srikanth!", true);
	}
}
