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
       stage('Deploying App to Kubernetes') {
      steps {
        sshagent(['k8s-cluster']) {
            sh 'cd $WORKSPACE'
    sh "scp -o StrictHostKeyChecking=no webapp.yaml ubuntu@17.2.1.164:/home/ubuntu/"
            script {
                try{
                    sh 'ssh ubuntu@17.2.1.164 kubectl rollout restart deployment capstone-spga'
                
                }catch(error) {
                    sh "ssh ubuntu@17.2.1.164 kubectl apply -f /home/ubuntu/webapp.yaml"
                }
            }
}
      }
    }
    }
}
