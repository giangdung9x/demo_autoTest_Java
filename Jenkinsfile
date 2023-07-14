def testResultsFile = 'test-result.txt'

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Testing guy!'
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://bitbucket.org/mobilefolkteam/showslinger-automation-tests.git']]])
            }
        }

        stage('Build and Test') {
            steps {
                withMaven(globalMavenSettingsConfig: '', jdk: 'Jdk', maven: 'maven', mavenSettingsConfig: '', mavenSettingsFilePath: 'pom.xml', traceability: true) {
                    sh 'echo $M2_HOME'
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        always {
            script {
                def totalTests = 0
                def passedTests = 0
                def failedTests = 0
                def skippedTests = 0
                def passedTestsByClass = [:]
                def failedTestsByClass = [:]
                def skippedTestsByClass = [:]

                def testResults = []

                // Parse test result file
                def reportPath = "${env.WORKSPACE}/${testResultsFile}"
                if (fileExists(reportPath)) {
                    def fileContent = readFile(file: reportPath)
                    def lines = fileContent.trim().split('\n')

                    lines.each { line ->
                        if (line.startsWith('Total Tests:')) {
                            totalTests = line.split(':')[1].trim().toInteger()
                        } else if (line.startsWith('Passed Tests:')) {
                            passedTests = line.split(':')[1].trim().toInteger()
                        } else if (line.startsWith('Failed Tests:')) {
                            failedTests = line.split(':')[1].trim().toInteger()
                        } else if (line.startsWith('Skipped Tests:')) {
                            skippedTests = line.split(':')[1].trim().toInteger()
                        } else if (line.startsWith('Passed Tests in')) {
                            def className = line.split(':')[0].substring(line.indexOf('in ') + 3).trim()
                            def passedCount = line.split(':')[1].trim().toInteger()
                            passedTestsByClass[className] = passedCount
                        } else if (line.startsWith('Failed Tests in')) {
                            def className = line.split(':')[0].substring(line.indexOf('in ') + 3).trim()
                            def failedCount = line.split(':')[1].trim().toInteger()
                            failedTestsByClass[className] = failedCount
                        } else if (line.startsWith('Skipped Tests in')) {
                            def className = line.split(':')[0].substring(line.indexOf('in ') + 3).trim()
                            def skippedCount = line.split(':')[1].trim().toInteger()
                            skippedTestsByClass[className] = skippedCount
                        } else {
                            def parts = line.split(' - ')
                            def className = parts[0]
                            def testName = parts[1]
                            def description = parts[2]
                            def status = parts[3]
                            testResults.add([className: className, testName: testName, description: description, status: status])
                        }
                    }
                }

                // Generate and send Slack notification
                def buildStatus = failedTests > 0 ? 'FAILURE' : 'SUCCESSFUL'
                notifyBuild(buildStatus, totalTests, passedTests, failedTests, skippedTests, passedTestsByClass, failedTestsByClass, skippedTestsByClass, testResults)
            }
        }
    }
}

def notifyBuild(String buildStatus, int totalTests, int passedTests, int failedTests, int skippedTests, Map<String, Integer> passedTestsByClass, Map<String, Integer> failedTestsByClass, Map<String, Integer> skippedTestsByClass, List<Map<String, String>> testResults) {
    // Build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESSFUL'

    // Define color and color code based on build status
    def colorName = buildStatus == 'FAILURE' ? 'RED' : 'GREEN'
    def colorCode = buildStatus == 'FAILURE' ? '#FF0000' : '#00FF00'

    // Get current timestamp
    def now = new Date()
    def timeDate = now.format("YYYY-MM-DD HH:mm:ss.Ms")

    // Generate report content
    def reportContent = """
        Total Tests: ${totalTests}
        Passed Tests: ${passedTests}
        Failed Tests: ${failedTests}
        Skipped Tests: ${skippedTests}

        Passed Tests by Class:
        ${passedTestsByClass.collect { className, count -> "${className}: ${count}" }.join('\n')}

        Failed Tests by Class:
        ${failedTestsByClass.collect { className, count -> "${className}: ${count}" }.join('\n')}

        Skipped Tests by Class:
        ${skippedTestsByClass.collect { className, count -> "${className}: ${count}" }.join('\n')}

        Test Results:
        ${testResults.collect { result -> "${result['className']} - ${result['testName']} - ${result['description']} - ${result['status']}" }.join('\n')}
    """

    // Save report content to file
    writeFile file: testResultsFile, text: reportContent

    // Generate Slack message details
    def reportName = "Allure Reports Link"
    def reportUrl = "https://a8d2-27-72-144-248.ngrok-free.app/index.html"

    def buildStatusText = buildStatus == 'FAILURE' ? 'FAILURE' : 'SUCCESSFUL'

    def msgDetails = """${buildStatusText}: Job '${env.JOB_NAME}' [${env.BUILD_NUMBER}]
    Job Name : ${env.JOB_NAME}
    Build : ${env.BUILD_NUMBER}
    Time run : ${timeDate}
    Total Tests: ${totalTests}
    Passed Tests: ${passedTests}
    Failed Tests: ${failedTests}
    Skipped Tests: ${skippedTests}

    Allure Reports : <${reportUrl}|${reportName}>
    """

    // Send Slack message with attachment
    slackSend(color: colorCode, message: msgDetails, attachments: [
        [
            title: 'Test Results',
            color: colorName,
            text: reportContent,
            fallback: 'Test Results',
            mrkdwn_in: ['text']
        ],
        [
            title: 'Test Results File',
            color: colorName,
            text: 'See attached test results file.',
            fallback: 'Test Results File',
            actions: [
                [
                    type: 'button',
                    text: 'Download',
                    url: "${env.WORKSPACE}/${testResultsFile}"
                ]
            ]
        ]
    ])
}
