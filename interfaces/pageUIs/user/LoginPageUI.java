package pageUIs.user;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "xpath=(//input[@id='user_email'])[1]";
	public static final String PASSWORD_TEXTBOX = "xpath=(//input[@id='user_password'])[1]";
	
	public static final String LOGIN_BUTTON = "xpath=//div[@xpath='1']//input[@name='commit']";
	
	public static final String MESSAGE_SUCCESS = "(//p[contains(text(),'You will receive an email')])[1]";

}
