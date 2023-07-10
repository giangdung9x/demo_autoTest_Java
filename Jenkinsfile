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

    def msg_details = """${buildStatus}: Job '${env.JOB_NAME}' [${env.BUILD_NUMBER}]
    Job Name : ${env.JOB_NAME}
    Build : ${env.BUILD_NUMBER}
    """

    if (buildStatus == 'STARTED') {
        color = 'YELLOW'
        colorCode = '#FFFF00'
    } else if (buildStatus == 'SUCCESSFUL') {
        color = 'GREEN'
        colorCode = '#00FF00'
    } else {
        color = 'RED'
        colorCode = '#FF0000'
    }

    //Send notifications
    slackSend(color: colorCode, message: msg_details)
}
