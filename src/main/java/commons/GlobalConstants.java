package commons;

import java.io.File;

public class GlobalConstants {
	//staging
	public static final String ID_VENUE_STAGING = "90";
	public static final String ID_EVENT_STAGING = "3085";
	public static final String PORTAL_PAGE_URL = "https://showslinger-staging.herokuapp.com/";
	public static final String PUBLIC_KIOSK_PAGE_URL = PORTAL_PAGE_URL + "public_kiosks" +"/"+ ID_VENUE_STAGING;
	public static final String BOX_OFFICE_PAGE_URL = PORTAL_PAGE_URL + "box_offices";	
	public static final String ADMIN_PAGE_URL = PORTAL_PAGE_URL + "admin";
	public static final String BUY_ONLINE_URL = PORTAL_PAGE_URL + "ticket_payment" +"/"+ ID_EVENT_STAGING +"/"+ "checkout_ticket";
	public static final String YOPMAIL = "https://yopmail.com/";	

	
	public static final String ID_EVENT_PROD = "3085";
	public static final String PROD_PORTAL_PAGE_URL = "https://app.showslinger.com/";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles"+ File.separator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImages" + File.separator;

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT =10 ;
	public static final long RETRY_TEST_FAIL = 10;
	
	public static final String BROWSER_STACK_URL = null;
	public static final String SAUCE_URL = null;
	public static final String LAMBDA_URL = null;

}
