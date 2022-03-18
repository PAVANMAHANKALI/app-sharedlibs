def call(ip,user,credId){
  sshagent([credId]) {
    
      sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/apache-tomcat-9.0.60/webapps/azure.war"
      sh "ssh ${user}@${ip} /opt/apache-tomcat-9.0.60/bin/shutdown.sh"
      sh "ssh ${user}@${ip} /opt/apache-tomcat-9.0.60/bin/startup.sh"
    
   }
}
