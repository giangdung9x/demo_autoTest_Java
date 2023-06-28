package pageUIs.user;

public class SellConcessionPageUI {
	//LOGIN
	public static final String LOGIN_LINK = "xpath=(//span[text()='LOGIN'])[1]";
	public static final String TEXTBOX_LOGIN = "xpath=//div[@class='flex-5 d-flex align-items-center white-background']//input[@type='%s']";
	public static final String LOGIN_BUTTON = "xpath=(//input[@name='commit'])[1]";
	
	//HOMEPAGE CONCESSION
	public static final String TEXT_OF_HOMEPAGE_CONCESSION = "xpath=//h2[contains(text(),'Please choose an event')]";
	public static final String EVENT_NAME = "xpath=//a[normalize-space()='%s']";
	public static final String LOGOUT_BUTTON = "xpath=(//a[normalize-space()='Log out'])[1]";
	
	//SELL OF EVENT SCREEN
	public static final String PLUS_ADD_ONS_BUTTON = "xpath=(//button[@data-action='plus'])[1]";
	public static final String MINUS_ADD_ONS_BUTTON = "xpath=(//button[@data-action='minus'])[1]";
	public static final String CHECKOUT_BUTTON = "xpath=(//button[text()='Checkout'])[1]";

	//CHECKOUT SCREEN
	public static final String INFOR_BUYER_CHECKOUT = "xpath=(//input[@placeholder='%s'])[1]";
	public static final String PLACE_ORDER_BUTTON = "xpath=//button[@id='btn-place-order']";
	public static final String AMOUT_OF_ORDER_BEFORE = "xpath=//span[@class='display-amount']";
	public static final String AMOUT_OF_ORDER_BEFORE_MISC = "xpath=//button[@class='btn-misc-charge color-primary mr-2 d-mobile-none']//span[@class='txt-misc-charge color-dark']";
	public static final String AMOUT_OF_ORDER_AFTER = "xpath=(//li[@class='flex justify-between mb-2']//span)[2]";
	public static final String CLOSE_POPUP_BUTTON = "xpath=//a[normalize-space()='Close']";

	//MISC CHARGE
	public static final String ADD_MISC_CHARGE_BUTTON = "xpath=//button[@class='btn-misc-charge color-primary mr-2 d-mobile-none']";
	public static final String INFO__MISC_CHARGE_TEXTBOX = "xpath=//input[contains(@placeholder,'%s')]";
	public static final String INFOR_NOTES = "xpath=(//input[contains(@placeholder,'%s')])[2]";
	public static final String CHECKOUT_OF_POPUP_BUTTON = "xpath=//button[normalize-space()='%s']";

	//TAB
	public static final String NAME_OF_TAB = "xpath=//a[normalize-space()='%s']";

	//REFUND
	public static final String DROPDOWN_BUTTON_OF_ADD_ONS_FIRST = "xpath=(//div[@class='dropdown-custom-ss dropdown'])[1]";
	public static final String VALUE_OF_DROPDOWN = "xpath=//div[@class='dropdown-default dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='%s']";
	public static final String SELECT_ALL_REFUND = "xpath=//label[normalize-space()='Select all']";
	public static final String STATUS_OF_ADD_ONS = "xpath=(//td[@class='can-gray-out align-baseline sales-line-height d-mobile-none']//span[@class='atbd-tag tag-transparented tag-danger'][normalize-space()='REFUND'])[1]";

}
