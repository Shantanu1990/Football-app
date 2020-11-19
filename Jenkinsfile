node {
    docker.withRegistry('https://hub.docker.com/repository/docker/shantanu777/footballappjenkins', 'docker_id') {
    
        git url: "https://github.com/Shantanu1990/Football-app.git", credentialsId: 'git_credentials'
    
        sh "git rev-parse HEAD > .git/commit-id"
        def commit_id = readFile('.git/commit-id').trim()
        println commit_id
    
        stage "build"
        def app = docker.build "your-project-name"
    
        stage "publish"
        app.push 'master'
        app.push "${commit_id}"
    }
}