# NOTES.md - Ticket #645 (server.address / server.port and customerId in feedback)

Name: Mohammed Alsiyabi
Project: `experiments_area/from_MohammedAlsiyabi/EmployeesAPI`

---

# PART 1: Reading

## 1.1 Networking basics
Sources I used: Cloudflare "What is an IP address?", Cloudflare "What is a private IP address?", Cloudflare "What is DHCP?", Wikipedia "localhost", Wikipedia "0.0.0.0".

**Private vs public IP.** A public IP address is unique on the internet, so any device in the world can reach it. A private IP address only works inside a local network like my home Wi-Fi, and many networks reuse the same private numbers. Private ranges are `10.x.x.x`, `172.16.x.x` to `172.31.x.x` and `192.168.x.x`. A public example is `8.8.8.8`. My laptop has the private IP `192.168.100.210`.

**Static vs dynamic IP.** A static IP is set by hand and never changes. A dynamic IP is given by a DHCP server and can change when I reconnect or restart. My home router normally gives my laptop a dynamic private IP. This matters for a server because other people need an address that stays the same to find it.

**DHCP.** The DHCP server gives out IP addresses and network settings (gateway, DNS) automatically. The DHCP client is the device that asks for an address. My router is the DHCP server and my laptop is the DHCP client. The steps are Discover, Offer, Request, Acknowledge (DORA).

**Who can reach my server?**

| `server.address` | Who can reach your server? |
|---|---|
| `127.0.0.1` | Only my own laptop. This address (loopback) never leaves my machine. |
| `localhost` | Only my own laptop. It is a name that points to 127.0.0.1. |
| my private IP (`192.168.100.210`) | Devices on the same Wi-Fi that use that IP. On my laptop it works with the private IP, but not with `localhost`. |
| `0.0.0.0` | Everyone who can reach any of my laptop's network addresses: my laptop through `localhost`, and other devices on the same Wi-Fi (unless a firewall blocks them). |

**Why a colleague cannot open `http://localhost:8081` and see my server.** `localhost` always means "this same machine". On my colleague's laptop it points to their own laptop, so they would see their own server (or nothing), not mine.

**Why a dynamic private IP makes "give your colleague the link" unreliable.** After a reboot or reconnecting to Wi-Fi, the DHCP server can give my laptop a different IP. The old link then points to a wrong address or to nothing.

## 1.2 SDLC
Sources I used: GeeksforGeeks "Software Development Life Cycle", GeeksforGeeks "SRS document", Atlassian "What is an SLA?".

- **Requirement gathering and planning:** The team talks to the client and users to find out what the software must do. Then they plan the scope, time, people and cost.
- **SRS (Software Requirements Specification):** A document that lists what the system must do (functions) and how well (speed, security). Usually business analysts or the product owner write it together with the client.
- **SDS (Software Design Specification / SDD):** A document that explains how the system will be built (architecture, classes, database, APIs). Developers and architects write it. The SRS says "what", the SDS says "how".
- **SLA (Service Level Agreement):** A promise from a provider to a customer about the service level. For example "the service is available 99.9 percent of the month".
- **Design:** Plan the architecture and how the parts fit together.
- **Develop:** Write the code.
- **Test:** Look for bugs and check that the requirements are met.
- **Deploy:** Release the software so users can use it.
- **Maintain:** Fix bugs and make improvements after release.
- **Where this issue belongs:** This work is in the **develop** phase, with a small part of design (how feedback links to a customer). Requirement gathering already happened when the trainer wrote the user story and acceptance criteria in this issue.

## 1.3 Agile, Scrum and Kanban
Sources I used: Atlassian "Scrum vs Kanban", Scrum Guide (first sections).

- **Agile:** A way of building software in small steps with frequent feedback, so the team can change direction when requirements change instead of planning everything at the start.
- **Scrum parts:** sprint (a fixed 1 to 4 week cycle), product backlog and sprint backlog, daily stand-up, sprint review, sprint retrospective. Roles are Product Owner, Scrum Master and the developers.
- **Kanban:** Work is shown on a board with columns like To Do, In Progress and Done. The team limits work in progress (WIP) so too many tasks are not open at once.

| | Scrum | Kanban |
|---|---|---|
| Time | Fixed-length sprints | Continuous flow, no sprints |
| Roles | Product Owner, Scrum Master, team | No required roles |
| Changes | Scope is kept stable during a sprint | Work can be added at any time, WIP limits control the flow |

## 1.4 IAM, LDAP and Active Directory
Sources I used: Cloudflare "What is IAM?", Cloudflare "What is LDAP?", Microsoft Learn "Active Directory Domain Services overview".

- **IAM (Identity and Access Management):** Managing who users are and what they may do. It answers two questions: who are you (authentication) and what may you do (authorization).
- **LDAP:** A protocol for looking up and checking users and other entries in a directory.
- **Active Directory:** A Microsoft directory service that stores users, groups and computers of an organization.
- **How they relate:** IAM is the overall idea of managing identities and permissions. Active Directory is one product that stores the identities. LDAP is one of the ways applications talk to that directory, for example to check a username and password. So an application can use LDAP to ask Active Directory who a user is, as part of an IAM system.

---

# PART 2: Spring Boot

## 2.1 `application.properties`
Final file:
```
spring.application.name=employees-api
server.port=8081
server.address=0.0.0.0
server.error.include-message=always
```
The app answers on port 8081 and no longer on 8080: `curl http://localhost:8080/feedback` gave `curl: (7) Failed to connect to localhost port 8080 ... Couldn't connect to server`.

`server.error.include-message=always` is only there so error responses show their message (for example the unknown customer message).

## 2.2 Results of the four `server.address` values
My private IP at test time: `192.168.100.210` (from `ipconfig getifaddr en0`), port 8081. I restarted the app after every change. A fresh start returns `[]` because the data is in memory.

| # | `server.address` | What I tested | Result | Why |
|---|---|---|---|---|
| 1 | `127.0.0.1` | `http://127.0.0.1:8081/feedback` | Worked (200, `[]`) | 127.0.0.1 is the loopback address of my own laptop. |
| 1 | `127.0.0.1` | `http://localhost:8081/feedback` | Worked (200, `[]`) | `localhost` is just a name for 127.0.0.1. |
| 2 | `localhost` | `http://localhost:8081/feedback` | Worked (200, `[]`) | It binds to the same loopback address, so only my laptop. |
| 2 | `localhost` | `http://127.0.0.1:8081/feedback` | Worked (200, `[]`) | `localhost` resolves to 127.0.0.1. |
| 3 | `192.168.100.210` | `http://192.168.100.210:8081/feedback` | Worked (200, `[]`) | The server is bound to my Wi-Fi address. |
| 3 | `192.168.100.210` | `http://localhost:8081/feedback` | **Failed:** `curl: (7) Failed to connect to localhost port 8081 ... Couldn't connect to server` | The server listens only on the Wi-Fi address, not on the loopback address. |
| 4 | `0.0.0.0` | `http://localhost:8081/feedback` | Worked (200, `[]`) | `0.0.0.0` means all interfaces, including loopback. |
| 4 | `0.0.0.0` | `http://192.168.100.210:8081/feedback` | Worked (200, `[]`) | All interfaces, including the Wi-Fi one. |

Note: my first attempt at these tests was not valid. I forgot to restart the app, so the old server (still holding the earlier data `f1`) answered every request. I knew because the list was not `[]`. I stopped the old process, restarted for each value, and repeated the tests. The table above is from the repeated tests.

## 2.3 Test from another device (`server.address=0.0.0.0`)
[EDIT THIS BEFORE SUBMITTING: write who tested (a colleague or your phone on the same Wi-Fi), the URL `http://192.168.100.210:8081/feedback` (use your current IP), and what happened. If it did not work, write what you saw and that a firewall may be the cause. If you could not test, say why.]

## 2.4 My recommendation
I recommend `server.address=0.0.0.0` with `server.port=8081`. My colleagues need to reach my server through my Wi-Fi IP, and `0.0.0.0` allows that and still allows `localhost` for me. I also don't have to hard-code an IP that DHCP may change after a reconnect. The downside is that anyone on the same network can reach the server, so it is fine for practice but not for private data.

## 2.5 Feedback with `customerId`
- The `Feedback` model has the fields `id`, `message` and `customerId`.
- `POST /feedback` accepts `customerId` in the body. `FeedbackService` checks that the customer exists (through `CustomerService`, using the same list as `CustomerController`) before saving.
- `GET /feedback` and `GET /feedback/{id}` return the feedback with its `customerId`.
- The controller only calls the service (`@Autowired`), and the logic stays in the service.

**My choice for an unknown `customerId`: `400 Bad Request`** with the message `Customer with id 'nope' does not exist`. The URL `/feedback` is correct, the problem is a wrong value inside the request body, so 400 fits better than 404.

`POST /feedback` returns **201 Created** on success, the same as `POST /customers`.

## 2.6 Postman / curl test results

| # | Request | Status | Response |
|---|---|---|---|
| 1 | POST `/customers` `{"id":"c1","name":"Sara"}` | 201 | `{"id":"c1","name":"Sara"}` |
| 2 | POST `/feedback` `{"id":"f1","message":"Great service","customerId":"c1"}` | 201 | `{"id":"f1","message":"Great service","customerId":"c1"}` |
| 3 | GET `/feedback/f1` | 200 | `{"id":"f1","message":"Great service","customerId":"c1"}` |
| 4 | GET `/feedback` | 200 | `[{"id":"f1","message":"Great service","customerId":"c1"}]` |
| 5 | POST `/feedback` `{"id":"f2","message":"Hi","customerId":"nope"}` | 400 | `{"timestamp":"2026-11-23T11:34:42.516+00:00","status":400,"error":"Bad Request","message":"Customer with id 'nope' does not exist","path":"/feedback"}` |

## 2.7 Blockers
1. **Compile errors** after adding the new files, for example `class FeedbackService is public, should be declared in a file named FeedbackService.java` and `package com.example.deskapi.model does not exist`. Cause: the file names and package lines did not match my project (`com.teamred.employees`), and `EmployeeService.java` had been overwritten. Fix: corrected the package lines, renamed the file and restored `EmployeeService.java` from git (commit `7889cb1`).
2. **`APPLICATION FAILED TO START ... Web server failed to start. Port 8081 was already in use.`** An old server was still running. Fix: stopped it with `lsof -i :8081` and `kill <PID>`.
3. **`/feedback` returned 404** (`"error":"Not Found","path":"/feedback"`) because I had deleted the feedback controller. Fix: added `FeedbackController` again with the right package.
4. **Feedback was refused with 400 for a valid customer `c1`.** Cause: customers were saved in `DataStore.customers` by `CustomerController`, but `CustomerService` kept its own separate empty list, so the check never found them. Fix: changed `CustomerService` and `FeedbackService` to use `DataStore`.
5. **My first `server.address` tests were invalid** because I did not restart the app (the list still contained `f1`). Fix: restarted for every value and checked that the list was `[]`.

Harder than expected: finding out that two different lists held the customers, and remembering that the in-memory server must be fully restarted after every change to `application.properties`.