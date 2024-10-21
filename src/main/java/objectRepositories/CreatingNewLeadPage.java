package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreatingNewLeadPage {
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;

	@FindBy(name = "lastname")
	private WebElement lastNameTF;

	@FindBy(name="company")
	private WebElement companyTF;

	@FindBy(xpath = "//input[normalize-space(@value)='Save'] ")
	private WebElement saveBTN;

	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getpageHeader() {
		return pageHeader.getText();
	}
    public void setLastName(String lastName) {
    	lastNameTF.sendKeys(lastName);
    }
    public void setCompanyName(String companyName) {
    companyTF.sendKeys(companyName);	
    }
  
    public void clickSave() {
    	saveBTN.click();
    }
}