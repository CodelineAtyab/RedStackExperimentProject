
What is a Bean?
A bean is an object created and managed by the Spring Framework inside the application context.

 HTTP Methods

- GET: Retrieves feedback from the server.
- POST: Creates new feedback.
- PUT: Updates existing feedback.
- DELETE: Removes feedback.
- QUERY: Sends search conditions in the request body to retrieve matching data.

Missing ID behaviour: Return 404 Not Found when the feedback ID does not exist.

Postman

Tested all four endpoints successfully:
- POST: Added two feedback entries.
- GET: Retrieved both entries.
- PUT: Updated the first feedback message.
- GET: Confirmed the updated message.
- DELETE: Removed the first feedback.
- GET: Confirmed only one entry remained.

Unirest

Tested POST, GET, PUT and DELETE using my Java Unirest client.

Successfully received JSON responses from the server.

Tested with my partner in both directions.

Partner:
HaithamAlbusaidi
Haitham-Albusaidi


No blockers.
Harder than expected: Connecting to another computer using its IPv4 address.