

pipeline{

    agent any

    stages{
        stage("chek_changes") {
           steps{
            
            script {
                    // Get the current change sets
                    def changeSets = currentBuild.changeSets
                    // Check if there are any changes
                    if (changeSets != null && !changeSets.isEmpty()) {
                        echo "Changes detected. Running the build stage..."
                    } else {
                        echo "No changes. Skipping the build stage."
                        currentBuild.result = 'SUCCESS' // Mark the build as successful
                        return
                    }
            }

           }
        }

        stage("build") {

            // RUN THE BUILD ONLY IF THERE ARE NEW CHANGES 
           steps{
             echo 'BUILDING TEH APP'
           }
        }

        stage("test") {
            
            // To run this when only a condition is verified 
            when{
                // the tests when be checked only for dev branch no other branches 
                expression{
                    env.BRANCH_NAME=='dev' || env.BRANCH_NAME=='main'
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
