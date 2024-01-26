package NopCommerceWeb.dataTest;

import java.util.Random;

public class dataTest_Register {

 //data valid
    public static final String genderMale = "Male";
    public static final String genderFemale = "Female";
    public static final String firstName = "Dang";
    public static final String lastName = "Giang" + generateFakeNumber();
    public static final String dayBirthday = "15";
    public static final String mothBirthday = "July";
    public static final String yearBirthday = "1999";
    public static final String validEmail ="dangthigiang+"+generateFakeNumber()+"@mobilefolk.com";
    public static final String validEmailTest ="dangthigiangtest@mobilefolk.com";

    public static final String companyName = "Mobilefolk-VN";
    public static final String password = "123456";
    public static final String confirmPassword = "123456";


//data invalid

    public static final String invalidpassword = "12345";
    public static final String invalidEmail = "dangthigiang@gmail";
    public static final String confirmPasswordInvalid = "1234567";


    //email register before login
    public static final String emailUser ="dangthigiang+"+generateFakeNumber()+"1@mobilefolk.com";

   public static int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(999);
    }




}


