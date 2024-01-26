package NopCommerceWeb.NopCommercePUIs;

public class MyAccountPUI {
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String LEFTMENU_MYACCOUNT = "xpath=(//a[normalize-space()='%s'])[1]";

	//CUSTOMER INFO
	public static final String RADIO_GENDER = "xpath=//label[normalize-space()='%s']/preceding-sibling::input";
	public static final String TEXTBOX_CUSTOMER_INFO = "xpath=//label[text()='%s']/following-sibling::input";
	public static final String DROPDOWN_DAY = "xpath=//select[@name='DateOfBirthDay']";
	public static final String DROPDOWN_MONTH = "xpath=//select[@name='DateOfBirthMonth']";
	public static final String DROPDOWN_YEAR = "xpath=//select[@name='DateOfBirthYear']";
	public static final String CHECKBOX_NEWSLETTER = "xpath=//input[@id='Newsletter']";
	public static final String MESSAGE_UPDATE_SUCCESS = "xpath=//p[@class='content']";
	public static final String BUTTON_OF_LEFT_MENU = "xpath=(//button[normalize-space()='%s'])";


	//ADDRESS
	public static final String TEXTBOX_ADDRESSES = "xpath=//label[normalize-space()='%s']//following-sibling::input";
	public static final String DROPDOWN_COUNTRY = "xpath=//select[@id='Address_CountryId']";
	public static final String DROPDOWN_STATE = "xpath=//select[@id='Address_StateProvinceId']";


	//CHANGE PASSWORD
	public static final String TEXTBOX_CHANGE_PASSWORD = "xpath=//label[normalize-space()='%s']//following-sibling::input";

}
