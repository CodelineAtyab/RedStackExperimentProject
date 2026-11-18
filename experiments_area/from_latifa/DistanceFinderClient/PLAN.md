##Which host is the client, which is the server

    Client: My Java application. 
    It sends a request to Google Maps to get the distance between two places.

    Server: Google Maps API. 
    It receives the request and sends back the distance and travel information.

##What does your program need to send, and what does it expect back?
    Program Send:
        Source: The starting place (example: Muscat).
        Destination: The ending place (example: Sohar).
        Travel mode: Driving.
        Departure time: Now, to consider live traffic.
        API key: To access Google Maps API.

    Program Receive:
        The distance between the two places (JSON response).
        Distance in metres.
        Travel duration.

##The steps you will follow to get from nothing to a printed distance.

    1/Get the API Key: Atyab gave me a Google Maps API key. I need this key to allow my Java application to access Google Maps and send requests to the Routes API.
    2/Choose Locations: I selected Muscat as the starting point and Sohar as the destination.
    3/Choose Travel Mode: I used DRIVE because I want to calculate the distance by car.
    4/Use Live Traffic: I used TRAFFIC_AWARE and the current departure time to consider traffic conditions.
    5/Prepare the Request: I created a JSON body containing the source, destination, travel mode, and departure time.
    6/Send the Request: I used Unirest to send a POST request to Google Maps.
    7/Add Headers: I added the API key to authorize my request and the other headers needed by the API.
    8/Get the Response: Google Maps sends back the route information in JSON format.
    9/Get the Distance: I extracted the distance in metres from the response.
    10/Convert the Distance: I divided the distance by 1000 to get kilometres.
    11/Print the Result: I printed the distance between Muscat and Sohar.