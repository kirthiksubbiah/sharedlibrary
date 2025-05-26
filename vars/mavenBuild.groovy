// vars/mavenBuild.groovy
def call(String mvnGoal = 'clean install') {
    try {
        echo "🚀 Starting Maven Build with goal: ${mvnGoal}"
        sh "mvn ${mvnGoal}"
        echo "✅ Maven Build succeeded!"
    } catch (err) {
        echo "❌ Maven Build failed: ${err.getMessage()}"
        currentBuild.result = 'FAILURE'
        throw err
    }
}
