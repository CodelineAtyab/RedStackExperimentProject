# Blockers

## Maven command not found (resolved)

Tried: mvn -version and mvn clean test-compile.
Exact error: The term 'mvn' is not recognized as the name of a cmdlet.
Cause: Maven was downloaded but not on the command Path.
Resolution: Extracted Maven 3.10.1 into the user Tools folder and added bin to user Path. Added run.cmd to work from terminals with an old Path and to run with dependencies.

## Google API key missing (original approach blocked)

Original command: mvn -B -ntp exec:java.
Exact output: Missing API key. Set GOOGLE_MAPS_API_KEY first.
No Google request or Google distance was verified.

On 16 November 2026 the user requested a version without an API key. Switched the client to OSRM's public demo routing API. Removed the Google key requirement from the program.

This solves the local no-key use case, but the original Google Maps and live-traffic requirements remain unmet. The alternative also uses fixed coordinates rather than resolving plain-text city names. These differences must be disclosed if submitted for issue #503.

## Current OSRM version

No runtime blocker in the verified run.
mvn clean test-compile: BUILD SUCCESS with Java 17.
run.cmd: completed with exit code 0.
Observed real output: Distance from Muscat to Sohar: 210.47 km.

Harder than expected: changing the provider also required changing the request from a JSON POST to a GET with coordinates, and reading distance instead of distanceMeters.

The public service may be unavailable or rate-limit requests. Live traffic is not provided by this example.
