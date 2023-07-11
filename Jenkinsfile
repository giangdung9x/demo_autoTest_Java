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
    notifyBuild('STARTED')
}

def notifyBuild(String buildStatus = 'STARTED') {
    //build status of null successful
    buildStatus = buildStatus ?: 'SUCCESSFUL'

    //default value
    def colorCode = '#FF0000'
    def now = new Date()
    String timeDate = now.format("YYYY-MM-DD HH:mm:ss.Ms")

    def reportName = "Extent Reports Link"
    def reportUrl = "https://1843-58-186-100-87.ngrok-free.app/ExtentReports.html"

    def buildStatusText = buildStatus == 'FAILURE' || testCaseFail > 0 ? 'FAILURE' : 'SUCCESSFUL'
    def color = buildStatusText == 'FAILURE' ? '#FF0000' : '#00FF00'

    def msg_details = """${buildStatusText}: Job '${env.JOB_NAME}' [${env.BUILD_NUMBER}]
    Job Name : ${env.JOB_NAME}
    Build : ${env.BUILD_NUMBER}
    Time run : ${timeDate}
    Extent Reports : <${reportUrl}|${reportName}>
    """

    slackSend(color: color, message: msg_details)
}
