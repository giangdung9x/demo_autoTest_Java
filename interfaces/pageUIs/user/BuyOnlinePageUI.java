package pageUIs.user;

public class BuyOnlinePageUI {

	public static final String TEXT_EVENT_NAME = "xpath=//h1[@class='my-5 text-lg font-semibold']";
	public static final String TEXT_SELECT_TICKETS = "xpath=//span[text()='Select Tickets']";
	public static final String TEXT_SELECT_ADD_ONS = "xpath=//span[text()='Select Add-Ons']";
	public static final String TEXT_SELECT_PASSES = "xpath=//span[text()='Select Passes']";
	public static final String TEXT_SELECT_GIFT_CARD = "xpath=//span[text()='Select Gift Card']";
	public static final String DROPDOWN_TICKET = "xpath=//select[@data-name='vip3']";
	public static final String VALUE_DROPDOWN_TICKET = "xpath=//select[@data-name='vip3']//option[@value='1']";
	public static final String DROPDOWN_ADD_ONS = "xpath=//select[@data-name='coca']";
	public static final String VALUE_DROPDOWN_ADD_ONS = "xpath=//select[@data-name='coca']//option[@value='1']";
	public static final String DROPDOWN_PASSES = "xpath=//select[@data-name='giang pass test']";
	public static final String VALUE_DROPDOWN_PASSES = "xpath=//select[@data-name='giang pass test']//option[@value='1']";
	public static final String DROPDOWN_GIFT_CARD = "xpath=//select[@data-name='Gift Card']";
	public static final String VALUE_DROPDOWN_GIFT_CARD = "xpath=//select[@data-name='Gift Card']//option[@value='1']";
	public static final String BUTTON_AGREE_CHECKOUT = "xpath=//button[text()='Agree & Checkout']";
	
	public static final String CHECKOUT_TEXT = "xpath=//h2[text()='Checkout']";
	public static final String FULL_NAME_TEXTBOX = "xpath=//input[@placeholder='Full Name']";
	public static final String PHONE_TEXTBOX = "xpath=//input[@placeholder='Phone']";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@placeholder='Email']";
	public static final String CONFIRM_EMAIL_TEXTBOX = "xpath=//input[@placeholder='Confirm Email']";
	public static final String CHECKOUT_EXPRIE_TIME_TEXT ="xpath=//span[text()='Expired']";
	
	public static final String IFRAME_CARD_MANUALLY = "xpath=//iframe[@title='Secure card payment input frame']";
	public static final String CARD_NUMBER_TEXTBOX = "xpath=//input[@placeholder = 'Card number']";
	public static final String MONTH_YEAR_TEXTBOX = "xpath=//input[@placeholder = 'MM / YY']";
	public static final String CVC_TEXTBOX = "xpath=//input[@placeholder = 'CVC']";
	public static final String ZIP_TEXTBOX = "xpath=//input[@placeholder = 'ZIP']";
	
	public static final String BACK_TO_TICKET_LINK = "xpath=//a[text()='Back to tickets']";
	public static final String CHECKBOX_ACCEPT_TERMS_SERVICE = "xpath=//input[@id='accept-term']";
	public static final String BUTTON_PLACE_ORDER = "xpath=//button[text()='Place Order']";
	public static final String CHECKOUT_SUCCESS_TEXT = "xpath=//h2[text()='This order has been sent to you!']";
	public static final String BUTTON_PRINT_ORDER = "xpath=//a[text()='Print order']";
	public static final String BUTTON_BACK_TO_EVENT_PAGE = "xpath=//a[text()='Back to event page']";
	public static final String CARD_INFO_TEXT = "xpath=//h2[text()='Card Info']";
}
