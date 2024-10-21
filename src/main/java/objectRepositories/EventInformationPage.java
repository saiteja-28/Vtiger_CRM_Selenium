package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventInformationPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(name="Delete")
	private WebElement deleteBTN;
	
	public EventInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickDelete() {
		deleteBTN.click();
	}
}
