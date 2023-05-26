package commons;

public class GlobalConstants {
	//staging
	public static final String ID_VENUE_STAGING = "90";
	public static final String ID_EVENT_STAGING = "3085";
	public static final String PORTAL_PAGE_URL = "https://showslinger-staging.herokuapp.com/";
	public static final String PUBLIC_KIOSK_PAGE_URL = PORTAL_PAGE_URL + "public_kiosks" +"/"+ ID_VENUE_STAGING;
	public static final String BOX_OFFICE_PAGE_URL = PORTAL_PAGE_URL + "box_offices";	
	public static final String ADMIN_PAGE_URL = PORTAL_PAGE_URL + "admin";
	public static final String BUY_ONLINE_URL = PORTAL_PAGE_URL + "ticket_payment" +"/"+ ID_EVENT_STAGING +"/"+ "checkout_ticket";
	
	
	public static final String ID_EVENT_PROD = "3085";
	public static final String PROD_PORTAL_PAGE_URL = "https://app.showslinger.com/";


}
