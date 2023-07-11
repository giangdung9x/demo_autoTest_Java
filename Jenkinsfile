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
    def buildResult = sh(returnStatus: true, script: 'mvn -q -Dexec.executable="echo" -Dexec.args="\${env.MVN_BUILD_RESULT}" --non-recursive exec:exec').trim()
    def testCaseFail = sh(returnStdout: true, script: 'mvn -q -Dexec.executable="echo" -Dexec.args="\${env.TEST_CASE_FAIL}" --non-recursive exec:exec').trim().toInteger()

    notifyBuild(buildResult, testCaseFail)
}

def notifyBuild(String buildResult, int testCaseFail) {
    def buildStatus = buildResult == 'SUCCESS' && testCaseFail == 0 ? 'SUCCESSFUL' : 'FAILURE'
    def colorCode = buildStatus == 'SUCCESSFUL' ? '#00FF00' : '#FF0000'

    def msg_details = """${buildStatus}: Job '${env.JOB_NAME}' [${env.BUILD_NUMBER}]
    Job Name : ${env.JOB_NAME}
    Build : ${env.BUILD_NUMBER}
    """

    slackSend(color: colorCode, message: msg_details)
}
