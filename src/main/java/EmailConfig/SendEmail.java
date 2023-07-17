package EmailConfig;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SendEmail implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        // Gọi EmailSender ở đây sau khi tất cả các bài kiểm tra tự động đã hoàn thành
        String host = "smtp.gmail.com";
        String port = "465";
        String username = "dangthigiang@mobilefolk.com";
        String password = "reddrrnvnzfivmkz";
        String from = "dangthigiang@mobilefolk.com";
        String[] recipients = {"danggiangmf@gmail.com"};
        //String[] recipients = {"Khanhthi455@gmail.com", "manh@mobilefolk.com", "toan@mobilefolk.com", "viet@mobilefolk.com", "hoangn@mobilefolk.com"};

        Email email;
        email = new Email(host, port, username, password, from, recipients);
        EmailUtil emailSender = new EmailUtil();
        emailSender.sendEmail(email);
    }


}
