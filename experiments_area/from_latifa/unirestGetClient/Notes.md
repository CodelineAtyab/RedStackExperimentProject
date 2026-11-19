Partner name: Wafa

I created two Maven projects using Java 17:
Server -> Spring Boot application that returns a JSON response through the /profile GET endpoint.
Client: Java application using Unirest to send a GET request and read the JSON response using Gson.

Round 1 – Wafa's Server and My Client
Round 2 – My Server and Wafa's Client

##Blockers
I faced a connection problem when trying to connect to the server from another computer. 
The request timed out.
I checked the network connection and Windows Firewall settings because the firewall could block incoming connections.