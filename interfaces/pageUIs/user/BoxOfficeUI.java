package pageUIs.user;

public class BoxOfficeUI {

	public static final String EMAIL_TEXTBOX = "xpath=(//input[@id='user_email'])[1]";
	public static final String PASSWORD_TEXTBOX = "xpath=(//input[@id='user_password'])[1]";
	public static final String LOGIN_BUTTON = "xpath=(//input[@name='commit'])[1]";
	
	public static final String TEXT_BOX_OFFICE_SCREEN = "xpath=//h4[text()='Box office']";
	
	public static final String MORE_MENU_BUTTON = "xpath=//div[@class='col-lg-2 d-flex align-center justify-content-between d-mobile-none']//button[text()='More menu']";
	public static final String VALUES_MORE_BUTTON = "xpath=//div[@class='dropdown-default dropdown-menu show']//a[contains(text(), '%s')]";
	
	public static final String TEXT_TITLE_INSTRUCTION_YOUTUBE = "xpath=//yt-formatted-string[@class='style-scope ytd-watch-metadata'][normalize-space()='How to use ShowSlinger box office with card swiper']";
	public static final String LOGIN_BUTTON_HOMEPAGE =  "xpath=//li[@id='nav-menu-item-15650']//a";
	public static final String TEXT_REGISTERED_READERS = "xpath=//h4[text()='Registered readers']";
	public static final String TEXT_BOX_OFFICE_INFORMATION = "xpath=//h4[text()='Box office information']";
	
	public static final String DROPDOWN_PRINTER = "xpath=//span[@data-select2-id='1']//span[@role='combobox']";
	public static final String VALUE_OF_DROPDOWN_PRINTER ="xpath=//li[text()='%s']";
	public static final String VALUE_SELECTED_OF_DROPDOWN_PRINTER = "xpath=//span[text()='Canon LBP2900 (DESKTOP-VMJ4FSM)']";
	public static final String TEXT_SELECT_DEFAULT_PAPER = "xpath=//div[@class='print-paper']//h5[text()='Select default paper']";
	public static final String DROPDOWN_PAPER = "xpath=//span[@data-select2-id='7']//span[@role='combobox']";
	public static final String VALUE_OF_DROPDOWN_PAPER= "xpath=//li[text()='%s']";
	public static final String VALUE_SELECTED_OF_DROPDOWN_PAPER = "xpath=//span[@title='A4']";
	public static final String BUTTON_RESET_REPORT = "xpath=//button[text()='Reset']";
	
	public static final String VALUE_TIX_SOLD = "xpath=//tr[@id='%s']//td[@class='%s']";
	
	public static final String BUTTON_BACK_TO_BOX_OFFICE_FROM_SCREEN_INFORMATION= "xpath=//button[text()='Back to box office']";
	
	public static final String TEXT_ORDER_BOX_OFFICE_SCREEN = "xpath= //h4[text()='Order']";
	public static final String DROPDOWN_VENUE = "xpath=//span[@data-select2-id='3']//span[@role='combobox']";
	public static final String DROPDOWN_EVENT = "xpath=//div[@id='select_ticket_container']//span[@role='combobox']";
	public static final String VALUE_DROPDOWN_VENUE = "xpath=//li[text()='%s']";
	public static final String VALUE_DROPDOWN_EVENT = "xpath=//li[contains(text(), '%s')]";
	
	public static final String BUTTON_CHECK_OUT_OR_ADD_CART = "xpath=//button[text()='%s']";
	public static final String ERROR_MESSAGE_EMPTY_DATA = "xpath=//div[contains(text(), 'Please')]";
	public static final String DROPDOWN_QUANTITY_TICKET = "xpath=//select[@data-name='%s']";

	public static final String RADIO_BUTTON_PAYMENT_CHECKOUT ="xpath=(//span[text()='%s'])[1]";
	
	public static final String BUTTON_PLACE_ORDER = "xpath=//button[@id='btn-place-order']";
	public static final String TEXT_SUCCESS_ORDER = "xpath=//b[text()='Success!']";
	
	public static final String BUTTON_VIEW_ORDER = "xpath=//a[text()='View order']";
	public static final String BLADE_VIEW_ORDER_PAGE = "xpath=//div[@class='bladeContent']";
	public static final String VALUE_OF_DROPDOWN_PRINTER_DEFAULT ="xpath=//li[text()='Please select your printer']";
	public static final String BUTTON_PRINT_ORDER = "xpath=//div[text()='Print order']";
	public static final String BUTTON_BACK_TO_BOX_OFFICE_FROM_ORDER_SUCCESS = "xpath=//a[text()='Back to box office']";
	public static final String BUTTON_AUTHORIZE_TEST_PAYMENT = "xpath=//a[contains(text(), 'Authorize Test Payment')]";
	public static final String BUTTON_FAIL_TEST_PAYMENT = "xpath=//a[contains(text(), 'Fail Test Payment')]";
	public static final String BUTTON_CHARGE_CARD = "xpath=//button[@id='btn-place-order']";
	public static final String TAP_OR_INSERT_TEXT = "xpath=//div[contains(text(), 'Tap or insert payment method')]";
	public static final String BUTTON_CANCEL_CHARGE_CARD = "xpath=//a[text() = 'Cancel']";
	public static final String CARD_INFO_TEXTBOX = "xpath=//input[@placeholder = '%s']";

	public static final String ERROR_MESSAGE_CHARGE_CARD = "xpath=//div[@class='error-message flex justify-center items-center min-h-10 w-full text-red-600 border border-red-600 p-2 mb-5']";
	public static final String NAME_OF_READER = "xpath=//label[text() = 'ss-reader']";
	public static final String CARD_INFO_TEXT = "xpath=//b[text()='Card Info']";
	public static final String IFRAME_CARD_MANUALLY = "xpath=//iframe[@title='Secure card payment input frame']";
	public static final String BUTTON_BACK_TO_TICKET = "xpath=//a[@class='font-semibold text-blue-custom btn-back-to-tickets']";
	public static final String ERROR_MESSAGE_FOOTER_BOX_OFFICE = "xpath=//div[contains(@class, 'bnpl-unavailable-text')]";

	public static final String TEXT_TOTAL_AMOUNT_ORDER_BOX_OFFICE = "xpath=//h3[@class ='color-info fw-600 bo-total-price']";
	public static final String CHECKBOX_EMAIL_BOX_OFFICE = "xpath=//label[@for='delivery_email']";
	public static final String CHECKBOX_CONFIRMATION_DELIVERY = "xpath=(//label[text()='%s'])[1]";
	public static final String CHECKBOX_TEXT_PHONE_BOX_OFFICE = "xpath=//label[@for='delivery_text']";
	


}
