# Simple RMI example #

The clients sends a string to the server which takes that string, adds some other strings and returns the result. 

The interesting part is the RMI stuff in the server and client classes. Also the invocation of the classes in the cmd files is worth to consider. Although this example runs locally it must be expected to invest some time to distribute the client and the server over the network. 
To run the example on Windows 

- open three cmd console windows (in PowerShell I had some problems which let me go back to cmd) and change the directory to projects base folder
- in the first start the RMI registry: `startRegistry.cmd`
- in the second console window start the server: `startServer.cmd`
- then in the third console window run the client: `startClient.cmd`

## Further insights ##

- the security manager policy file and code bases are only needed if there are objects sent over the net of which the receiver only knows the implemented interfaces (see the Oracle tutorial: https://docs.oracle.com/javase/tutorial/rmi/index.html)