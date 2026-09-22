pipeline {
    agent any

    environment {
        PATH = "C:\\Users\\mycom\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin;${env.PATH}"
        IMAGE_NAME = "mahakantil10/hellodocker"
        IMAGE_TAG = "v1.0"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                        url: 'https://github.com/mahakantil/JavaProject1.git',

                    credentialsId: 'github_pipeline'
            }
        }

        stage('Compile') {
            steps {
                bat 'javac HelloDocker.java'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %IMAGE_NAME%:%IMAGE_TAG% ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'Docker_python', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    bat """
                        docker login -u %DOCKER_USER% -p %DOCKER_PASS%
                        docker push %IMAGE_NAME%:%IMAGE_TAG%
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully! Image pushed to Docker Hub.'
        }
        failure {
            echo 'Pipeline failed. Check console output for errors.'
        }
    }
}