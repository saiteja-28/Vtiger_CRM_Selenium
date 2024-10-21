package crossBrowserParallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	WebDriver driver;
	
	@Parameters("BROWSER")
	@BeforeClass
	public void classSetup(String Browser) {
		if(Browser.equals("chrome"))
			driver = new ChromeDriver();
		else if(Browser.equals("firefox"))
			driver = new FirefoxDriver();
		else if(Browser.equals("edge"))
			driver = new EdgeDriver();
		else
			System.out.println("Invalid Browser");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void classUnset() {
		driver.quit();
	}
}
