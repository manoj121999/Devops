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

        stage('Code Analysis') {
            environment {
                scannerHome = tool 'sonarqube'
            }
            steps {
                script {
                    withSonarQubeEnv('sonarqube') {
                        sh "${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=capstone \
                            -Dsonar.projectName=capstone \
                            -Dsonar.sources=."
                    }
                }
            }
        }
        stage('Pushing to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "sudo docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                sh 'sudo docker tag testimage:latest manoj8795/app:jenkins'
                sh 'sudo docker push manoj8795/app:jenkins'
            }
        }
        }
       stage('Deploying App to Kubernetes') {
      steps {
        sshagent(['k8s-cluster']) {
            sh 'cd $WORKSPACE'
    sh "scp -o StrictHostKeyChecking=no webapp.yaml ubuntu@17.2.1.217:/home/ubuntu/"
            script {
                try{
                    sh 'ssh ubuntu@17.2.1.217 kubectl rollout restart deployment capstone-spga'
                
                }catch(error) {
                    sh "ssh ubuntu@17.2.1.217 kubectl apply -f /home/ubuntu/webapp.yaml"
                }
            }
}
      }
    }
    }
}
