pipeline{
    agent any
    
    stages{
        
        stage('Checkout'){
            steps{
                checkout([
                    $class:'GitSCM',
                    branches:[[name: '*/master']],
                    userRemoteConfigs:[[
                            url:'https://github.com/dhruvshingari/TestingWithCucumber.git'
                        ]]
                    
                    ]
                )
            }
        }
        
         stage('Code clean'){
            steps{
                bat "mvn clean"
            }
        }
        
         stage('Code Compile'){
            steps{
                bat "mvn compile"
            }
        }
        
         stage('Test'){
            steps{
                bat "mvn test"
            }
        }
        
    }
    
}
