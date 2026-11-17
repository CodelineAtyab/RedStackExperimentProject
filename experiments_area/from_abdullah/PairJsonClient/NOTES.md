# Client notes - #522

ProfileClient uses Unirest to request /profile with a name query parameter.
It reads the JSON object, gets the favourites array and loops through it.
The server address can be changed using the first command-line argument.

See ../PairJsonServer/NOTES.md for partner status and blockers.
See ../PairJsonServer/TEST_RESULTS.md for local results.
