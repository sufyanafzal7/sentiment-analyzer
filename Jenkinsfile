pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/sufyanafzal7/sentiment-analyzer.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t sentiment-analyzer .'
            }
        }
        stage('Run Container') {
            steps {
                sh 'docker run -d -p 7061:7061 sentiment-analyzer'
            }
        }
        stage('Test') {
            steps {
                sh 'echo "happy day" | java Main'
            }
        }
    }
    post {
        success {
            script {
                // Get commit author email dynamically
                def commitAuthorEmail = sh(
                    script: "git log -1 --pretty=format:'%ae'",
                    returnStdout: true
                ).trim()
                emailext (
                    subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Pipeline succeeded for commit by ${commitAuthorEmail}.",
                    to: commitAuthorEmail
                )
            }
        }
        failure {
            script {
                def commitAuthorEmail = sh(
                    script: "git log -1 --pretty=format:'%ae'",
                    returnStdout: true
                ).trim()
                emailext (
                    subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Pipeline failed for commit by ${commitAuthorEmail}. Check Jenkins logs.",
                    to: commitAuthorEmail
                )
            }
        }
    }
}
