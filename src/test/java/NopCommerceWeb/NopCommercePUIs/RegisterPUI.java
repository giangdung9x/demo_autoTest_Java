package NopCommerceWeb.NopCommercePUIs;

public class RegisterPUI {
	public static final String REGISTER_LINK = "xpath=//a[normalize-space()='Register']";

	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";

	public static final String ERROR_MESSAGE = "xpath=//span[@id='%s']"; //dùng cách này có thể dùng đi dùng lại với các element có cùng dạng
		public static final String ERROR_MESSAGE_FIRST_NAME = "xpath=//span[@id='FirstName-error']";
		public static final String ERROR_MESSAGE_LAST_NAME = "xpath=//span[@id='LastName-error']";
		public static final String ERROR_MESSAGE_EMAIL = "xpath=//span[@id='Email-error']";
		public static final String ERROR_MESSAGE_PASSWORD = "xpath=//span[@id='Password-error']";
		public static final String ERROR_MESSAGE_CONFIRM_PASSWORD = "xpath=//span[@id='ConfirmPassword-error']";

	public static final String RADIO_GENDER = "xpath=//label[normalize-space()='%s']/preceding-sibling::input";
	public static final String TEXTBOX_REGISTER = "xpath=//label[text()='%s']/following-sibling::input";

	public static final String DROPDOWN_DAY = "xpath=//select[@name='DateOfBirthDay']";
	public static final String DROPDOWN_MONTH = "xpath=//select[@name='DateOfBirthMonth']";
	public static final String DROPDOWN_YEAR = "xpath=//select[@name='DateOfBirthYear']";
	public static final String CHECKBOX_NEWSLETTER = "xpath=//input[@id='Newsletter']";
	public static final String MESSAGE_REGISTER_SUCCESS = "xpath=//div[@class='result']";
	public static final String CONTINUE_BUTTON = "xpath=//a[normalize-space()='Continue']";

	public static final String ERROR_MESSAGE_EMAIL_EXISTS = "xpath=//div[contains(@class, 'message-error')]";

}
