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
                sh 'sudo docker tag testimage public.ecr.aws/m4p7d9s0/test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
