#!/bin/sh

echo "------ Step 01: Set project path to variable -------"
project_path="/Users/Automation Testing/Automation_Testing_MBF/mbf_maven_framework_showslinger"
echo "------ Step 02: Go to project path folder -------"
cd "$project_path"
echo "------ Step 03: Run the testcases -------"
java -javaagent:"$project_path/libAllureReport/aspectjweaver-1.9.8.jar" -classpath "$project_path/bin:$project_path/libAllureReport/*:$project_path/libLog4J/*:$project_path/lib/*:$project_path/libReportNG/*:$project_path/libWebDriverManager/*:$project_path/libSelenium/*" org.testng.TestNG "$project_path/bin/runShowSlingerTest.xml"
echo "------ Step 04: Generate Allure HTML Report -------"
allure generate "$project_path/allure-json" -o "$project_path/allure-report"
echo "------ Step 05: Get Allure Report URL -------"
allure_report_url="http://localhost:8000/allure-report/index.html"  # Thay 'port' bằng cổng thích hợp
echo "Allure Report URL: $allure_report_url"
