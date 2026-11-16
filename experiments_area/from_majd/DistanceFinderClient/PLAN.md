CLIENT -> A computer that sends a request to server.
SERVER -> A computer that waits for a request from a client. Process the request and sends back a response

The program is expected to send an SOURCE city or Governorate and A DESTINATION city or Governorate. The program expects a retuurn data that is supposed to be the distance between the Source and destination cities or Governorates

Api key
https://maps.googleapis.com/maps/api/distancematrix/json
?origins=Muscat
&destinations=Sohar
&mode=driving
&departure_time=now
&key=YOUR_API_KEY

?origins=The Start

&destinations= The endpoint

&mode="driving", Makes calculations based on the roads.

&departure_time=now, checks the status for traffics on roads, gives exact conditions.