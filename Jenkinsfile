pipeline {
    agent any
    tools {
        maven 'Maven 3'
    }
    
    stages {
        stage ('Build') {
            steps {
                sh 'git submodule update --init --recursive'
                sh 'mvn clean package'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'plugins/**/target/*.jar', excludes: 'plugins/**/target/original-*.jar', fingerprint: true
                }
            }
        }
    }
}
