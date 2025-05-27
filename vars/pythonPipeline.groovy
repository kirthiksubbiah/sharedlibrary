def call() {
    pipeline {
        agent any
        stages {
            stage('Run Python Script') {
                steps {
                    sh 'python3 main.py'
                }
            }
        }
    }
}
