
pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                dir('D:\\System Software\\Eclipse-workspace\\Calculator') {
                    bat 'mvn clean verify'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                dir('D:\\System Software\\Eclipse-workspace\\Calculator') {
                    withSonarQubeEnv('LocalSonarQube') {
                        bat '''
                            mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar ^
                            -Dsonar.projectKey=Calculator
                        '''
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate(
                        abortPipeline: true
                    )
                }
            }
        }
    }
}
