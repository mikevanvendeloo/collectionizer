#!/usr/bin/env groovy
@Library('jenkins2-pipeline-library@master')

node {
   def mvnHome
   stage('Preparation') { // for display purposes
      git 'https://github.com/mikevanvendeloo/collectionizer.git'
      echo getCommitId()
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" clean package/)
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}