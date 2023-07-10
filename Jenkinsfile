node(‘built-in’) {
     stage (‘Build and test’) {
        try {
                   git 'https://bitbucket.org/mobilefolkteam/showslinger-automation-tests.git'
                   withMaven(globalMavenSettingsConfig: '', jdk: 'Jdk', maven: 'maven', mavenSettingsConfig: '', mavenSettingsFilePath: 'pom.xml', traceability: true) {
                       // some block
                       sh 'mvn clean install'
                   }
               } catch (Exception e) {
                   notifyBuild('FAILED')
                   throw e
               }

    }
}
node{
        echo “Testing guy !”
        notifyBuild(‘SUCCESSFUL’)
}
def notifyBuild(String buildStatus = ‘STARTED’){
    //build status of null successful
    buildStatus = buildStatus ?: ‘SUCCESSFUL’
    //default value
    def colorName = ‘RED’
    def colorCode = ‘#FF0000’
    def now = new Date()
    String timeDate = now.format(“YYYY-MM-DD HH:mm:ss.Ms”)
//     def testCasePass = getTestCasePassCount() // Hàm lấy số lượng test case pass
//     def testCaseFail = getTestCaseFailCount() // Hàm lấy số lượng test case fail
//     def totalTestCaseCount = testCasePass + testCaseFail
//     def reportName = “Extent Reports Link” // Thay thế bằng tên tùy chỉnh cho báo cáo của bạn
//     def reportUrl = “https://1843-58-186-100-87.ngrok-free.app/ExtentReports.html” // Thay thế bằng đường dẫn tới báo cáo thực tế
    def msg_details = “”"${buildStatus}: Job ‘${env.JOB_NAME}’ [${env.BUILD_NUMBER}]
    Job Name : ${env.JOB_NAME}
    Build : ${env.BUILD_NUMBER}
    “”"
//      Total Test Case : ${totalTestCaseCount}
//     Test Case Pass : ${testCasePass}
//     Test Case Fail : ${testCaseFail}
//     Extent Reports : [<${reportUrl}|${reportName}>]
    //Override default values base on build buildStatus
    if(buildStatus == ‘STARTED’) {
        color = ‘YELLOW’
        colorCode = ‘#FFFF00’
    }else if (buildStatus == ‘SUCCESSFUL’) {
        color = ‘GREEN’
        colorCode =‘#00FF00’
    }else {
        color = ‘RED’
        colorCode = ‘#FF0000’
    }
    //Send notifications
    slackSend (color: colorCode,message: msg_details)
}
// def getTestCasePassCount() {
//     // Truy cập vào tệp tin .txt và đếm số lượng test case pass
//     def filePath = ‘ExtentReports/test-result.txt’
//     def fileContent = readFile(file: filePath)
//     def testCasePassCount = fileContent.readLines().count { line -> line.contains(‘PASSED’) }
//
//     return testCasePassCount
// }
//
// def getTestCaseFailCount() {
//     // Truy cập vào tệp tin .txt và đếm số lượng test case fail
//     def filePath = ‘ExtentReports/test-result.txt’
//     def fileContent = readFile(file: filePath)
//     def testCaseFailCount = fileContent.readLines().count { line -> line.contains(‘FAILED’) }
//
//     return testCaseFailCount
// }