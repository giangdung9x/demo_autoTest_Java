node('built-in') {
     stage ('Build and test') {
        git 'https://danggiangmf@bitbucket.org/mobilefolkteam/showslinger-automation-tests.git'
        withMaven(globalMavenSettingsConfig: '', jdk: 'Jdk', maven: 'maven', mavenSettingsConfig: '', mavenSettingsFilePath: 'pom.xml', traceability: true) {
           // some block
           sh 'mvn clean install'
       }
    }
}
