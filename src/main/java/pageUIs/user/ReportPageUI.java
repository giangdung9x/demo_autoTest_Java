package pageUIs.user;

public class ReportPageUI {
	
	public static final String LOGIN_LINK = "xpath=(//span[text()='LOGIN'])[1]";
	public static final String TEXTBOX_LOGIN = "xpath=//div[@class='flex-5 d-flex align-items-center white-background']//input[@type='%s']";
	public static final String LOGIN_BUTTON = "xpath=(//input[@name='commit'])[1]";
	
	public static final String ITEMS_LEFT_MENU = "xpath=//span[text()='%s']";
	public static final String ITEMS_OF_LIST_TICKETING = "xpath=//a[text()='%s']";
	
	public static final String NAME_OF_SCREEN = "xpath=//h4[text()='%s']";
	public static final String SEARCH_REPORT_BAR = "xpath=//input[@placeholder='Search by event name']";
	public static final String ACTION_DROPDOWN_BUTTON = "xpath=(//div[text()='%s']/following::td/div[@class='dropdown-custom-ss dropdown dropdown-scroll-into-view'])[1]";
	public static final String ITEMS_OF_DROPDOWN = "xpath=//div[@class='dropdown-default dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='%s']";

	//CHECK VALUE REPORT
		//use tag Overview
	public static final String VALUE_OF_OVERVIEW_TAG = "xpath=//h3[text()='%s']/parent::div//span[text()='%s']/preceding-sibling::*";
	
	//Tag - row - value column ordinal number
	public static final String VALUE_OF_TAG = "xpath=//h3[text()='%s']/parent::div/following-sibling::div/table//tr[td[text()='%s']]/td[%s]"; //--use all tag   
	public static final String TOTAL_VALUE_OF_TAG = "xpath=//h3[text()='%s']/parent::div/following-sibling::div/table//tr[td/b[text()='%s']]/td[%s]";  //--use tag  Tickets, Add-ons, Volume, Online Sales, Cash Sales,Misc Charge 
}
