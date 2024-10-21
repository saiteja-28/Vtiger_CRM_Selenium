package objectRepositories;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontactBTN;
	
	@FindBy(xpath="//table[@class='lvt small']/tboby/tr/td[4]/a[@title='Contacts']")
	private List<WebElement> contacts;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	
	public void clickcreateContact() {
		createcontactBTN.click();
	}
	
	public boolean searchContact(String lastName) {
		boolean isPresent = false;
		for (WebElement contact : contacts) {
			if(contact.getText().equals(lastName)) {
				isPresent = true ;
				break;
			}
		}
		return isPresent;
	}
}
