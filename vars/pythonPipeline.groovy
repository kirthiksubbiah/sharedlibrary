def call(Map config = [:]) {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    git url: config.repoUrl
                }
            }

            stage('Install Dependencies') {
                steps {
                    sh 'pip install -r requirements.txt'
                }
            }

            stage('Run Tests') {
                steps {
                    sh 'python -m unittest test_app.py'
                }
            }
        }
    }
}
