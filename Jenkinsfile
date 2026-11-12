
pipeline {
    agent any

    stages {

        stage('Build') {
            steps {C:\Users\ssail\eclipse-workspace\Laptop
                dir('C:\\Users\\ssail\\Eclipse-workspace\\Laptop') {
                    bat 'mvn clean verify'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                dir('C:\\Users\\ssail\\Eclipse-workspace\\Laptop') {
                    withSonarQubeEnv('LocalSonarQube') {
                        bat '''
                            mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar ^
                            -Dsonar.projectKey=Laptop
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
