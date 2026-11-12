
pipeline {
    agent any

    stages {
        stage('Clean and Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('LocalSonarQube') {
                    bat '''
                        mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar ^
                        -Dsonar.projectKey=Laptop
                    '''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate(abortPipeline: true)
                }
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }
    }
}
