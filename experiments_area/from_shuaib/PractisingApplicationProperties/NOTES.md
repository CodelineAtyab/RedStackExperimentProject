# Notes

## Part 1: Reading Assignment

### 1.1 Networking Basics
Sources:
- Cloudflare Learning Center: What is an IP address? / What is a private IP address? / What is DHCP?
- Wikipedia: Localhost / 0.0.0.0

- **Private vs. Public IP:** Private IPs are used inside local networks (like home Wi-Fi or LAN) and are not routed on the public internet—common examples include `192.168.x.x` (`192.168.0.0/16`), `10.0.0.0/8`, and `172.16.0.0/12`. Public IPs are globally unique addresses used to route traffic across the internet.
- **Static vs. Dynamic IP:** A static IP stays fixed unless changed manually, while a dynamic IP is assigned automatically for a lease and can change. My router gives my laptop a dynamic private IP, which matters for a server because teammates using an old IP can lose connection if the IP changes.
- **DHCP Server vs. DHCP Client:** A DHCP server assigns IP addresses and network settings (gateway, subnet mask, DNS) on a lease, and a DHCP client requests/renews them to connect. My router is the DHCP server, and my laptop is the DHCP client.
- **Reachability by `server.address`:**

| `server.address` | Who can reach your server? |
|---|---|
| `127.0.0.1` | Only my own laptop via `127.0.0.1` (loopback). |
| `localhost` | Only my own laptop via `localhost` (loopback). |
| Private IP (e.g. `192.168.1.42`) | Devices on the network that can reach that interface (if firewall allows it), not bound to all interfaces. |
| `0.0.0.0` | All IPv4 interfaces on my laptop (loopback + LAN/Wi-Fi), subject to firewall rules. |

- **Why a colleague can't open `http://localhost:8081` to see my server:** `localhost` always points to the local machine itself (`127.0.0.1`), so their laptop checks port `8081` on their own machine rather than mine.
- **Why a dynamic private IP breaks a shared link after reboot:** Reconnecting or rebooting can renew/change the DHCP lease and assign a new private IP, making the old link point to the wrong address or fail.

---

### 1.2 SDLC
Sources:
- Atlassian: SDLC / What is an SLA?
- GeeksforGeeks: SDLC / SRS

- **Requirement gathering & planning:** Gathering what the system/users need and planning scope, tasks, timeline, and resources.
- **SRS:** Lists functional and non-functional requirements (what the system must do and constraints), written/shaped by analysts, product/stakeholders, and technical contributors.
- **SDS / SDD:** Focuses on *how* to build it technically (architecture, classes, endpoints, data flow), whereas SRS defines *what* is required.
- **SLA:** A service commitment with measurable targets, such as `99.9%` uptime.
- **Phases:**
  - **Design:** Plan technical architecture, components, and data structure.
  - **Develop:** Write the code and configuration.
  - **Test:** Verify behavior, edge cases, and regressions.
  - **Deploy:** Put the build into the target environment so it can run/be accessed.
  - **Maintain:** Fix bugs, keep dependencies/systems healthy, and support updates over time.
- **This issue:** Mainly **develop** and local **test**, with requirements coming from the issue spec.

---

### 1.3 Agile, Scrum and Kanban
Sources:
- Atlassian: Agile Scrum vs Kanban
- Scrum Guide

- **Agile:** Iterative delivery of working software in small increments with regular adaptation to feedback and change.
- **Scrum parts:** Product/sprint backlog, time-boxed sprints, daily stand-up, sprint review, and sprint retrospective.
- **Kanban:** Visual board with columns and Work in Progress (WIP) limits to keep work flowing smoothly.

| Aspect | Scrum | Kanban |
|---|---|---|
| Cadence | Fixed time-boxed sprints | Continuous flow |
| Roles | Defines Scrum roles (PO, Scrum Master, Developers) | No fixed role set required |
| Flow & changes | Sprint scope focus + velocity | WIP limits + cycle/lead time |

---

### 1.4 Active Directory, IAM and LDAP
Sources:
- Cloudflare: What is IAM? / What is LDAP?
- Microsoft Learn: Active Directory Domain Services overview

- **IAM:** Identity and Access Management—handles identities and access control, answering *who are you?* (authentication) and *what may you do?* (authorization).
- **LDAP:** A protocol used to query, search, and authenticate against directory services.
- **Active Directory:** Microsoft's directory service storing users, groups, computers, and policies on a network.
- **How they relate:** IAM is the overall concept/system for authentication and authorization. Active Directory is one directory service that stores identities and group data. LDAP is a protocol that apps/services use to talk to directory services like Active Directory.

---

## Part 2: Spring Boot Change

### Step A: `server.address` Tests

| `server.address` | Result | Explanation |
|---|---|---|
| `127.0.0.1` | [Worked / refused — fill actual result] | Binds only to loopback (`127.0.0.1`), so only this machine can connect. |
| `localhost` | [Fill actual result] | Binds to local loopback rather than external network interfaces. |
| `[Private IP]` | [Fill actual result + check `localhost`] | Listens on that specific network interface rather than all interfaces. |
| `0.0.0.0` | [Fill actual result + second device/colleague test] | Listens on all IPv4 interfaces on the machine (firewall may still block external traffic). |

- **Recommended value for team access:** `0.0.0.0`
- **Why:** Listens across local/network interfaces so teammates on the network can reach it without breaking if my dynamic private IP changes.

---

### Step B: Unknown `customerId`

- **Status code:** `404 Not Found` (or `400 Bad Request` — update to match what you return)
- **Why:** Clearly tells the client that the referenced `customerId` does not exist so the feedback cannot be created.

---

### Blockers & Notes

- **Blockers:** `[Exact error message if any, otherwise: No blockers]`
- **Harder than expected:** `[1–2 sentences on what tripped you up, e.g. firewall/network reachability or keeping controller thin while checking CustomerService]`