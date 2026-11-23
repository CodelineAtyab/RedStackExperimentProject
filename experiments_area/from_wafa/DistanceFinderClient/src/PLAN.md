
Client:Java program send the request.
Server:Google Maps Platform receives the request, calculates the route, and sends back the data.

Sent:An HTTP GET request with the source, destination, driving mode and API key.
Expected Back: a JSON response containing the status and the driving distance in meters.

#Steps
1.Check the Google Maps API docs and get an API key.
2.Test the full request URL in a web browser to see the JSON response.
3.Create a Java 17 Maven project and add Unirest and Gson to pom.xml.
4.Write Java code to read the API key safely and send the request using Unirest.
5.Extract the distance from the JSON response, convert it to km and print Distance.
6.catch error handling so the program doesn't crash.

#What I need from Google Maps document 
Google Cloud Account needed to turn on the Google Maps API
API Key secret use the API found in Google Cloud Credentials.
Endpoint URL https://maps.googleapis.com/maps/api/distancematrix/json API.
origins and destinations start and end places and calculate the distance by car.
Tells Google to check live traffic right now.