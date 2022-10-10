#! /usr/bin/env groovy

pipeline {

  agent {
    label 'maven'
  }

  stages {
    stage('Build') {
      steps {
        echo 'Building..'
        
        sh 'mvn clean package'
      }
    }
    stage('Create Container Image') {
      steps {
        echo 'Create Container Image..'
        
        script {

          openshift.withCluster() { 
  openshift.withProject("demo-learn") {
  
    def buildConfigExists = openshift.selector("bc", "openApi").exists() 
    
    if(!buildConfigExists){ 
      openshift.newBuild("--name=openApi", "--docker-image=registry.redhat.io/jboss-eap-7/eap74-openjdk8-openshift-rhel7", "--binary") 
    } 
    openshift.selector("bc", "openApi").startBuild("--from-file=target/OpenAPI-0.0.1-SNAPSHOT.jar", "--follow")

        }
      }
    }}}
    stage('Deploy') {
      steps {
        echo 'Deploying....'
        script {

          openshift.withCluster() { 
  openshift.withProject("demo-learn") { 
    def deployment = openshift.selector("dc", "openApi") 
    
    if(!deployment.exists()){ 
      openshift.newApp('openApi', "--as-deployment-config").narrow('svc').expose() 
    } 
    
    timeout(5) { 
      openshift.selector("dc", "openApi").related('pods').untilEach(1) { 
        return (it.object().status.phase == "Running") 

        }
      }
    }
  }}}}
}
}

