node {​​​​
        docker.withRegistry('', 'docker_id') {
		
        git url: "https://github.com/Shantanu1990/Football-app.git", credentialsId: 'git_credentials'
    
        sh "git rev-parse HEAD > .git/commit-id"
        def commit_id = readFile('.git/commit-id').trim()
        println commit_id
    
        stage "build"
        def app = docker.build "shantanu777/footballappjenkins"

        app.push("${env.BUILD_NUMBER}")
        app.push "latest"
		}
}​​​​