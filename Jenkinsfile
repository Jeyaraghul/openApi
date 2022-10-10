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
  openshift.startBuild("openApi",
  "--from-file=target/OpenAPI-0.0.1-SNAPSHOT.jar",
  "--wait")
    
        }
      }
    }}}
    stage('Deploy') {
      steps {
        echo 'Deploying....'
        script {

          openshift.withCluster() { 
  openshift.withProject("demo-learn") { 
    def result, dc = openshift.selector("dc", "openApi") 
    
    dc.rollout().latest()
    timeout(10){
        result = dc.rollout().status("-w")
    }
    if (result.status != 0){
        error(result.err)
    }


        }
      }
    }
  }}}}


