package EmailConfig;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmailUtil {

    public static void sendEmail(Email email) {
        Properties props = new Properties();
        props.put("mail.smtp.host", email.getHost());
        props.put("mail.smtp.socketFactory.port", email.getPort());
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", email.getPort());

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email.getUsername(), email.getPassword());
                    }
                });
        try {

            // Lấy thông tin về các test case
            String filePath = "test-result.txt";
            int passCases = getPassedTestCaseCount(filePath);
            int failCases = getFailedTestCaseCount(filePath);
            int skipCases = getSkipTestCaseCount(filePath);
            int totalCases = getTotalTestCase(passCases, failCases);


            // Tạo các biểu đồ và lưu chúng vào file
            createBarChart(passCases, failCases, skipCases, totalCases);
            createPieChart(passCases, failCases, skipCases);

            // Tạo nội dung email với các tệp biểu đồ
            File barChartFile = new File("chart.png");
            File pieChartFile = new File("pie-chart.png");
            File fileResult = new File("test-result.txt");
            String emailContent = getEmailContentWithImages();

            // Tạo message và thiết lập thông tin
            Message message = new MimeMessage(session);
            InternetAddress[] recipients = new InternetAddress[email.getRecipients().length];
            for (int i = 0; i < email.getRecipients().length; i++) {
                recipients[i] = new InternetAddress(email.getRecipients()[i]);
            }
            message.setRecipients(Message.RecipientType.TO, recipients);
            message.setFrom(new InternetAddress(email.getFrom()));
            message.setSubject(subject);

            // Tạo và đính kèm MimeBodyPart chứa nội dung email
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(emailContent, "text/html");

            // Tạo và đính kèm MimeBodyPart chứa biểu đồ bar chart
            MimeBodyPart barChartBodyPart = new MimeBodyPart();
            DataSource barChartSource = new FileDataSource(barChartFile);
            barChartBodyPart.setDataHandler(new DataHandler(barChartSource));
            barChartBodyPart.setFileName(barChartFile.getName());

            // Tạo và đính kèm MimeBodyPart chứa biểu đồ pie chart
            MimeBodyPart pieChartBodyPart = new MimeBodyPart();
            DataSource pieChartSource = new FileDataSource(pieChartFile);
            pieChartBodyPart.setDataHandler(new DataHandler(pieChartSource));
            pieChartBodyPart.setFileName(pieChartFile.getName());

            MimeBodyPart file = new MimeBodyPart();
            DataSource fileDataSource = new FileDataSource(fileResult);
            file.setDataHandler(new DataHandler(fileDataSource));
            file.setFileName(fileResult.getName());


            // Tạo Multipart và thêm các MimeBodyPart
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(barChartBodyPart);
            multipart.addBodyPart(pieChartBodyPart);
            multipart.addBodyPart(file);

            // Thiết lập Multipart cho message và gửi email
            message.setContent(multipart);
            Transport.send(message);

            System.out.println("=====Email Sent=====");

        } catch (MessagingException e) {

            throw new RuntimeException(e);
        }
    }

    private static String subject = "Test Report - ShowSlinger";

    public static String getEmailContentWithImages() {
        String content = "<p>Dear SHOWSLINGER project members,</p>\n" +
                "<p>Automation Team is sending the execution report of project ShowSlinger, version <b>version_build</b>.</p>\n" +
                "<p>Build result: <b>build_result</b></p>\n" +
                "<p>Time run: <b>" + getTimeExecution() + "</b></p>\n" +
                "<p>Report Links: <a href=\"https://9cb5-14-232-244-53.ngrok-free.app\">Allure Report Link</a></p>\n" +
                "<p><i>(This is an automated release email after execution. Please contact Automation Team if you need further information!)</i></p>";

        // Chèn hình ảnh vào nội dung email
        String barChartContent = "<img src=\"cid:bar-chart\">";
        String pieChartContent = "<img src=\"cid:pie-chart\">";
//        File fileSuites = new File("ExtentReports/test-result.txt");

        // Tạo hàng chứa hai cột biểu đồ
        String rowContent = "<tr><td align=\"center\">" + barChartContent + "</td><td align=\"center\">" + pieChartContent + "</td></tr>";

        // Tạo bảng chứa văn bản và biểu đồ
        String tableContent = "<table>" +
                "<tr><td>" + content + "</td></tr>" +
                rowContent +
                "</table>";

        return tableContent;
    }


    public static void createBarChart(int passCases, int failCases, int skipCases, int totalCases) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(totalCases, "Total Cases", "Total");
        dataset.addValue(passCases, "Pass Cases", "Pass");
        dataset.addValue(failCases, "Fail Cases", "Fail");
        dataset.addValue(skipCases, "Skip Cases", "Skip");

        JFreeChart chart = ChartFactory.createBarChart(
                "Test Case Results", // Tiêu đề biểu đồ
                "Result", // Nhãn trục x
                "Number of Cases", // Nhãn trục y
                dataset, // Dữ liệu
                PlotOrientation.VERTICAL, // Hướng biểu đồ
                true, // Hiển thị legenda
                true, // Hiển thị tooltips
                false // Hiển thị URLs
        );

        // Thiết lập màu sắc cho biểu đồ
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlinePaint(Color.WHITE);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(5.6);

        // Đặt BarPainter tùy chỉnh cho renderer
        renderer.setBarPainter(new GradientBarPainter());
        renderer.setShadowVisible(false);
        renderer.setDefaultBarPainter(new StandardBarPainter());
        renderer.setDrawBarOutline(true);
        renderer.setSeriesOutlinePaint(0, Color.BLACK);
        renderer.setSeriesOutlinePaint(1, Color.BLACK);
        renderer.setSeriesOutlinePaint(2, Color.BLACK);
        renderer.setSeriesOutlinePaint(3, Color.BLACK);
        renderer.setSeriesOutlineStroke(0, new BasicStroke(1.5f));
        renderer.setSeriesOutlineStroke(1, new BasicStroke(1.5f));
        renderer.setSeriesOutlineStroke(2, new BasicStroke(1.5f));
        renderer.setSeriesOutlineStroke(3, new BasicStroke(1.5f));

        renderer.setSeriesPaint(0, Color.decode("#375E97")); // Màu xám cho tổng số test case
        renderer.setSeriesPaint(1, Color.decode("#3F681C")); // Màu xanh lá cây cho test case pass
        renderer.setSeriesPaint(2, Color.decode("#FB6542")); // Màu đỏ cho test case fail
        renderer.setSeriesPaint(3, Color.decode("#FFBB00")); // Màu vàng cho test case skip

        // Các thiết lập khác cho biểu đồ
        LegendTitle legend = chart.getLegend();
        legend.setItemLabelPadding(new RectangleInsets(0, 0, 0, 30)); // Thêm khoảng cách 20px giữa các chú thích

        // Hiển thị số trên đỉnh của mỗi cột
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER, TextAnchor.CENTER, -Math.PI / 2);
        renderer.setPositiveItemLabelPositionFallback(position);

        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // Đặt vị trí của nhãn trục
        xAxis.setTickLabelFont(new Font("Tahoma", Font.PLAIN, 13)); // Đặt font chữ cho nhãn trục

        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setTickLabelFont(new Font("Tahoma", Font.PLAIN, 13)); // Đặt font chữ cho nhãn trục

        // Thiết lập kích thước cho biểu đồ
        chart.getLegend().setItemFont(new Font("Tahoma", Font.PLAIN, 14));
        chart.getTitle().setFont(new Font("Tahoma", Font.BOLD, 18));
        chart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("Tahoma", Font.PLAIN, 16));
        chart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("Tahoma", Font.PLAIN, 16));
        chart.getCategoryPlot().getRenderer().setItemLabelFont(new Font("Tahoma", Font.PLAIN, 14));
        chart.getCategoryPlot().getRenderer().setBaseItemLabelsVisible(true);
        chart.getCategoryPlot().getRenderer().setBasePositiveItemLabelPosition(new ItemLabelPosition(
                ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER));

        File barChartFile = new File("chart.png");
        try {
            ChartUtils.saveChartAsPNG(barChartFile, chart, 800, 470);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createPieChart(int passCases, int failCases, int skipCases) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Pass", passCases);
        dataset.setValue("Fail", failCases);
        dataset.setValue("Skip", skipCases);

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Case Results", // Tiêu đề biểu đồ
                dataset, // Dữ liệu
                true, // Hiển thị legenda
                true, // Hiển thị tooltips
                false // Hiển thị URLs
        );

        // Các thiết lập khác cho biểu đồ

        chart.setBackgroundPaint(Color.WHITE);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlinePaint(Color.WHITE);

        plot.setSectionPaint("Pass", Color.decode("#3F681C")); // Màu xanh lá cây cho test case pass
        plot.setSectionPaint("Fail", Color.decode("#FB6542")); // Màu đỏ cho test case fail
        plot.setSectionPaint("Skip", Color.decode("#FFBB00")); // Màu vàng cho test case skip

        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));
        plot.setLabelBackgroundPaint(new Color(255, 255, 255, 200));
        plot.setLabelFont(new Font("Tahoma", Font.PLAIN, 16));
        plot.setLabelShadowPaint(null);

        chart.getLegend().setItemFont(new Font("Tahoma", Font.PLAIN, 16));
        chart.getTitle().setFont(new Font("Tahoma", Font.BOLD, 18));


        LegendTitle legend = chart.getLegend();
        legend.setItemLabelPadding(new RectangleInsets(0, 0, 0, 30));

        // save the pie chart as a PNG file
        File pieChartFile = new File("pie-chart.png");
        try {
            ChartUtils.saveChartAsPNG(pieChartFile, chart, 800, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getPassedTestCaseCount(String filePath) {
        int passedTestCaseCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("PASSED")) {
                    passedTestCaseCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return passedTestCaseCount;
    }

    public static int getFailedTestCaseCount(String filePath) {
        int failedTestCaseCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("FAILED")) {
                    failedTestCaseCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return failedTestCaseCount;
    }

    public static int getSkipTestCaseCount(String filePath) {
        int skipTestCaseCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("SKIPPED")) {
                    skipTestCaseCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return skipTestCaseCount;
    }

    public static int getTotalTestCase(int tcPass, int tcFail) {
        return tcPass + tcFail;
    }

    public static String getTimeExecution() {
        // Lấy thời gian hiện tại
        Date now = new Date();

        // Định dạng thời gian
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Chuyển đổi thời gian thành chuỗi
        String timeExecution = sdf.format(now);

        return timeExecution;
    }

}


