def gv

pipeline{

    agent any

    environment { 
        NAME = "mynodeapp"
        VERSION = "${env.BUILD_ID}-${env.GIT_COMMIT}"
        IMAGE = "${NAME}:${VERSION}"
    }
    
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
                sh 'docker build . -t ${IMAGE}'
            }
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
             echo 'TESTING TEH APP .......'
           }
        }

        stage("deploy") {
             when{
                //deploy the main branch 
                expression{
                    env.BRANCH_NAME=='main'
                }
            }
            steps{
                echo 'DEPLOYING TEH APP .....'
                 dir('app') {
                    sh 'docker run ${IMAGE} -p 3000:3000'
                }
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
