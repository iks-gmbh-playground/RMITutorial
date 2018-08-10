# Simple RMI example #

The clients sends a string to the server which takes that string, adds some other strings and returns the result. 

The interesting part is the RMI stuff in the server and client classes. Also the envocation of the classes is worth  to consider. Although this example runs locally it must be expected to invest some time to distribute the client and the server over the network. 
To run the example on Windows 

- open three cmd console windows (in PowerShell I had some problems which let me go back to cmd) and change the dirctory to projects base folder
- in the first start the RMI registry: `startRegistry.cmd`
- in the second console window start the server: `startServer.cmd`
- then in the third console window run the client: `startClient.cmd`