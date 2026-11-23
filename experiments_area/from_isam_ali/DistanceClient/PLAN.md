# Plan

## Client and server
The client is my Java program, running on my computer. The server is TomTom's
API (api.tomtom.com), running on TomTom's computers. My program sends requests
and TomTom sends back responses. I do not start any server of my own.
(I first planned to use Google Maps, but Google required payment info, so my
instructor allowed TomTom instead. See BLOCKERS.md.)

## What I send and what I get back
TomTom's routing needs coordinates, so I make two kinds of requests:
1. Geocoding: I send a place name (for example "Muscat") and get back JSON
   with its latitude and longitude.
2. Routing: I send the two coordinate pairs, driving mode and traffic=true.
   I get back JSON with the route summary, where lengthInMeters is the distance.
   I convert meters to kilometers and print the result.

## Steps
1. Read the TomTom docs and the Unirest docs.
2. Create a TomTom account and an API key (Geocoding, Search and Routing enabled).
3. Create the Maven project with Java 17 and add the Unirest dependency.
4. Send the geocoding request for the source and the destination.
5. Send the routing request with traffic=true.
6. Read lengthInMeters from the JSON and divide by 1000.
7. Print: Distance from <source> to <destination>: <number> km
8. Print a clear message if there is an error or no result.
9. Keep the API key out of the code (environment variable or .env, which is in .gitignore).

## What I need to make the request
| Item | What it is | Where I found it |
|---|---|---|
| Geocoding URL | GET https://api.tomtom.com/search/2/geocode/{query}.json turns a place name into coordinates | TomTom Geocoding / Search API docs |
| Routing URL | GET https://api.tomtom.com/routing/1/calculateRoute/{lat,lon:lat,lon}/json calculates the route | TomTom Routing API docs, Calculate Route |
| API key | Secret code that tells TomTom who is asking, sent as the key parameter | TomTom developer dashboard, Keys |
| Enabled APIs | The key must have the Geocoding, Search and Routing APIs ticked | TomTom developer dashboard, when creating the key |
| Origin and destination | Coordinates as lat,lon, separated by a colon in the URL | Routing docs, Calculate Route |
| Live traffic | traffic=true makes the route and time use current traffic | Routing docs, Calculate Route parameters |
| Travel mode | travelMode=car for driving | Routing docs, Calculate Route parameters |
| Country filter | countrySet=OM keeps geocoding results in Oman | Geocoding docs, request parameters |
| Unirest dependency | com.konghq:unirest-java:3.14.5 in pom.xml | Unirest docs / Maven Central |