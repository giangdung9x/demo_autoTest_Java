pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                git 'https://bitbucket.org/mobilefolkteam/showslinger-automation-tests.git'
            }
        }

        stage('Build and Test') {
            steps {
                withMaven(
                    globalMavenSettingsConfig: '',
                    jdk: 'Jdk',
                    maven: 'maven',
                    mavenSettingsConfig: '',
                    mavenSettingsFilePath: 'pom.xml',
                    traceability: true
                ) {
                    sh 'echo $M2_HOME'
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        success {
            script {
                notifyBuild('SUCCESSFUL')
                deleteResultFile()

            }
        }
        failure {
            script {
                notifyBuild('FAILURE')
                deleteResultFile()
            }
        }
    }
}

def notifyBuild(String buildStatus = 'STARTED') {
    // Build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESSFUL'

    // Default values
    def colorName = buildStatus == 'FAILURE' ? 'RED' : 'GREEN'
    def colorCode = buildStatus == 'FAILURE' ? '#FF0000' : '#00FF00'
    def now = new Date()
    String timeDate = now.format("YYYY-MM-DD HH:mm:ss.Ms")
    def testCasePass = getTestCasePassCount()
    def testCaseFail = getTestCaseFailCount()
    def totalTestCaseCount = testCasePass + testCaseFail
    def reportName = "Allure Reports Link"
    def reportUrl = "https://9cb5-14-232-244-53.ngrok-free.app"

    def buildStatusText = buildStatus == 'FAILURE' ? 'FAILURE' : 'SUCCESSFUL'

    def msg_details = """${buildStatusText}: Job '${env.JOB_NAME}' [${env.BUILD_NUMBER}]
    Job Name: ${env.JOB_NAME}
    Build: ${env.BUILD_NUMBER}
    Time run: ${timeDate}
    Total Test Case : ${totalTestCaseCount}
    Test Case Pass : ${testCasePass}
    Test Case Fail : ${testCaseFail}
    Allure Reports: <${reportUrl}|${reportName}>
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

def deleteResultFile() {
    try {
        String filePath = 'test-result.txt'
        sh "rm ${filePath}"
        echo "Đã xóa tệp tin ${filePath}"
    } catch (Exception e) {
        echo "Đã xảy ra lỗi khi xóa tệp tin: ${e.getMessage()}"
    }
}