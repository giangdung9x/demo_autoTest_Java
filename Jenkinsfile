node('built-in') {
    stage('Build and test') {
        git 'https://bitbucket.org/mobilefolkteam/showslinger-automation-tests.git'
        withMaven(globalMavenSettingsConfig: '', jdk: 'Jdk', maven: 'maven', mavenSettingsConfig: '', mavenSettingsFilePath: 'pom.xml', traceability: true) {
            // some block

            sh  'mvn clean install'
        }
    }
}

node {
    echo "Testing guy!"
    try {
        sh 'echo $M2_HOME'

        sh 'export PATH="$M2_HOME/bin:$PATH" &&mvn test'
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
    def colorName = 'RED'
    def colorCode = '#FF0000'
    def now = new Date()
    String timeDate = now.format("YYYY-MM-DD HH:mm:ss.Ms")

    def reportName = "Allure Reports Link"
    def reportUrl = "https://a8d2-27-72-144-248.ngrok-free.app/index.html"

    def buildStatusText = buildStatus == 'FAILURE' ? 'FAILURE' : 'SUCCESSFUL'
    def color = buildStatusText == 'FAILURE' ? 'RED' : 'GREEN'

    def msg_details = """${buildStatusText}: Job '${env.JOB_NAME}' [${env.BUILD_NUMBER}]
    Job Name : ${env.JOB_NAME}
    Build : ${env.BUILD_NUMBER}
    Time run : ${timeDate}
    Allure Reports : <${reportUrl}|${reportName}>
    """

    slackSend(color: colorCode, message: msg_details)
}

