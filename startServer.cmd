rem The following environment variables are only needed when the server receives objects of which it only knows the interfaces. 
rem -Djava.rmi.server.useCodebaseOnly=false 
rem -Djava.rmi.server.codebase=file:C:\Learning\Dojos\DojoWorkspace\RMITutorial\bin\ 
rem -Djava.security.policy=.\server.policy

java -cp .\bin com.iks.rmiTutorial.server.GreetServer