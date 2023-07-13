package reportConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import commons.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;

public class AllureTestListener implements ITestListener {
	private int totalTests;
	private int passedTests;
	private int failedTests;
	private int skippedTests;
	private Map<String, Integer> passedTestsByClass;
	private Map<String, Integer> failedTestsByClass;
	private Map<String, Integer> skippedTestsByClass;


	public AllureTestListener() {
		totalTests = 0;
		passedTests = 0;
		skippedTests = 0;
		failedTests = 0;
		passedTestsByClass = new HashMap<>();
		failedTestsByClass = new HashMap<>();
		skippedTestsByClass = new HashMap<>();

	}

	@Attachment(value = "Screenshot of {0}", type = "image/png")
	public static byte[] saveScreenshotPNG(String testName, WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriverInstance();
		saveScreenshotPNG(iTestResult.getName(), driver);
		failedTests++;

		String className = iTestResult.getTestClass().getName();
		failedTestsByClass.put(className, failedTestsByClass.getOrDefault(className, 0) + 1);
		String description = iTestResult.getMethod().getDescription();
		String testName = iTestResult.getMethod().getMethodName();
		writeTestResultToAllure(className, testName, description, "FAILED");
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		skippedTests++;

		String className = result.getTestClass().getName();
		skippedTestsByClass.put(className, skippedTestsByClass.getOrDefault(className, 0) + 1);
		String description = result.getMethod().getDescription();
		String testName = result.getMethod().getMethodName();
		writeTestResultToAllure(className, testName, description,"SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	private void writeTestResultToFile() {
		try {
			String reportPath = "test-result.txt";
			StringBuilder contentBuilder = new StringBuilder();
			contentBuilder.append(String.format("Total Tests: %d\n", totalTests));
			contentBuilder.append(String.format("Passed Tests: %d\n", passedTests));
			contentBuilder.append(String.format("Failed Tests: %d\n", failedTests));
			contentBuilder.append(String.format("Skipped Tests: %d\n", skippedTests));
			contentBuilder.append("\n");

			for (Map.Entry<String, Integer> entry : passedTestsByClass.entrySet()) {
				String className = entry.getKey();
				int passedCount = entry.getValue();
				contentBuilder.append(String.format("Passed Tests in %s: %d\n", className, passedCount));
			}
			for (Map.Entry<String, Integer> entry : failedTestsByClass.entrySet()) {
				String className = entry.getKey();
				int failedCount = entry.getValue();
				contentBuilder.append(String.format("Failed Tests in %s: %d\n", className, failedCount));
			}
			for (Map.Entry<String, Integer> entry : skippedTestsByClass.entrySet()) {
				String className = entry.getKey();
				int skippedCount = entry.getValue();
				contentBuilder.append(String.format("Skipped Tests in %s: %d\n", className, skippedCount));
			}
			contentBuilder.append("\n");

			for (AllureTestResult result : AllureTestResultStorage.getTestResults()) {
				contentBuilder.append(String.format("%s - %s - %s - %s\n",
						result.getClassName(),  result.getTestName(),result.getDescription(), result.getStatus()));
			}

			String content = contentBuilder.toString();
			Files.writeString(Path.of(reportPath), content, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		totalTests++;
		String className = result.getTestClass().getName();
		passedTestsByClass.put(className, passedTestsByClass.getOrDefault(className, 0));
		failedTestsByClass.put(className, failedTestsByClass.getOrDefault(className, 0));
		skippedTestsByClass.put(className, skippedTestsByClass.getOrDefault(className, 0));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		passedTests++;

		String className = result.getTestClass().getName();
		passedTestsByClass.put(className, passedTestsByClass.getOrDefault(className, 0) + 1);
		String description = result.getMethod().getDescription();
		String testName = result.getMethod().getMethodName();
		writeTestResultToAllure(className, testName, description,"PASSED");
	}

	@Override
	public void onFinish(ITestContext context) {
		writeTestResultToFile();
	}

	private void writeTestResultToAllure(String className, String description, String testName, String status) {
		AllureTestResultStorage.addTestResult(new AllureTestResult(className, description, testName, status));
		Status allureStatus = status.equals("PASS") ? Status.PASSED : Status.FAILED;
		StepResult stepResult = new StepResult().setStatus(allureStatus).setName(description);
		Allure.getLifecycle().getCurrentTestCaseOrStep().ifPresent(parentUuid ->
				Allure.getLifecycle().startStep(parentUuid, stepResult));
		Allure.getLifecycle().updateStep(parentUuid ->
				Allure.getLifecycle().stopStep(String.valueOf(parentUuid)));
	}
}

class AllureTestResult {
	private String className;
	private String description;
	private String testName;
	private String status;

	public AllureTestResult(String className, String testName,String description,  String status) {
		this.className = className;
		this.testName = testName;
		this.description = description;
		this.status = status;
	}

	public String getClassName() {
		return className;
	}


	public String getTestName() {
		return testName;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}
}

class AllureTestResultStorage {
	private static List<AllureTestResult> testResults = new ArrayList<>();

	public static void addTestResult(AllureTestResult result) {
		testResults.add(result);
	}

	public static List<AllureTestResult> getTestResults() {
		return testResults;
	}
}
