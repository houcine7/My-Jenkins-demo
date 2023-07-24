def changes_set=0;

pipeline{

    agent any

    stages{
         

        stage("build") {
           steps{
            changes_set = currentBuild.changeSets.size()
           }
        }

        stage("build") {

            // RUN THE BUILD ONLY IF THERE ARE NEW CHANGES 

            when {
                expression {
                    changes_set>0
                }
            }

           steps{
             echo 'BUILDING TEH APP'
           }
        }

        stage("test") {
            
            // To run this when only a condition is verified 
            when{
                // the tests when be checked only for dev branch no other branches 
                expression{
                    env.BRANCH_NAME==dev || env.BRANCH_NAME=main
                }
            }
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