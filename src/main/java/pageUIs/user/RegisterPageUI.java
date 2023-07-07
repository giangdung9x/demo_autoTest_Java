package pageUIs.user;

public class RegisterPageUI {
	
	public static final String REGISTER_BUTTON = "xpath=(//input[@name='commit'])[1]";
	public static final String IMAGE_CALL_FORM_REGISTER = "xpath=//a[@id='ss-logo']//img";
	public static final String RADIO_BUTTON_VENUE = "xpath=//label[@for='radio-account_type-venue']";
	public static final String RADIO_BUTTON_ARTIST = "xpath=//label[@for='radio-account_type-performer']";

	public static final String EMAIL_ERROR_MESSAGE = "xpath=//label[@id='sign_up_email-error']";
	public static final String PASSWORD_ERROR_MESSAGE = "xpath=//label[@id='sign_up_password-error']";
	public static final String CONFIRM_TERMS_ERROR_MESSAGE = "xpath=//label[@id='sign_up[accepted_tos]-error']";
	
	
	public static final String TEXTBOX_REGISTER = "xpath=//div[@class='d-flex flex-direction-column front-site-form']//input[contains(@id, 'sign_up') and @placeholder='%s']";
	public static final String CHECKBOX_TERMS_SERVICE = "xpath=//label[@for='sign_up_accepted_tos']";
	public static final String ERROR_MESSAGE_HEADER = "xpath=//div[@class='alert-content']//p";
	public static final String IFRAME_RECAPTCHA = "xpath=//iframe[@title='reCAPTCHA' and @name='a-9eicoga2q58i']";
	public static final String CHECKBOX_NOT_HUMAN = "xpath=";
	
	//VENUE
	public static final String TEXT_CREATE_YOUR_VENUE_PROFILE = "xpath=//h3[text()='Create Your Venue Profile']";
	public static final String CREATE_VENUE_BUTTON = "xpath=//input[@value='Create Venue']";
	public static final String ERROR_MESSAGE_AT_FIELD = "xpath=//label[contains(text(), '%s')]/following-sibling::span[@class='error']";
	public static final String TEXTBOX_PROFILE_VENUE = "xpath=//label[contains(text(), '%s')]/following-sibling::input";
	
	public static final String TEXT_ADD_PHOTO = "xpath=//h3[text()='Add a Photo']";
	public static final String UPLOAD_IMAGE_BUTTON = "xpath=//input[@value='Upload']";
	public static final String ERROR_MESSAGE_NOT_UPLOAD_PHOTO = "xpath=//div[@class='alert']";
	public static final String SKIP_UPLOAD_IMAGE_BUTTON = "xpath=//a[text()='or Skip']";
	
	public static final String TEXT_TICKETING = "xpath=//span[text()='Ticketing']";
	
	
	//ARTIST
	public static final String TEXT_PROFILE_INFORMATION = "xpath=//div[@class='d-flex flex-direction-column front-site-form']//h3[@class='title-text'][text()='Profile information']";
	public static final String NEXT_BUTTON = "xpath=//div[@class='d-flex flex-direction-column front-site-form']//input[@value='Next']";
	public static final String TEXTBOX_PROFILE_INFORMATION = "xpath=//div[@class='d-flex flex-direction-column front-site-form']//input[@placeholder='%s' and contains(@id, 'act_form')]";
	public static final String DROPDOWN_SELECT_PROFILE_TYPE = "xpath=//div[@class='d-flex flex-direction-column front-site-form']//select[@id='act_form_entertainment_type_id']";
	public static final String SEND_BUTTON = "xpath=//div[@class='d-flex action-btn-group']//input[@value='Send']";
	public static final String SKIP_BUTTON = "xpath=//div[@class='d-flex action-btn-group']//a[@class='skip-link'][text()='Skip']";
	public static final String TEXT_WE_NEED_VERIFY = "xpath=//h3[@id='verify-title-text']";
	public static final String TEXT_DASHBOARD = "xpath=//span[text()='Dashboard']";

}
