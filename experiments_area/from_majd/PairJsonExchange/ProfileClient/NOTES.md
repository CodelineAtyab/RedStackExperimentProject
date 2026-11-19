Pair JSON Exchange – NOTES

Partner
GitHub username: @ShuiabALBulushi

Round 1
Partner B started their Spring Boot server.
I ran my Unirest client against Partner B's server.
Result: Successfully connected, received the JSON response, extracted the name and favourites array, and printed each favourite's ID and title.
Round 2

I started my Spring Boot server.
Partner B ran their Unirest client against my server.
Result: Successfully connected, received the JSON response, and printed the name and favourites correctly.
Blockers
No blockers.
Something harder than expected
Extracting the JSON array of favourites and looping through the JSON objects was harder than expected at first. Understanding how to use JSONArray and JSONObject helped me solve it. The imports where unknown at first, with little understanding, I was able to import the required libraries