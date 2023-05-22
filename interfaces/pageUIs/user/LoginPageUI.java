package pageUIs.user;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "xpath=(//input[@id='user_email'])[1]";
	public static final String PASSWORD_TEXTBOX = "xpath=(//input[@id='user_password'])[1]";
	public static final String FORGOT_PASSWORD_LINK = "xpath=(//a[normalize-space()='Forgot password?'])[1]";

	public static final String LOGIN_BUTTON = "xpath=(//input[@name='commit'])[1]";
	
	public static final String MESSAGE_SUCCESS = "xpath=//p[contains(text(),'You will receive an email with instructions about how to reset your password in a few minutes.')]";
	public static final String NAME_OF_BUYER = "xpath=//input[@placeholder = 'Name *']";
	public static final String PHONE_NUMBER_OF_BUYER = "xpath=//input[@placeholder = 'Phone *']";

}
