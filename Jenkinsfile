def gv

pipeline{

    agent any


    stages{
        stage("INIT"){
            steps {
                script{
                    gv= load "script.groovy"
                }
            }
        }
        // stage("chek_changes") {
        //   steps{
        //     script {
        //         gv.checkChanges()    
        //     }

        //   }
        // }
        stage("build") {
             // RUN THE BUILD ONLY IF THERE ARE NEW CHANGES 
           steps{
            sh 'ls'
            dir('app') {
                sh "ls"  
                sh "docker build . -t my-node-app:test"
            }
            sh 'pwd'
               
            script{
                gv.build()
            }
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
