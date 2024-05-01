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
                sh 'sudo docker tag testimage:latest public.ecr.aws/s2v4m4w7/capstone-sgpa:v1'
                sh 'sudo docker push public.ecr.aws/s2v4m4w7/capstone-sgpa:v1'
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
