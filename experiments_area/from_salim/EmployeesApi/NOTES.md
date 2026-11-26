# Employees API Notes

## HTTP methods

- GET reads employee information from the server.
- POST sends employee data to the server to create an employee.
- PUT replaces the data for the employee ID in the URL.
- DELETE removes one employee or, with confirmation, all employees.
- QUERY reads data using a request body and is designed for safe, repeatable queries. This project does not implement QUERY.

## Postman requests and responses

| Request | Result |
|---|---|
| `POST /employees` with `{"id":"1","name":"Sara"}` | `200 OK` — returned `{"id":"1","name":"Sara"}` |
| `POST /employees` with `{"id":"2","name":"Ali"}` | `200 OK` — returned `{"id":"2","name":"Ali"}` |
| `GET /employees` | `200 OK` — returned both employees as a JSON array |
| `GET /employees/2` | `200 OK` — returned `{"id":"2","name":"Ali"}` |
| `PUT /employees/2` with `{"id":"2","name":"Ali Khan"}` | `200 OK` — returned `{"id":"2","name":"Ali Khan"}` |
| `DELETE /employees/1` | `200 OK` — returned `{"message":"Employee 1 deleted"}` |
| `DELETE /employees` | `400 Bad Request` — returned a confirmation message; no employees deleted |
| `DELETE /employees?confirm=true` | `200 OK` — returned `{"message":"All employees deleted"}` |
| `GET /employees` after deleting all | `200 OK` — returned `[]` |

# issue #645 NOTES

## 1.1 Networking

- **Private IP:** Used inside a local network, e.g. `192.168.100.130`. **Public IP:** Routable on the internet, e.g. `8.8.8.8`.
- **Static IP:** Intended to stay the same. **Dynamic IP:** Assigned temporarily and may change. My router usually gives my laptop a dynamic private IP.
- **DHCP:** The router is usually the DHCP server that assigns network settings; my laptop is the client that requests them.
- **Server addresses:** `127.0.0.1` and `localhost` are for this computer. A private IP reaches the network interface using that address. `0.0.0.0` listens on all IPv4 interfaces.
- A colleague’s `localhost` points to their own computer. A changing private IP can make a shared link outdated.

## 1.2 SDLC

- **Requirement gathering and planning:** Find what users need, then plan the work and resources.
- **SRS:** Describes functional and non-functional requirements; analysts and stakeholders help prepare it.
- **SDS/SDD:** Describes how the system will be designed to meet the SRS.
- **SLA:** An agreement about service levels, such as 99.9% uptime.
- **Phases:** Design plans the structure; develop writes the code; test checks it; deploy releases it; maintain fixes and updates it.
- This issue is in development and testing. Requirements came from the issue and acceptance criteria.

## 1.3 Agile, Scrum, and Kanban

- **Agile:** Deliver in small steps and adapt using feedback.
- **Scrum:** Uses a backlog, sprints, planning, daily stand-ups, reviews, and retrospectives.
- **Kanban:** Uses a board and columns to show work, with limits on work in progress.

| Aspect | Scrum | Kanban |
|---|---|---|
| Cadence | Fixed sprints | Continuous flow |
| Events | Sprint events and defined roles | Focus on flow; no required sprint events |
| Work | Planned for a sprint | Continuously reprioritized |

## 1.4 Active Directory, IAM, and LDAP

- **IAM:** Manages identities and access: who a user is and what they may do.
- **LDAP:** A protocol for looking up information in a directory.
- **Active Directory:** Microsoft’s directory service for users, groups, and computers.
- IAM is the overall practice; Active Directory stores identities and resources; applications can use LDAP to access directory information.

## Part 2: Spring Boot

### Address test results

| `server.address` | Result |
|---|---|
| `127.0.0.1` | `127.0.0.1` and `localhost` worked on my computer; private IP and other devices were refused. |
| `localhost` | `localhost` worked on my computer; private IP and other devices were refused. |
| `192.168.100.130` | Private IP worked on my computer and another Wi-Fi device; `localhost` and `127.0.0.1` were refused. |
| `0.0.0.0` | `localhost`, `127.0.0.1`, private IP, and another Wi-Fi device worked. |

I recommend `server.address=0.0.0.0` so the server listens on all IPv4 interfaces and colleagues on the same Wi-Fi can connect using my private IP.

### Feedback

- Unknown `customerId`: return `404 not found` with a clear message.
- **Blockers:** No blockers.
- Nothing harder than expected

### Feedback/customer link

- Feedback includes a `customerId` field in the response JSON.
- The feedback service checks the customer ID through `CustomerService` before creating feedback.
- An unknown customer ID returns `404 Not Found` with a message.
- Deleting a customer also deletes that customer's feedback.

## Sources

- [Cloudflare: IP addresses](https://www.cloudflare.com/learning/dns/glossary/what-is-my-ip-address/)
- [Cloudflare: DHCP](https://www.cloudflare.com/learning/network-layer/what-is-dhcp/)
- [Atlassian: SDLC](https://www.atlassian.com/agile/software-development/sdlc/)
- [GeeksforGeeks: SRS](https://www.geeksforgeeks.org/software-engineering/software-engineering-parts-of-a-srs-document/)
- [Atlassian: Scrum vs. Kanban](https://www.atlassian.com/agile/kanban/kanban-vs-scrum)
- [Cloudflare: IAM](https://www.cloudflare.com/learning/access-management/what-is-identity-and-access-management/)
- [LDAP](https://en.wikipedia.org/wiki/Lightweight_Directory_Access_Protocol)
- [Microsoft Learn: Active Directory Domain Services](https://learn.microsoft.com/en-us/windows-server/identity/ad-ds/active-directory-domain-services)