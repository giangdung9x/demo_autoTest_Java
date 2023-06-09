
# Test Automation Framework Selenium Java with TestNG of ShowSlinger Project
Create by dangthigiang@mobilefolk.com
## 1. Project Overview
Test Automation Framework - Reusable template for Java/Selenium frameworks. Learn more about the project here: https://app.showslinger.com

## 2. Tech Stack
  - Java 11
  - TestNG
  - Selenium
  - Allure Report
## 3. Getting started 

### Prerequisites
- Java 11 SDK (https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- Use IntelliJ IDEA is the best choice (easy change the JDK version)
- Install Chrome Browser, Edge Browser, Firefox Browser
- TestNG libraries(https://mvnrepository.com/artifact/org.testng/testng/6.14.3)
- Allure Report ( Allure Command Line - https://github.com/allure-framework/allure2/releases/tag/2.13.6)

### Setting Allure Report
-Add folder Allure to PATH
<br> `export ALLURE_HOME=/Volumes/Coding/Software/allure-2.13.6`
<br> `export PATH=$PATH:$ALLURE_HOME/bin`


### Clone the repository & run the project
Launch Terminal.app and navigate (using cd command) to directory, where you'd like to store your copy of the source code

Use the command below to clone the repository to your local directory

git clone  `git@bitbucket.org:mobilefolkteam/showslinger-automation-tests.git `

Navigate (using `cd` command) to the root directory of the project

Add TestNG in classpath of the project

Open Allure Report 
- At project folder > Open Terminal > ./runAllureOnMacOS.sh
- If you use a command line that ends with /, you will receive a folder
  ./allure-json/
- If it doesn't end with / then get file
  ./runAllureOnMacOS.sh

## 4. Contact information  
Name - Role - Email  

