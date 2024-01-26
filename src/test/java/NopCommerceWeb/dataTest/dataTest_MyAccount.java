package NopCommerceWeb.dataTest;

import java.util.Random;

public class dataTest_MyAccount {

        //data valid
        public static final String genderMale = "Male";
        public static final String genderFemale = "Female";
        public static final String firstName = "Dang";
        public static final String lastName = "Giang" + generateFakeNumber();
        public static final String dayBirthday = "15";
        public static final String mothBirthday = "July";
        public static final String yearBirthday = "1999";
        public static final String validEmail ="dangthigiang+"+generateFakeNumber()+"@mobilefolk.com";
        public static final String companyName = "Mobilefolk-VN";

        public static final String newPassword = "12345678";


        public static int generateFakeNumber() {
                Random rand = new Random();
                return rand.nextInt(999);
        }

}
