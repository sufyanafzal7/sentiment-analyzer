pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/<your-username>/sentiment-analyzer.git'
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
    }
}
