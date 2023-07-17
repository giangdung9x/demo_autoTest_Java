package pageUIs.user;

public class PublicKioskPageUI {
	
	//screen: Choose event
	public static final String PLEASE_CHOOSE_EVENT_TEXT = "xpath=//h2[contains(text(), 'Please choose an event')]";
	public static final String CONFIG_KIOSK_BUTTON = "xpath=//button[contains(text(), 'Config kiosk')]";
	public static final String NAME_OF_EVENT = "xpath=//a[text()='%s']";
	
	//screen: input Access code
	public static final String TEXT_ENTER_CODE_ACCESS = "xpath=//h4[contains(text(), 'Enter code to access the configure page')]";
	public static final String TEXTBOX_INPUT_CODE = "xpath=//input[@id='config_code']";
	public static final String CONFIRM_BUTTON = "xpath=//button[text()='Confirm']";
	public static final String ERROR_MESSAGE_AT_HEADER = "xpath=//div[@role='alert']";
	public static final String BUTTON_BACK_TO_KIOSK = "xpath=//button[text()='Back to kiosk']";

	//screen: Config Kiosk
	public static final String TEXT_CONFIG_KIOSK = "xpath=//h4[text()='Config kiosk']";
	public static final String TEXT_COMPUTER_PRINTER = "xpath=//h5[text()='Computer - Printer']";
	public static final String TEXT_SELECT_DEFAULT_PRINTER = "xpath=//h5[text()='Select default printer']";
	public static final String TEXT_SELECT_DEFAULT_PAPER = "xpath=//div[@class='print-paper']//h5[text()='Select default paper']";
	public static final String TEXT_CARD_READER = "xpath=//h5[text()='Card reader']";
	public static final String TEXT_REPORT = "xpath=//h5[text()='Report']";
	
	public static final String INFO_OF_BUYER = "xpath=//input[contains(@placeholder, '%s')]";
	public static final String DROPDOWN_PRINTER = "xpath=//span[@data-select2-id='1']//span[@role='combobox']";
	public static final String VALUE_OF_DROPDOWN_PRINTER= "xpath=//li[text()='%s']";
	public static final String VALUE_SELECTED_OF_DROPDOWN_PRINTER = "xpath=//span[text()='Canon LBP2900 (DESKTOP-VMJ4FSM)']";
	
	public static final String DROPDOWN_PAPER = "xpath=//span[@data-select2-id='7']//span[@role='combobox']";
	public static final String VALUE_OF_DROPDOWN_PAPER= "xpath=//li[text()='A4']";
	public static final String VALUE_SELECTED_OF_DROPDOWN_PAPER = "xpath=//span[@title='A4']";
	
	public static final String BUTTON_RESET_REPORT = "xpath=//button[text()='Reset']";
	public static final String TEXT_VALUE_TIX_SOLD = "xpath=//td[@id='kiosk_tix_sold']";
	public static final String TEXT_VALUE_TOTAL_AMOUNT = "xpath=//td[@id='kiosk_total_money']";
	public static final String NAME_OF_EVENT_ORDER_SCREEN = "xpath=//h3[@id='ticket-event-name']";
	public static final String TEXT_ORDER = "xpath=//h4[text()='Order']";
	public static final String BUTTON_CHECKOUT_NOW = "xpath=//button[text()='Checkout now']";
	public static final String ERROR_MESSAGE_EMPTY_DATA = "xpath=//div[contains(text(), 'Please ')]";
	public static final String DROPDOWN_QUANTITY_TICKET = "xpath=//select[@data-name='%s']";
	public static final String TEXT_CHECKOUT = "xpath=//b[text()='Checkout']";
	public static final String BUTTON_KIOSK = "xpath=//a[@class='font-semibold text-light']";
	
	public static final String CARD_READER_NAME = "xpath=//label[@for='reader_tmr_FK3gSQIUxoNFF0']"; //update because ID of card update
	public static final String BUTTON_CHARGE_CARD = "xpath=//button[text()='Charge card']";
	public static final String TEXT_TAP_TO_INSERT_PAYMENT = "xpath=//div[contains(text(), 'Tap or insert payment method...')]";
	public static final String TEXT_SUCCESS_PLEASE_WAIT = "xpath=//span[text()='Success! Please wait for your tickets to be printed.']";
	public static final String TEXT_PLEASE_TAKE_YOUR_TICKETS = "xpath=//h3[text()='Please take your tickets']";
	public static final String RADIO_BUTTON_CARD_READER = "xpath=//label[@for='reader_tmr_FK3gSQIUxoNFF0']";//update because ID of card update
	
	public static final String BUTTON_CANCEL_PAYMENT = "xpath=//a[text()='Cancel']";
	public static final String TEXT_PAYMENT_METHOD_DECLINED = "xpath=//h3[text()='Payment method declined']";
	public static final String BUTTON_BACK_FROM_PAYMENT_METHOD_DECLINED = "xpath=//button[text()='Back']";
	public static final String DROPDOWN_TICKET = "xpath=//select[@data-name='vip3']";
	public static final String VALUE_DROPDOWN_TICKET = "xpath=//select[@data-name='vip3']//option[@value='1']";

	public static final String KIOSK_BUTTON_PAYMENT_SCREEN = "xpath=(//a[text()='Kiosk'])[2]";

	public static final String READER_NAME_CHECKOUT_SCREEN = "xpath=//label[normalize-space()='%s']";
}
