def call(ip,user,credId){
  sshagent([credId]) {
    
      sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/tomcat/apache-tomcat-9.0.56/webapps/azure.war"
      sh "ssh ${user}@${ip} /opt/tomcat/apache-tomcat-9.0.56/bin/shutdown.sh"
      sh "ssh ${user}@${ip} /opt/tomcat/apache-tomcat-9.0.56/bin/startup.sh"
    
   }
}
