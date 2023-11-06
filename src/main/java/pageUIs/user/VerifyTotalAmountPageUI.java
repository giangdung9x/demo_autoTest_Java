package pageUIs.user;

public class VerifyTotalAmountPageUI {
	
	public static final String LOGIN_LINK = "xpath=(//span[text()='LOGIN'])[1]";


	public static final String TEXTBOX_LOGIN = "xpath=//div[@class='flex-5 d-flex align-items-center white-background']//input[@type='%s']";

	public static final String LOGIN_BUTTON = "xpath=(//input[@name='commit'])[1]";

	public static final String TEXT_TICKETING = "xpath=//h4[text()='Ticketing']";

	public static final String ITEMS_LEFT_MENU = "xpath=//span[text()='%s']";
	
	public static final String CREATE_TICKET_BUTTON = "xpath=//a[text()='Create Ticket']";

	public static final String NAME_OF_POPUP = "xpath=//h2[text()='%s']";
	
	public static final String CREATE_SAVE_BUTTON_POPUP = "xpath=//input[@value='%s']";
	
	public static final String BUTTON_UPDATE_POPUP = "xpath=//button[text()='%s']";


	public static final String ERROR_MESSAGE_AT_FOOTER_POPUP = "xpath=//div[@id='show_ticket_error']";

	public static final String SET_TIME_OF_DAY = "xpath=(//label[text()='%s']/following-sibling::input)[1]";

	public static final String ADD_BUTTON = "xpath=//span[text()='%s']";
	
	public static final String COULMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";

	public static final String TEXTBOX_BY_COULMN_INDEX_AND_ROW_INDEX = "xpath=(//tbody/tr[%s]/td[%s]/input)[1]";

	public static final String TEXTBOX_AMOUNT_BY_COULMN_INDEX_AND_ROW_INDEX = "xpath=(//tbody/tr[%s]/td[%s]/span/input)[1]";

	public static final String COULMN_INDEX_BY_NAME_TICKET = "xpath=//p[text()='Name']";
	
	public static final String TEXTBOX_BY_COULMN_INDEX_AND_ROW_INDEX_TICKET = "xpath=(//input[@name='ticket_details[%s][ticket_name]'])[1]";

	public static final String TEXTBOX_MIN_MAX_TICKET = "xpath=//label[text()='%s']/following-sibling::input";

	public static final String CHECKBOX_ON_SALE = "xpath=//input[@id='ticket_is_public']";
		
	public static final String EVENT_OF_CALENDAR_ON_SALE = "xpath=//strong[text()='%s']/ancestor::li[@class='has-sale']";
	
	public static final String EVENT_OF_CALENDAR_OFF_SALE_COPY = "xpath=(//strong[text()='%s'])[2]";

	public static final String LINK_CANCEL_PREVIEW = "xpath=//a[text()='%s']";

	public static final String FOOTER_BUTTON = "xpath=//div[text()='%s']";
	
	public static final String ERROR_MESSAGE_AT_FOOTER_POPUP_TRANSFER = "xpath=//div[@id='show_transfer_ticket_error']";

	public static final String AUTO_MANUAL_RADIO_BUTTON = "xpath=//input[@value='%s']";

	public static final String REFUND_TICKET_BUTTON = "xpath=//a[normalize-space()='%s']";

	public static final String CLOSE_BUTTON = "xpath=//a[@title='Close']";



	//ADMIN PAGE
	public static final String DASHBOARD_TITLE = "xpath=//h2[text()='%s']";
	public static final String BUTTON_VENUES = "xpath=//a[text()='%s']";
	public static final String INPUT_SEARCH_NAME = "xpath=//input[@id='q_name']";
	public static final String FEES_BY_NAME = "xpath=(//label[contains(text(), '%s')])[4]";
    public static final String ALL_FEES_ADMIN = "xpath=(//label[text()='%s']/following-sibling::input)[1]";

	public static final String BUTTON_UPDATE_VENUE = "xpath=//input[@name='commit']";

}
