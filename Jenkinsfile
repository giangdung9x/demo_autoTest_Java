node('built-in') {
    stage('Build and test') {
        git 'https://bitbucket.org/mobilefolkteam/showslinger-automation-tests.git'
        withMaven(globalMavenSettingsConfig: '', jdk: 'Jdk', maven: 'maven', mavenSettingsConfig: '', mavenSettingsFilePath: 'pom.xml', traceability: true) {
            // some block
            sh 'mvn clean install'
        }
    }
}

node {
    echo "Testing guy !"
    notifyBuild('SUCCESSFUL')
}

def notifyBuild(String buildStatus = 'STARTED') {
    //build status of null successful
    buildStatus = buildStatus ?: 'SUCCESSFUL'

    //default value
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def now = new Date()
    String timeDate = now.format("YYYY-MM-DD HH:mm:ss.Ms")

    def reportName = "Extent Reports Link"
    def reportUrl = "https://1843-58-186-100-87.ngrok-free.app/ExtentReports.html"

    def buildStatusText = buildStatus == 'FAILURE' || testCaseFail > 0 ? 'FAILURE' : 'SUCCESSFUL'
    def color = buildStatusText == 'FAILURE' ? 'RED' : 'GREEN'

    def msg_details = """${buildStatusText}: Job '${env.JOB_NAME}' [${env.BUILD_NUMBER}]
    Job Name : ${env.JOB_NAME}
    Build : ${env.BUILD_NUMBER}
    Time run : ${timeDate}
    Extent Reports : <${reportUrl}|${reportName}>
    """


    if (testCaseFail > 0 || buildStatus == 'FAILURE') {
        slackSend(color: '#FF0000', message: msg_details)
    } else {
        slackSend(color: '#00FF00', message: msg_details)
    }
}


