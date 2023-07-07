package pageUIs.user;

public class GiftCardPageUI {
	
	public static final String LOGIN_LINK = "xpath=(//span[text()='LOGIN'])[1]";
	public static final String TEXTBOX_LOGIN = "xpath=//div[@class='flex-5 d-flex align-items-center white-background']//input[@type='%s']";
	public static final String LOGIN_BUTTON = "xpath=(//input[@name='commit'])[1]";
	public static final String ITEMS_LEFT_MENU = "xpath=(//span[text()='%s'])[1]";
	public static final String ITEMS_OF_LIST_TICKETING = "xpath=//span[text()='%s']";
	public static final String NAME_OF_SCREEN = "xpath=//h4[text()='%s']";
	public static final String ADD_BUTTON= "xpath=//a[text()='%s']";
	
	public static final String NAME_OF_POPUP= "xpath=//h6[text()='%s']";
	public static final String SAVE_BUTTON= "xpath=//button[text()='Save']";
	public static final String ERROR_MESSAGE_FIELD= "xpath=//p[text()='total tickets']/preceding-sibling::div//label";
	public static final String ALERT_OF_POPUP= "xpath=//div[@role='alert']";
	public static final String GIFTCARD_NAME= "xpath=//h5[contains(text(),'%s')]";

	public static final String TEXTBOX_LIMIT_PURCHASE= "xpath=//p[text()='%s']/preceding-sibling::div//input";
	public static final String TEXTBOX_POPUP_PLACEHODER= "xpath=//input[contains(@placeholder, '%s')]";
	public static final String TEXTBOX_DESCRIPTION= "xpath=//label[normalize-space()='%s']/following::textarea";
	public static final String TEXTBOX_POPUP_FIELD= "xpath=//label[text()='%s']/parent::div/following-sibling::div/input";
	public static final String TEXTBOX_PRICE= "xpath=//input[contains(@placeholder,'Enter gift card amounts')]";
	public static final String DROPDOWN_VALUE_PARENT = "xpath=//label[contains(text(),'%s')]/parent::div/following-sibling::div//span[@role='combobox']";
	public static final String DROPDOWN_VALUE_CHILD = "xpath=//li[contains(text(), '%s')]";
	public static final String SELECT_ALL_BUTTON = "xpath=//a[text()='Select all']";

	public static final String CLOSE_POPUP_BUTTON = "xpath=//button[@class='close']//*[name()='svg']";
	public static final String CLOSE_ALERT_BUTTON = "xpath=//button[@class='close text-capitalize']";

	public static final String TOOGLE_AUTO_APPLY = "xpath=//label[@for='auto_apply']";

	public static final String MORE_MENU_BUTTON = "xpath=//td[text()='%s']/following::div[@class='dropdown-custom-ss dropdown']";
	public static final String ITEMS_OF_MORE_MENU = "xpath=//div[@class='dropdown-default dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='%s']";
	public static final String DROPDOWN_FIELD = "xpath=//span[contains(@id,'%s')]";
	public static final String VALUE_DROPDOWN = "xpath=//li[contains(text(), '%s')]";

	public static final String COUPON_DROPDOWN = "xpath=//div[@class='d-flex flex-direction-column']//span[@role='combobox']";
	public static final String COUPON_TEXTBOX= "xpath=//input[@role='searchbox']";
	public static final String COUPON_VALUE_SEARCH= "xpath=//li[text()='%s']";

	public static final String CHECKOUT_TEXT= "xpath=//b[text()='Checkout']";
	public static final String DISCOUNT_TEXT= "xpath=//span[text()='%s']";

	public static final String ERROR_MESSAGE_USE_COUPON = "xpath=(//h4[normalize-space()='Coupon code']/parent::div/div/div)[2]";
	public static final String DROPDOWN_QUANTITY_TICKET_BUY_GIFTCARD = "xpath=(//select[@data-name='%s'])[2]";

	//buy online
	public static final String PREV_BUTTON= "xpath=//a[normalize-space()='[Prev]']";
	public static final String COUPON_TEXTBOX_BUY_ONLINE= "xpath=//input[@placeholder='Enter promo code (optional)']";
	public static final String SEND_COUPON_BUTTON= "xpath=//button[@id='btn-check-coupon-code']";
	public static final String SUCCESS_MESSAGE = "xpath=(//div[contains(@class, 'info-message')])[1]";

	//yop mail 
	public static final String INPUT_EMAIL= "xpath=//input[@id='login']";
	public static final String SEND_EMAIL_ICON= "xpath=//i[@class='material-icons-outlined f36']";
	public static final String IFRAME_INFO= "xpath=//iframe[@name='ifinbox']";
	public static final String EMAIL_INFO= "xpath=(//button[@class='lm'])[1]";
	public static final String IFRAME_EMAIL= "xpath=//iframe[@name='ifmail']";
	public static final String GIFT_CARD_CODE= "xpath=//strong[contains(text(),'%s')]";

}
