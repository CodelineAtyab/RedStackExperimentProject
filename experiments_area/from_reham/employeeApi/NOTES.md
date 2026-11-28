# Issue #645 – NOTES

## 1. Part 1 – Research

### 1.1 Networking

- **Private IP:** Used inside a local network, like home or office Wi-Fi.
- **Public IP:** Used to identify a network on the internet.
- **Static IP:** An IP address that stays the same.
- **Dynamic IP:** An IP address that can change.
- **DHCP:** Automatically gives IP addresses to devices.

**IP addresses:**
- `127.0.0.1` and `localhost` refer to my own computer.
- A private IP allows other devices on the same network to connect to my computer.
- `0.0.0.0` allows the server to listen on all IPv4 network interfaces.

Other people cannot use my `localhost` because it refers to their own computer. They need my private IP address to connect to my server.

A dynamic IP can change, so an old link may stop working.

### 1.2 SDLC

SDLC means Software Development Life Cycle. It is the process of building and maintaining software.

**Main stages:**
1. Planning
2. Requirements
3. Design
4. Development
5. Testing
6. Deployment
7. Maintenance

- **SRS:** Explains what the software should do.
- **SDS/SDD:** Explains how the software will be built.
- **SLA:** An agreement about the service and support.

Requirements are usually collected from customers and users.

This issue includes development and testing because I had to make changes and test the API.

### 1.3 Agile, Scrum and Kanban

- **Agile:** Develops software in small steps and uses feedback.
- **Scrum:** Organizes work into short periods called sprints.
- **Kanban:** Uses a board to track tasks.

**Scrum includes:**
- Sprint: A short period to complete tasks.
- Product Backlog: A list of tasks.
- Daily Stand-up: A short team meeting.
- Sprint Review: Showing completed work.
- Sprint Retrospective: Discussing improvements.

**Kanban** uses columns such as To Do, In Progress and Done. WIP limits control how many tasks can be in progress.

| Scrum | Kanban |
|---|---|
| Uses fixed sprints | Continuous work |
| Plans tasks for each sprint | Tasks move when there is space |
| Has sprint meetings | Focuses on work progress |

### 1.4 IAM, LDAP and Active Directory

- **IAM:** Manages users and what they can access.
- **LDAP:** A protocol used to access directory information.
- **Active Directory:** A Microsoft service used to manage users, computers and permissions.

Active Directory can use LDAP. IAM is the general way of managing identities and access.

---

## 2. Part 2 – Practical Work

### 2.1 Server Configuration

I changed the server port from `8080` to `8081` and tested different addresses.

| Server address | Result |
|---|---|
| `127.0.0.1` | Worked on my computer |
| `localhost` | Worked on my computer |
| `192.168.0.176` | Worked using my private IP |
| `0.0.0.0` | Allowed the server to listen on all IPv4 interfaces |

I also tested the private IP from another device connected to the same Wi-Fi. It worked.

**Final settings:**

```properties
server.port=8081
server.address=0.0.0.0
```

### 2.2 Customer and Feedback API

- Changed `Customer.id` to String to match `Feedback.customerId`.
- Created `CustomerService` to handle customer operations.
- Updated `FeedbackService` to check if a customer exists before adding feedback.
- Updated the controllers to use the services.
- Added an error message when the customer ID does not exist.
- Deleting a customer also deletes their feedback.

### 2.3 Postman Tests

I tested:

- Creating, getting, updating and deleting customers.
- Creating, getting, updating and deleting feedback.
- Getting feedback for a specific customer.
- Creating feedback with an existing customer ID.
- Creating feedback with an unknown customer ID.

The tests worked as expected. When I used a customer ID that did not exist, the API returned `404 Not Found`.

**Blockers:** No blockers.

---

## 3. Conclusion

I learned about networking, SDLC, Agile, Scrum, Kanban, IAM and Active Directory. I also practiced changing server settings, connecting services and testing the API using Postman.

## 4. References

1. [Cloudflare – IP Addresses](https://www.cloudflare.com/learning/network-layer/what-is-an-ip-address/)
2. [Cloudflare – DHCP](https://developers.cloudflare.com/cloudflare-wan/configuration/appliance/network-options/dhcp/?utm_source=chatgpt.com)
3. [Microsoft Learn – TCP/IP](https://learn.microsoft.com/en-us/troubleshoot/windows-client/networking/tcpip-addressing-and-subnetting)
4. [Atlassian – SDLC](https://www.atlassian.com/agile/software-development/sdlc)
5. [Scrum Guide](https://scrumguides.org/scrum-guide.html)
6. [Atlassian – Kanban](https://www.atlassian.com/agile/kanban)
7. [Microsoft Learn – Active Directory](https://learn.microsoft.com/en-us/windows-server/identity/ad-ds/active-directory-domain-services)
8. [Microsoft Learn – IAM](https://learn.microsoft.com/en-us/entra/fundamentals/introduction-identity-access-management)
9. [RFC 4511 – LDAP](https://www.rfc-editor.org/rfc/rfc4511)