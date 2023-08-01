#!/bin/sh

echo "------ Step 01: Set current project path to variable -------"
project_path=$(pwd)

echo "------ Step 02: Go to project path folder -------"
cd "$project_path"

echo "------ Step 03: Run the testcases -------"
java -javaagent:"$project_path/libAllureReport/aspectjweaver-1.9.8.jar" -classpath "$project_path/bin:$project_path/libAllureReport/*:$project_path/libLog4J/*:$project_path/lib/*:$project_path/libReportNG/*:$project_path/libWebDriverManager/*:$project_path/libSelenium/*" org.testng.TestNG "$project_path/bin/runShowSlingerTest.xml"

echo "------ Step 04: Load allure command line setting -------"
source ~/.bash_profile

echo "------ Step 05: Generate Allure XML Report -------"
allure generate allure-results -o "$project_path/allure-report" --clean

echo "------ Step 06: Store Allure Report in a Directory -------"
current_date=$(date '+%Y-%m-%d-%H-%M-%S')
report_directory="$project_path/reports/$current_date"
mkdir -p "$report_directory"
cp -R "$project_path/allure-report" "$report_directory"