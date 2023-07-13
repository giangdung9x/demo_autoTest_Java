node {
    echo "Testing guy!"
    try {
        git 'https://bitbucket.org/mobilefolkteam/showslinger-automation-tests.git'
        withMaven(globalMavenSettingsConfig: '', jdk: 'Jdk', maven: 'maven', mavenSettingsConfig: '', mavenSettingsFilePath: 'pom.xml', traceability: true) {
            sh 'echo $M2_HOME'
            sh 'mvn test'
        }
    } catch (Exception e) {
        notifyBuild('FAILURE')
        throw e
    }
    notifyBuild('SUCCESSFUL')
}

def notifyBuild(String buildStatus = 'STARTED') {
    //build status of null successful
    buildStatus = buildStatus ?: 'SUCCESSFUL'

    //default value
    def colorName = buildStatus == 'FAILURE' ? 'RED' : 'GREEN'
    def colorCode = buildStatus == 'FAILURE' ? '#FF0000' : '#00FF00'
    def now = new Date()
    String timeDate = now.format("YYYY-MM-DD HH:mm:ss.Ms")

    def testCasePass = getTestCasePassCount()
    def testCaseFail = getTestCaseFailCount()
    def testCaseSkip = getTestCaseSkipCount()
    def totalTestCaseCount = testCasePass + testCaseFail + testCaseSkip
    def reportName = "Allure Reports Link"
    def reportUrl = "https://a8d2-27-72-144-248.ngrok-free.app/index.html"

    def buildStatusText = buildStatus == 'FAILURE' ? 'FAILURE' : 'SUCCESSFUL'

    def msg_details = """${buildStatusText}: Job '${env.JOB_NAME}' [${env.BUILD_NUMBER}]
    Job Name : ${env.JOB_NAME}
    Build : ${env.BUILD_NUMBER}
    Time run : ${timeDate}
    Total Test Case : ${totalTestCaseCount}
    Test Case Pass : ${testCasePass}
    Test Case Fail : ${testCaseFail}
    Test Case Skip : ${testCaseSkip}
    Allure Reports : <${reportUrl}|${reportName}>
    """

    slackSend(color: colorCode, message: msg_details)
}

def getTestCasePassCount() {
    // Truy cập vào tệp tin .txt và đếm số lượng test case pass
    def filePath = 'test-result.txt'
    def fileContent = readFile(file: filePath)
    def testCasePassCount = fileContent.readLines().count { line -> line.contains('PASSED') }

    return testCasePassCount
}

def getTestCaseFailCount() {
    // Truy cập vào tệp tin .txt và đếm số lượng test case fail
    def filePath = 'test-result.txt'
    def fileContent = readFile(file: filePath)
    def testCaseFailCount = fileContent.readLines().count { line -> line.contains('FAILED') }

    return testCaseFailCount
}

def getTestCaseSkipCount() {
    // Truy cập vào tệp tin .txt và đếm số lượng test case pass
    def filePath = 'test-result.txt'
    def fileContent = readFile(file: filePath)
    def testCasePassCount = fileContent.readLines().count { line -> line.contains('SKIPPED') }

    return testCaseSkipCount
}