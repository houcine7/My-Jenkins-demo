pipeline{

    agent any

    stages{
        
        stage("build") {
           steps{
             echo 'BUILDING TEH APP'
           }
        }

        stage("test") {
           steps{
             echo 'TESTING TEH APP'
           }
        }

        stage("deploy") {
            steps{
                echo 'DEPLOYING TEH APP'
            }
        }
    }
    // THIS EXECUTES AFTER THE STAGES ARE FINISHED EXECUTING 
    post {
        // always executed after the stages
        always {
            echo 'The stages faild with a status: this is executed no matter what is the status'
        }

        success {
            echo 'If the build passed wothout errors execute this'
        }
        
        failure {
            echo 'IF the build failed execute this'
        }

    }
}