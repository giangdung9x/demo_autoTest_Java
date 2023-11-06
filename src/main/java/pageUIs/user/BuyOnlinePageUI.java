package pageUIs.user;

public class BuyOnlinePageUI {

	public static final String TEXT_EVENT_NAME = "xpath=//h1[@class='my-5 text-lg font-semibold']";
	public static final String ERROR_MESSAGE = "xpath=(//div[contains(@class, 'error-message')])[1]";
	public static final String DROPDOWN_QUANTITY_TICKET = "xpath=//select[@data-name='%s']";
	public static final String TEXT_TOTAL_AMOUNT_ORDER = "xpath=//span[@id='total']";
//	public static final String TEXT_TOTAL_AMOUNT_ORDER = "xpath=//h4[contains(text(), 'Total')]/following-sibling::div/h3[contains(@class, 'bo-total-price')]";

	public static final String BUTTON_AGREE_CHECKOUT = "xpath=//button[text()='Agree & Checkout']";

	public static final String CHECKOUT_TEXT = "xpath=//h2[text()='Checkout']";
	public static final String INFO_BUYER_TEXBOX = "xpath=//input[@placeholder='%s']";
	public static final String BUTTON_PLACE_ORDER = "xpath=//button[text()='Place Order']";
	public static final String ERROR_MESSAGE_AT_CHECKOUT_SCREEN = "xpath=//div[@class='error-message flex justify-center items-center min-h-10 w-full text-red-600 border border-red-600 p-2 mb-5']";
	public static final String ERROR_MESSAGE_PURCHASE_FAILED = "xpath=//div[@id='attendee-info']//p[1]";

	public static final String ERROR_MESSAGE_AT_FOOTER_CHECKOUT_SCREEN = "xpath=//span[contains(text(),'Please')]";

	public static final String BUTTON_BACK_TO_TICKET = "xpath=//a[text()='Back to tickets']";
	
	public static final String IFRAME_CARD_MANUALLY = "xpath=//iframe[@title='Secure card payment input frame']";
	public static final String CARD_INFO_TEXTBOX = "xpath=//input[@placeholder = '%s']";
	public static final String ERROR_MESSAGE_CHARGE_CARD = "xpath=//div[@class='error-message flex justify-center items-center min-h-10 w-full text-red-600 border border-red-600 p-2 mb-5']";
	
	public static final String CHECKBOX_ACCEPT_TERMS_SERVICE = "xpath=//input[@id='accept-term']";
	public static final String CHECKOUT_SUCCESS_TEXT = "xpath=//h2[text()='This order has been sent to you!']";
	public static final String BUTTON_PRINT_ORDER = "xpath=//a[text()='Print order']";
	public static final String BUTTON_BACK_TO_EVENT_PAGE = "xpath=//a[text()='Back to event page']";
	public static final String CARD_INFO_TEXT = "xpath=//h2[text()='Card Info']";
	
	public static final String ERROR_MESSAGE_BNPL = "xpath=//span[text()='Buy now pay later is only available for orders totaling $50 or more.']";
	public static final String RADIO_BUTTON_BNPL = "xpath=//span[text()='Buy now pay later']";
	public static final String BUTTON_BNPL = "xpath=//button[text()='Buy now pay later']";
	public static final String BUTTON_AUTHORIZE_TEST_PAYMENT = "xpath=//button[contains(text(), 'Authorize Test Payment')]";
	public static final String BUTTON_FAIL_TEST_PAYMENT = "xpath=//a[contains(text(), 'Fail Test Payment')]";
	public static final String REDEEM_REWARD_LINK = "xpath=//p[@class='sharing-summary']";

}
