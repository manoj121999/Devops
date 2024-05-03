pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'cd $WORKSPACE'
                sh 'pwd' 
                echo 'Building..'
                sh 'sudo docker build -t testimage .'
            }
        }
        stage('Pushing to ECR') {
            steps {
                sh 'sudo docker tag testimage:latest manoj8795/app:jenkins'
                sh 'sudo docker push manoj8795/app:jenkins'
            }
        }
       stage('Deploy deployment and service file') {
            steps {
                script {
                    kubernetesDeploy configs: 'webapp.yaml', kubeconfigId: 'kubernetes'
                }
            }
        }
    }
}
