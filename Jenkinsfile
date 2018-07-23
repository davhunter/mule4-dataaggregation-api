pipeline {
	agent any
	stages {
		stage('Build') {
			environment {
				ANYPOINT_CREDENTIALS = credentials("${ENV}.cloudhub.credentials")
				CH_CLIENT_ID = credentials("${ENV}.cloudhub.client.id")
				CH_CLIENT_SECRET = credentials("${ENV}.cloudhub.client.secret")
				AUTODISC_APIID = credentials("${ENV}.daapi.audodisc")
			}
			steps {
				sh 'mvn clean package deploy -DmuleDeploy -Dusername=${ANYPOINT_CREDENTIALS_USR} -Dpassword=${ANYPOINT_CREDENTIALS_PSW} -Dhttp.port=8084 -Dch-client-id=$CH_CLIENT_ID -Dch-client-secret=$CH_CLIENT_SECRET -Dapi.id=$AUTODISC_APIID'
			}
		}
	}
}