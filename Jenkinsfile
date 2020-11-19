node {
        withCredentials([usernamePassword( credentialsId: 'docker-hub-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            usr = USERNAME
            pswd = PASSWORD
        }
        docker.withRegistry('https://hub.docker.com/repository/docker/shantanu777/footballappjenkins', 'docker_id') {
            sh "docker login -u ${usr} -p ${pswd} https://hub.docker.com/repository/docker/shantanu777/footballappjenkins"
            git url: "https://github.com/Shantanu1990/Football-app.git", credentialsId: 'git_credentials'
    
        sh "git rev-parse HEAD > .git/commit-id"
        def commit_id = readFile('.git/commit-id').trim()
        println commit_id
    
        stage "build"
        def app = docker.build "your-project-name"

        app.push("${env.BUILD_NUMBER}")
        app.push "latest"
        }
}