pipeline {
	agent any

	tools {
		maven "3.9.9"
	}

    stages {
		stage('Checkout') {
			steps {
				git branch: 'main', url: 'https://github.com/AnyaFesun/GlobalLodgic_lab4.git'
            }
        }
        stage('Build') {
			steps {
				script {
					sh 'mvn clean install -DskipTests'
                }
            }
        }
        stage('Test') {
			steps {
				script {
					sh 'mvn test'
                }
            }
        }
    }
}