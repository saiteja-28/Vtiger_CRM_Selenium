package genericUtilities;

public enum TabNames {
ORGANIZATONS("Organizations"), LEADS("Leads"), CONTACTS("Contacts");

private String tabName;
	
private TabNames(String tabName){
		this.tabName = tabName;
	}

	public String getTabName() {
		return tabName;
	}
}
