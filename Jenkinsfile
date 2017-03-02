#!/usr/bin/env groovy
@Library('jenkins2-pipeline-library')
import vanvendeloo.jenkins.*


node {
   def mvnHome


   stage('Checkout') {
      git 'https://github.com/mikevanvendeloo/collectionizer.git'
      def commitId = getCommitId()
      echo "commitId: ${commitId}"
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
