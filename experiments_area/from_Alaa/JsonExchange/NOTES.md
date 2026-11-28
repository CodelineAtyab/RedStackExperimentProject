# Notes

## Part 2 (Feedback CRUD API, Part 2 of #522)

### 1. Partner
- I worked on this part alone

### 2. Spring bean
- What a bean is: a bean is a Java object that Spring creates and manages instead of me calling `new`. The application context is the container that holds all beans, both Spring's own and the ones from my classes. A class becomes a bean when it has an annotation like `@RestController` and sits in a package under the `@SpringBootApplication` class, which is why `profileController` appeared in the list.
- Bean name found in the context: profileController
- FeedbackController bean name: feedbackController
- Console output of the bean listing is in the `Results` folder.

### 3. HTTP methods
- GET: reads data without changing anything and normally has no body.
- POST: creates a new item from the body and normally returns 201.
- PUT: replaces or updates an existing item, with the id in the URL and the new data in the body.
- DELETE: removes the item with the id in the URL.
- QUERY: reads data like GET and changes nothing, but it can carry a body, which is useful for long search filters. I did not try the optional QUERY stretch.

### 4. Design choices
- JSON keys: `id`, `name`, `message`.
- POST body: `name` and `message`. The server adds `id`.
- PUT body: `message` only.
- POST returns 201. GET and PUT return 200. DELETE returns 200 with `{"message":"deleted"}`.
- Unknown id on PUT or DELETE returns 404 with `{"error":"not found"}`.
- Known gap: PUT returns a 500 error if the body has no `message` key. The ticket does not require validation.

### 5. Testing
- Cross-test with a partner: not done. I worked on this part at home, so I could not check that my client works against another server with the same paths and keys (`id`, `name`, `message`).
- Postman: all four endpoints tested in the Part C order. Screenshots are in the `Results` folder.
- Unirest, my client against my own server: all four requests worked (POST, GET, PUT, DELETE). The responses were read as JSON and the results matched the Part C order from Postman.

  Console output:

  ```
  Raw: {"name":"Alaa","id":1,"message":"Great service"}
  Created: 1 - Alaa - Great service
  Created: 2 - Noor - not bad
  All feedback: 2 items
  1 - Alaa - Great service
  2 - Noor - not bad
  Updated: 1 - Alaa - Great service, thank you
  All feedback after update: 2 items
  1 - Alaa - Great service, thank you
  2 - Noor - not bad
  Deleted: deleted
  All feedback at the end: 1 item
  1 - Alaa - Great service, thank you
  ```

- Cross-test with a partner: not done. I was working in it at home, I could not check that my client works against another server with the same paths and keys (`id`, `name`, `message`).

### 6. Blockers
- Postman to `http://192.168.100.22:8080/feedback` failed with `Error: Request timed out`. I replaced the IP with "localhost" and it worked.


---

## Part 1 (Pair JSON Exchange, #522)

### Partner
- My name: Alaa
- Partner's name: Reham

### Testing
Round 1: My server and Reham's client
- Result: Successful

Output from Reham's client:

    Name: alaa
    1 - Coffee
    2 - Books
    3 - Football

Her client connected to my Spring Boot server, received the JSON response, and printed the name and favourite items in the expected format.

Round 2: Reham's server and my client
- Result: Successful. The output matches the goal output.

### Additional learning notes
At first I built the JSON objects by hand inside my controller. I later learned that Spring Boot converts Java objects into JSON automatically when a controller returns them, so building the JSON by hand is not needed.

### Blockers
No blockers.

### What was harder than expected
Understanding how Spring Boot handles JSON serialization. I first thought I had to build the response by hand.