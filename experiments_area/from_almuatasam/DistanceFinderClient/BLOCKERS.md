# Blockers

No major blockers remain.

One challenge was understanding how to integrate an external routing API using Unirest and process its JSON response.

I initially explored Nominatim and OSRM, but switched to Google Maps Routes API after receiving an API key from my instructor.

The Google Maps Routes API uses a POST request with a JSON request body. It requires an API key in the `X-Goog-Api-Key` header and a field mask to specify the response fields.

I also learned how to:

- Store an API key in an environment variable.
- Send HTTP POST requests using Unirest.
- Parse JSON responses.
- Extract route distance and duration.
- Convert metres into kilometres.
- Handle unsuccessful API responses.

The application now successfully calculates driving distance using the `TRAFFIC_AWARE` routing preference.