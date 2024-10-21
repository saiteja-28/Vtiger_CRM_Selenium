package VtigerTestScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.TabNames;
import objectRepositories.CreatingNewOrganizationPage;
import objectRepositories.OrganizationInformationPage;
import objectRepositories.OrganizationsPage;

public class createOrganizationsTest extends BaseClass {

	@Test
	public void createOrgTest() {
		OrganizationsPage org = pom.getOrg();
		OrganizationInformationPage orgInfo = pom.getOrgInfo();
		CreatingNewOrganizationPage createOrg = pom.getCreateOrg();
		
		home.clickRequiredTab(web, TabNames.ORGANIZATONS);
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickcreateOrg();
		soft.assertEquals(createOrg.getpageHeader(), "Creating New Organizations");
		Map<String, String> map = excel.readFromExcel("Create Organization With Industry And Type");
		createOrg.setOrgName(map.get("Organization Name"));
		createOrg.selectIndusrtyDD(web, map.get("Industry"));
		createOrg.selectTypeDD(web, map.get("Type"));
		createOrg.clickSave();
		
		
		soft.assertTrue(orgInfo.getPageHeader().contains(map.get("Organization Name")));
		orgInfo.clickDelete();
		web.handleAlert("OK");
		soft.assertFalse(org.searchOrganization(map.get("Organization Name")));
		if(!(org.searchOrganization(map.get("Organization Name"))))
			excel.updatestatus("Create Organization With Industry And Type", "Pass");
		else
			excel.updatestatus("Create Organization With Industry And Type", "Fail");
		soft.assertAll();
	}
	}