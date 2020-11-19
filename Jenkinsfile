node {
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: params.docker_id, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
			usr = USERNAME
			pswd = PASSWORD
		}
		docker.withRegistry("https://hub.docker.com/repository/docker/shantanu777/footballappjenkins", params.docker_id) {
			sh "docker login -u ${usr} -p ${pswd} https://hub.docker.com/repository/docker/shantanu777/footballappjenkins"
			def	image = docker.build("shantanu777/footballappjenkins")
			image.push 'latest'
		}
}