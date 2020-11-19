node {
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: params.docker_id, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
			usr = USERNAME
			pswd = PASSWORD
		}
		docker.withRegistry("", params.docker_id) {
			sh "docker login -u ${usr} -p ${pswd}"
			def	image = docker.build("shantanu777/footballappjenkins")
			image.push 'latest'
		}
}