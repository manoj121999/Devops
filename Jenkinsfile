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
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh '''
                chmod +x deploy.sh
                bash $WORKSPACE/deploy.sh
                '''
              

            }
        }
    }
}
