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
                sh 'sudo docker tag testimage:latest public.ecr.aws/m4p7d9s0/test:latest'
                sh 'sudo docker push public.ecr.aws/m4p7d9s0/test:latest'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh '''
               sudo aws ecs list-tasks --cluster DEMO --service-name Demo_app --desired-status RUNNING --output text |awk '{print $2}'
                sudo aws ecs stop-task --cluster DEMO --task $Task
                '''
            }
        }
    }
}
