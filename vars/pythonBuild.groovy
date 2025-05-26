def call(String testCommand = 'pytest') {
    try {
        echo "🐍 Running Python tests with: ${testCommand}"
        sh "${testCommand} --junitxml=reports/results.xml"
        junit 'reports/results.xml'   // Publish test report in Jenkins
        echo "✅ Python tests passed!"
    } catch (err) {
        echo "❌ Python tests failed: ${err.getMessage()}"
        currentBuild.result = 'FAILURE'
        throw err
    }
}
