rem The following environment variables are only needed when the clients receives objects of which it only knows the interfaces. 
rem -Djava.rmi.server.useCodebaseOnly=false 
rem -Djava.rmi.server.codebase=file:C:\Learning\Dojos\DojoWorkspace\RMITutorial\bin\ 

java -cp .\bin -Djava.security.policy=.\client.policy com.iks.rmiTutorial.client.RMIApplication %1 %2 %3