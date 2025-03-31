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
					// Компіляція  проекту
					bat  'mvn install'
                }
            }
        }
        stage('Test') {
			steps {
				script {
					// Запуск тестів
					bat 'mvn test'
                }
            }
            post {
				always {
					// Збір результатів тестів у форматі JUnit
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
}