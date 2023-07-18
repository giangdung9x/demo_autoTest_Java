package pageUIs.user;

public class AttendeePageUI {
	
	public static final String LOGIN_LINK = "xpath=(//span[text()='LOGIN'])[1]";
	public static final String TEXTBOX_LOGIN = "xpath=//div[@class='flex-5 d-flex align-items-center white-background']//input[@type='%s']";
	public static final String LOGIN_BUTTON = "xpath=(//input[@name='commit'])[1]";
	
	public static final String ITEMS_LEFT_MENU = "xpath=//span[text()='%s']";
	public static final String ITEMS_OF_LIST_TICKETING = "xpath=//a[text()='%s']";
	
	public static final String NAME_OF_SCREEN = "xpath=//h4[text()='%s']";
	public static final String SEARCH_REPORT_BAR = "xpath=(//input[@placeholder='Search'])[2]";
	public static final String ACTION_DROPDOWN_BUTTON = "xpath=(//div[text()='%s']/following::td/div[@class='dropdown-custom-ss dropdown dropdown-scroll-into-view'])[1]";
	public static final String ITEMS_OF_DROPDOWN = "xpath=//div[@class='dropdown-default dropdown-menu show']//a[@class='dropdown-item'][normalize-space()='%s']";

	
	//ATTENDEE LIST 
	public static final String ACTION_BUTTON = "xpath=//button[@id='btn-tix-action']";
	public static final String ACTION_DROPDOWN= "xpath=//select[@id='action_selector']";
	public static final String FITER_ORDER_BY_STATUS_DROPDOWN= "xpath=//select[@id='filter_status']";
	public static final String CHECKBOX_OF_ORDER_BY_NUMERICAL = "xpath=(//label[contains(@for,'tix-desktop-selectbox')])[%s]";

	//POPUP TRANSFER
	public static final String NAME_OF_POPUP = "xpath=//h6[normalize-space()='%s']";
	public static final String DROPDOWN_TICKET_OF_CURRENT_EVENT = "xpath=//select[@id='source_quantity']";
	public static final String DROPDOWN_EVENT_TRANSFER_TO = "xpath=//select[@id='transfer_ticket']";
	public static final String EVENT_NAME_OF_DROPDOWN = "xpath=//option[contains(text(), '%s')]";
	public static final String DROPDOWN_TICKET_OF_TRANSFER_EVENT_TO = "xpath=(//h5[text()='Select tickets & add-ons']/parent::div//div[@class='row pr-3']//select)[1]";
	public static final String BUTTON_TRANSFER = "xpath=//button[@id='transfer-order']";
	public static final String MESSAGE_RESULT = "xpath=//span[@id='result-message']";
	public static final String MESSAGE_RESULT_REFUND = "xpath=//span[@id='refund-message']";

	public static final String BUTTON_REFUND = "xpath=//button[normalize-space()='%s']";
	public static final String MESSAGE_POPUP = "xpath=//span[normalize-space()='This order is not valid to refund!']";
	public static final String QUANTITY_TICKET_PARTIAL_REFUND = "xpath=(//div[@class='selectbox partial-refund-select-box w-100 desktop-partial-refund-selector']//select)[1]";

}
