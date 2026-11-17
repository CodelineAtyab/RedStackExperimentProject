# Client notes

See ../PairJsonServer/NOTES.md for bean and HTTP explanations, partner status and blockers.
See ../PairJsonServer/TEST_RESULTS.md for local verification.

ProfileClient reads the name and favourites array from JSON and prints each item.
FeedbackClient sends JSON text with Content-Type: application/json and reads the replies as JSON.
Both clients accept the server address as their first command-line argument.
