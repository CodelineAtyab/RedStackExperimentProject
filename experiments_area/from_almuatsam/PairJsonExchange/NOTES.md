# Pair JSON Exchange

## Partner
- GitHub username: Ay320
- GitHub profile: https://github.com/Ay320


## Round 1
- Partner: Ay320
- Initial test: Failed
- Date: 17 November 2026
- Error: JSONObject["favourites"] not found.
- Cause: The response did not contain the expected favourites array.


## Round 2
- Partner: Ay320
- Status: Successful
- Date: 18 November 2026
- Connected to Ay320's ProfileServer.
- Received and parsed the JSON response.
- Printed the profile name and all three favourites.
- Result: BUILD SUCCESS

## Part A - Spring Beans

- Bean name: profileController
- Result: Successfully found the ProfileController bean in the Spring ApplicationContext.
- Bean explanation: A Spring bean is an object that Spring creates and manages inside the application context.
- Test: Printed all bean names and confirmed that ProfileController was found. 

## Part B - Feedback CRUD API

- POST /feedback: Created two feedback records successfully.
- GET /feedback: Retrieved both records successfully.
- PUT /feedback/1: Updated Sara's message successfully.
- DELETE /feedback/2: Deleted Ahmed's feedback successfully.
- Unknown ID behavior: Returns 404 Not Found.
- Successful DELETE response: 204 No Content.
- Postman testing: All CRUD requests passed.

## Part C - Unirest Client

- POST /feedback: Successfully created feedback using Unirest.
- GET /feedback: Successfully retrieved feedback as JSON.
- PUT /feedback/{id}: Successfully updated feedback.
- DELETE /feedback/{id}: Successfully deleted feedback.
- Final GET: Confirmed that the deleted record was absent.
- Result: BUILD SUCCESS.

## HTTP Method Explanations

- GET: Retrieves data from the server without changing it.
- POST: Sends data to the server to create a resource.
- PUT: Updates or replaces an existing resource.
- DELETE: Removes a resource from the server.
- QUERY: Sends query instructions in a request body to retrieve data without changing the target resource.



## Blockers
- No blockers currently.

## Something harder than expected
- Reading a JSON array and extracting each favourite object using a loop.