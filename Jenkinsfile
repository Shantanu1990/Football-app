node {​​​​
       def DOCKER_REGISTRY_URI="https://hub.docker.com/repository/docker/shantanu777/footballappjenkins"
       withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker_id', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {​​​​
            usr = USERNAME
            pswd = PASSWORD
        sh "sudo docker login --password=${​​​​pswd}​​​​ --username=${​​​​usr}​​​​ ${​​​​DOCKER_REGISTRY_URI}​​​​"
        git url: "https://github.com/Shantanu1990/Football-app.git", credentialsId: 'git_credentials'

        sh "git rev-parse HEAD > .git/commit-id"
        def commit_id = readFile('.git/commit-id').trim()
        println commit_id

        stage "build"
        def app = docker.build "your-project-name"
 
        app.push("${​​​​env.BUILD_NUMBER}​​​​")
        app.push "latest"
     }​​​​
}​​​​