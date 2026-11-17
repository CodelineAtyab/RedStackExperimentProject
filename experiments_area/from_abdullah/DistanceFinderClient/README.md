# Distance Finder Client

Java 17 Maven practice project using Unirest to request a driving route from OSRM's public demo server. No account or API key is needed.

## Run in Windows PowerShell

From the repository root:

```powershell
cd ".\experiments_area\from_abdullah\DistanceFinderClient"
.\run.cmd
```

If already inside DistanceFinderClient, run only ` .\run.cmd `.

The launcher compiles and runs the project, using Maven from the installed user Tools folder or the command Path.

Alternatively, with Maven on Path:

```powershell
mvn clean test-compile
mvn -q exec:java
```

## Route and output

The example uses approximate fixed points in Muscat and Sohar.
Both the city label and coordinates must be changed together to choose another destination. There is no place-name lookup.

OSRM expects coordinates in longitude,latitude order and returns distance in metres. The program converts metres to kilometres.

Observed output on 16 November 2026:

```text
Distance from Muscat to Sohar: 210.47 km
Route: OSRM | Map data: OpenStreetMap contributors (ODbL)
https://www.openstreetmap.org/copyright
Driving distance between selected points; live traffic is not included.
```

The distance can change as the server's road data changes. It is a route between selected points, not a distance between city boundaries.

## Difference from issue #503

At the user's request, the implementation was changed from Google Routes to OSRM so it works without a Google account, billing or API key.

This version demonstrates the Java client, HTTPS requests, Unirest, JSON parsing and kilometre conversion. It DOES NOT satisfy the original issue's Google Maps, live-traffic or plain-text location lookup requirements. Trainer approval is needed to submit it as an alternative solution to that issue.

## Client and server

The Java application on my computer is the client.
router.project-osrm.org is the remote API host.
The program sends one request per run and does not start its own server.

## Verification

- Java 17: mvn clean test-compile passed.
- run.cmd completed successfully without an API key.
- A real remote request returned 210.47 km on 16 November 2026.
- Errors and absent routes print messages instead of an uncaught exception.

## Public service and attribution

This is a learning example, not a production routing service. The public demo has usage limits and no availability guarantee; avoid repeated or bulk requests.

Routes: OSRM.
Map data: OpenStreetMap contributors, ODbL.
https://www.openstreetmap.org/copyright

Documentation:
https://project-osrm.org/docs/v5.24.0/api/

Service policy:
https://github.com/Project-OSRM/osrm-backend/wiki/Api-usage-policy

Unirest:
https://kong.github.io/unirest-java/requests/
