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


# Issue 645 Notes

## Part 1

### 1.1 Networking Basics
**Source:** GeeksforGeeks

- **IP address:** A numerical address used to identify a device on a network.
- **Private IP:** Used for communication within a local network (e.g., `192.168.x.x`).
- **Public IP:** Used to communicate over the internet. Public IPs can be static or dynamic.
- **Static vs dynamic:** A static IP stays the same, while a dynamic IP may change over time.
- **DHCP:** Automatically assigns IP addresses and network settings. The DHCP server assigns addresses, while the client requests them. My laptop is the client and my router usually acts as the server.
- **localhost / 127.0.0.1:** Refers to my own computer and allows local testing without network access from other devices.
- **0.0.0.0:** When used as a server binding address, it allows the server to listen on all network interfaces.

| `server.address` | Who can reach it? |
|---|---|
| `127.0.0.1` | Only my own computer |
| `localhost` | Only my own computer |
| Private IP | Devices that can reach that network IP, subject to firewall |
| `0.0.0.0` | All network interfaces, subject to firewall |

A colleague cannot use my `localhost` because it refers to their own computer, not mine. A dynamic private IP may change after reconnecting, making an old server link unreliable.

### 1.2 SDLC
**Source:** GeeksforGeeks

- **Requirement gathering & planning:** Identify what the software needs to do and plan resources, time and feasibility.
- **SRS:** Documents the functional and non-functional requirements of the software.
- **SDS/SDD:** Describes how the system will be designed and implemented technically.
- **SLA:** An agreement defining service expectations, such as 99.9% uptime.
- **Design:** Create the system architecture and technical blueprint.
- **Develop:** Write the code and build the software.
- **Test:** Check the software for errors and verify requirements.
- **Deploy:** Release the software for use.
- **Maintain:** Fix bugs, update and improve the software.

**Current issue:** This issue mainly involves development and testing. Requirements were defined before implementation through the user story and acceptance criteria.

### 1.3 Agile, Scrum and Kanban
**Source:** Atlassian — [Scrum vs Kanban](https://www.atlassian.com/agile/kanban/kanban-vs-scrum)

- **Agile:** An approach to software development that encourages flexibility, collaboration and delivering work incrementally.
- **Scrum:** Uses fixed-length sprints, a backlog, daily stand-ups, sprint reviews and retrospectives.
- **Kanban:** Visualizes work on a board, uses workflow columns and limits work in progress to improve continuous flow.

| Scrum | Kanban |
|---|---|
| Works in fixed-length sprints | Continuous workflow |
| Sprint planning and defined ceremonies | Flexible planning as capacity allows |
| Sprint backlog and sprint goals | Work-in-progress limits and flow |

### 1.4 IAM, LDAP and Active Directory
**Sources:** Cloudflare, GeeksforGeeks and Microsoft Learn

- **IAM:** Manages identities and permissions. It answers who someone is and what they are allowed to access.
- **LDAP:** A protocol used to access and look up information stored in directories.
- **Active Directory:** Microsoft's directory service that stores information about users, groups, computers and network resources.

IAM is the overall concept of managing identities and access. Active Directory is a directory service that stores identity information. LDAP is one protocol applications can use to communicate with directory services such as Active Directory.

---

## Part 2 — Server Address Experiments

| `server.address` | Result |
|---|---|
| `localhost` | Worked with `localhost` and `127.0.0.1`. |
| `127.0.0.1` | Worked with `localhost` and `127.0.0.1`. |
| `192.168.100.14` | Worked with my private IP, but `localhost` did not work. |
| `0.0.0.0` | Worked with both `localhost` and my private IP. |
| `0.0.0.0` (colleague) | Not tested because I was working on the weekend. |

I recommend `0.0.0.0` when colleagues need to access the server over the same network because it listens on all network interfaces, subject to firewall restrictions.

### Blockers
No blockers.

