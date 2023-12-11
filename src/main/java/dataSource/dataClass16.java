package dataSource;

import java.util.Random;

public class dataClass16 {
    //data of class 16
    public static final String emailManager ="paulv@showslinger.com";
    public static final String passwordManager = "12345";

    //info event
    public static final String dayStart = "01/12/2023";
    public static final String dayEnd = "30/12/2023";
    public static final String eventName = "Test verify amount" +" " + generateFakeNumber();
    public static final String price ="100";
    public static final String totalTicket ="100";
    public static final String minTicket ="1";
    public static final String maxTicket ="10";


    public static final String ticketName ="Vip 1";
    public static final String quantity ="1";

    //info customer
    public static final String fullName = "Dang Thi Giang";
    public static final String  phone = "+128379292999";
    public static final String validEmail = "dangthigiang+2@mobilefolk.com";
    public static final String cardNumberValid = "4242424242424242";
    public static final String  monthYearValid = "0424";
    public static final String cvc = "242";
    public static final String zip = "42424";

    //
    public static double baseFeeSS;
    public static double baseFeeSSCash;
    public static double perFeeSS;
    public static double perFeeSSCash;

    public static String baseFeeSS_input = "2,0";
    public static String baseFeeSSCash_input = "0,01";
    public static String perFeeSS_input = "0,0";
    public static String perFeeSSCash_input = "0,0";



    public static final double tax = 0;

    // Percentage and fixed fee for online payments
    public static final double onlinePercentageFee = 0.029;
    public static final double onlineFixedFee = 0.3;


    // Percentage and fixed fee for card reader payments
    public static final double cardReaderPercentageFee= 0.027;
    public static final double cardReaderFixedFee= 0.05;


    // Percentage and fixed fee for cash payments
    public static final double cashPercentageFee = 0;
    public static final double cashFixedFee = 0;


    // Percentage and fixed fee for discount voucher payments
    public static final double compPercentageFee = 0;
    public static final double compFixedFee= 0;

    // Percentage and fixed fee for card reader payments - pay later
    public static final double payLaterPercentageFee= 0.06;
    public static final double payLaterFixedFee= 0.3;

    public static int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(999);
    }




}


