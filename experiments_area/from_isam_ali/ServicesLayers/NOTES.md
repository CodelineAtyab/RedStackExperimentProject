# NOTES – server.address / server.port and customerId in feedback (#645)

# PART 1: Reading

Sources used: the suggested pages from the ticket: Cloudflare Learning Center (IP address, private IP, DHCP, IAM, LDAP), Wikipedia (localhost, 0.0.0.0, LDAP), GeeksforGeeks / Atlassian (SDLC, SRS, SLA), Atlassian and the Scrum Guide (Scrum vs Kanban), Microsoft Learn (Active Directory).

## 1.1 Networking basics
- **Private vs public IP:** private works inside a local network (`10.x.x.x`, `172.16-31.x.x`, `192.168.x.x`). Public is unique on the internet (for example `8.8.8.8`).
- **Static vs dynamic IP:** static never changes. Dynamic is given by DHCP and can change. My router gives my laptop a dynamic IP, so my server's address can change.
- **DHCP:** the server (my router) hands out IPs. The client (my laptop) asks for one.

| `server.address` | Who can reach your server? |
|---|---|
| `127.0.0.1` | Only my laptop |
| `localhost` | Only my laptop (name for 127.0.0.1) |
| my private IP | My laptop (via that IP) and devices on the same network |
| `0.0.0.0` | Everyone who can reach any of my laptop's addresses: me and the same network |

- **Why a colleague can't open my `localhost:8081`:** `localhost` always means "this computer", so on their laptop it points to their own machine.
- **Why a dynamic IP breaks a shared link:** after a reboot the router may give me a new IP, so the old link stops working.

## 1.2 SDLC
- **Requirement gathering and planning:** collect what users need, then decide scope, time, people and risks.
- **SRS:** document of **what** the software must do. Written by analysts or the product owner with the client.
- **SDS (SDD):** document of **how** it will be built (architecture, data, APIs). Written by developers or architects.
- **SLA:** a promise about service level, for example "99.9 percent uptime".
- **Phases:** design (plan the structure), develop (write the code), test (find bugs), deploy (release it), maintain (fix and improve).
- **This issue:** the **develop** phase. Requirements were gathered earlier, when the trainer wrote this ticket.

## 1.3 Agile, Scrum, Kanban
- **Agile:** build software in small steps, deliver often, take feedback, change plans when needed.
- **Scrum parts:** product backlog, sprint, daily stand-up, sprint review, retrospective.
- **Kanban:** a board with columns (To Do, In Progress, Done) and a limit on work in progress.

| | Scrum | Kanban |
|---|---|---|
| Time | Fixed sprints | Continuous flow |
| Roles | Product owner, scrum master, team | No required roles |
| Limits | Sprint scope | Work-in-progress limit per column |

## 1.4 IAM, LDAP, Active Directory
- **IAM:** manages identities and access. Answers: who are you, and what may you do?
- **LDAP:** a protocol to look up and check users in a directory.
- **Active Directory:** Microsoft's directory that stores users, groups and computers.
- **How they relate:** IAM is the overall idea. Active Directory stores the identities. LDAP is one way an app asks it, for example "is this user valid?".

# PART 2: Spring Boot

## `server.address` results (port 8081)

| # | `server.address` | What I tried | Result | Why |
|---|---|---|---|---|
| 1 | `127.0.0.1` | `127.0.0.1:8081` in Postman | Worked (200) | 127.0.0.1 is the loopback address, so only my own laptop can reach it |
| 2 | `localhost` | `localhost:8081` | Worked (`200 OK`) | `localhost` is the name for 127.0.0.1, so it behaves like row 1: only my own laptop |
| 3 | my private IP (hidden here, format `192.168.x.x`) | private IP, and `localhost` | Private IP worked (`200 OK`). `localhost`: TODO (expected: connection refused) | The server listens only on that one address, so other names such as `localhost` (127.0.0.1) do not reach it |
| 4 | `0.0.0.0` | Not tested | Could not test: I am working online and need a colleague on the same network to try it |  `0.0.0.0` means "all interfaces", so it should answer on `localhost` and on the private IP |

**Colleague test (row 4):** I could not test it from another device, because I was working online / remotely and was not on the
same Wi-Fi as a colleague. From what I read in Part 1, with `0.0.0.0` a device on the same network could open
`http://<my-private-ip>:8081/feedback`, as long as no firewall blocks it. A device outside the network could not.

Also: the app answers on 8081 and no longer on 8080: TODO

**My recommendation for a server colleagues must reach:** `0.0.0.0`, because it listens on every network interface, so
colleagues can reach it with my private IP. Only on a trusted network, because anyone on it can reach the server.
(A firewall or a changed private IP can still block a colleague.)

## Unknown `customerId`
`POST /feedback` with an unknown `customerId` answers `400 Bad Request` with a message, and nothing is saved.
I chose 400 because the wrong id is in the JSON body, not in the URL.

## Postman (status code and JSON)
Server on `http://localhost:8081`.
1. `POST /customers` `{"id":"c1","name":"Sara"}` -> `201 Created`, Sara
2. `POST /feedback` `{"id":"f1","message":"Great service","customerId":"c1"}` -> `201 Created`, f1 created
3. `GET /feedback/f1` -> `200 OK`, `{"id":"f1","message":"Great service","customerId":"c1"}`
4. `GET /feedback` -> `200 OK`, `[ {"id":"f1","message":"Great service","customerId":"c1"} ]`
5. `POST /feedback` `{"id":"f2","message":"Hi","customerId":"nope"}` -> `400 Bad Request`, "Refused: no customer with id nope exists", nothing saved

## Blockers
- **Could not test from another device (row 4, `server.address=0.0.0.0`).** I was working online / remotely, so I was not on
  the same Wi-Fi network as a colleague and could not ask anyone to open `http://<my-private-ip>:8081/feedback`.
  There was no error message. I tested `localhost` and my own private IP from my laptop instead, and explained the
  expected result for another device in the `server.address` section above.
- No other blockers.