package pageUIs.user;

public class CouponPageUI {
	
	public static final String LOGIN_LINK = "xpath=(//span[text()='LOGIN'])[1]";

	public static final String TEXTBOX_LOGIN = "xpath=//div[@class='flex-5 d-flex align-items-center white-background']//input[@type='%s']";

	public static final String LOGIN_BUTTON = "xpath=(//input[@name='commit'])[1]";

	public static final String ITEMS_LEFT_MENU = "xpath=//span[text()='%s']";
	
	public static final String ITEMS_OF_LIST_TICKETING = "xpath=//a[text()='%s']";

	public static final String NAME_OF_SCREEN = "xpath=//h4[text()='%s']";
	
	public static final String ADD_COUPON_BUTTON= "xpath=//a[text()='Coupon']";
	
	public static final String NAME_OF_POPUP= "xpath=//h6[text()='%s']";

	public static final String SAVE_BUTTON= "xpath=//button[text()='Save']";
	
	public static final String ALERT_OF_POPUP= "xpath=//div[@role='alert']";

	public static final String TEXTBOX_POPUP_PLACEHODER= "xpath=//input[contains(@placeholder, '%s')]";
	public static final String TEXTBOX_POPUP_FIELD= "xpath=//label[text()='%s']/parent::div/following-sibling::div/input";

	public static final String DROPDOWN_VALUE_PARENT = "xpath=//label[text()='%s']/parent::div/following-sibling::div//span[@role='combobox']";
	public static final String DROPDOWN_VALUE_CHILD = "xpath=//li[contains(text(), '%s')]";

	public static final String CLOSE_POPUP_BUTTON = "xpath=//button[@class='close']//*[name()='svg']";
	public static final String CLOSE_ALERT_BUTTON = "xpath=//button[@class='close text-capitalize']";

	public static final String TOOGLE_AUTO_APPLY = "xpath=//label[@for='auto_apply']";

	public static final String MORE_MENU_BUTTON = "xpath=//td[text()='%s']/following-sibling::td[@class='content-center']";
	public static final String ITEMS_OF_MORE_MENU = "xpath=//div[@class='dropdown-default dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='%s']";
	public static final String DROPDOWN_FIELD = "xpath=//select[contains(@id,'%s')]";
	public static final String COUPON_DROPDOWN = "xpath=//div[@class='d-flex flex-direction-column']//span[@role='combobox']";
	public static final String COUPON_TEXTBOX= "xpath=//select[contains(@id,'%s')]";
	public static final String COUPON_VALUE_SEARCH= "xpath=//li[text()='%s%']";

	public static final String CHECKOUT_TEXT= "xpath=//b[text()='Checkout']";
	public static final String DISCOUNT_TEXT= "xpath=//span[text()='Coupon discount']";


}
