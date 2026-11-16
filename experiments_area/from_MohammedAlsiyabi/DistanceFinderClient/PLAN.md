# PLAN

## Client and server
- Client: my Java program on my MacBook.
- Server: OSRM (gives the distance) and Nominatim (turns a place name into coordinates).
- I do not start any server.

## What I send and what comes back
- I send a place name to Nominatim and get back latitude and longitude.
- I send both coordinates to OSRM and get back the distance in metres.
- I print the distance in km.

## Steps
1. Read the documentation and test the URLs in the browser.
2. Create the Maven project with Java 17 and add Unirest.
3. Send the request and print the response.
4. Pick out the distance and print it in km.
5. Print a clear message if there is an error.

## What I need for the request
- Nominatim URL, the place name (`q`), `format=json` and a `User-Agent` header (found in the Nominatim docs).
- OSRM URL with `driving` and the coordinates, longitude first then latitude (found in the OSRM docs).
- No API key needed.

## Google Maps
The ticket asks for Google Maps with live traffic. It needs a Google Cloud account, billing and an API key. I did not get a working key (`REQUEST_DENIED`), so I used OSRM, which has no live traffic.