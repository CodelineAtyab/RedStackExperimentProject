Plan of Distance Finder : 

Which host is the client, which is the server?
My Java program >> Clint 
Google Maps API>>> Server 

What does your program need to send, and what does it expect back?
The program need to send resource,destination, the Api and the travel information and receive
the JSON response(distance and travel duration).


The steps you will follow to get from nothing to a printed distance.
1. create the Maven project and add the Unirest dependency(library from Google https://mvnrepository.com/artifact/com.konghq/unirest-java/3.14.5 ).
2. then set a resource and destination
3. send request to Google Maps Api>>>> by using Unirest dependency.
4. read the JOSN file 
5. take out the distance, then print it in kilometres.
.............................................................................................................




