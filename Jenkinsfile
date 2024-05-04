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
        script {
          kubernetesDeploy configs: 'webapp.yaml', kubeconfigId: 'k8s-con', serverUrl: 'https://17.2.1.202:6443'

        }
      }
    }
    }
}
