# Notes — Issue #645 (`server.address` / `server.port` & `Feedback.customerId`)

## Part 1: Reading Assignment

### 1.1 Networking Basics
*Sources used: Cloudflare Learning Center (What is an IP address?, What is a private IP address?, What is DHCP?), Wikipedia (localhost, 0.0.0.0).*

* **Private vs. Public IP addresses:** A private IP address is used inside a local network (such as home Wi-Fi or an office LAN) and is not directly routable on the public internet; common private ranges include `192.168.0.0`–`192.168.255.255` (often `192.168.x.x`), `10.0.0.0`–`10.255.255.255`, and `172.16.0.0`–`172.31.255.255`. A public IP address is assigned by an ISP so devices can communicate across the wider internet.
* **Static vs. Dynamic IP addresses:** A static IP address stays fixed unless manually changed, whereas a dynamic IP address is assigned automatically and can change over time. My home/local router usually gives my laptop a dynamic IP address, which matters for a server because other devices might try an old address if the IP changes.
* **DHCP client and DHCP server:** A DHCP server hands out IP addresses and network configuration automatically, while a DHCP client requests and receives those settings. My laptop acts as the DHCP client, and the router acts as the DHCP server.
* **Who can reach the server by `server.address`:**

| `server.address` | Who can reach your server? |
|---|---|
| `127.0.0.1` | Only my own laptop via loopback (`127.0.0.1`). |
| `localhost` | Only my own laptop via the `localhost` hostname. |
| your **private IP** (e.g., `192.168.1.42`) | My own laptop and other devices on the same local network that can reach that private IP (subject to firewall rules). |
| `0.0.0.0` | My own laptop (via loopback or local IPs) and any device that can reach any of my laptop's network interfaces (such as devices on the same Wi-Fi, if not blocked by a firewall). |

* **Why a colleague cannot open `http://localhost:8081` to reach my server:** `localhost` always resolves to a colleague's *own* machine's loopback address (`127.0.0.1` or `::1`), not my laptop over the network.
* **Why a dynamic private IP makes sharing a link unreliable after a reboot:** If DHCP assigns a different private IP after reconnecting or rebooting, a bookmarked or shared `http://<old-private-ip>:8081` link will point to the wrong device or fail to connect.

---

### 1.2 SDLC (Software Development Life Cycle)
*Sources used: Atlassian (SDLC, What is an SLA?), GeeksforGeeks (SDLC, Software Requirement Specification).*

* **Requirement gathering and planning:** Requirement gathering is collecting what users and stakeholders need the software to do, while planning maps out scope, tasks, timelines, and resources before building.
* **SRS (Software Requirements Specification):** It documents functional and non-functional requirements, expected behavior, and constraints, and is typically written by business analysts, product owners, or engineers together with stakeholders.
* **SDS (Software Design Specification / SDD):** While the SRS describes *what* the system must do and its requirements, the SDS describes *how* to build it—covering architecture, components, data models, APIs, and technical design choices.
* **SLA (Service Level Agreement):** An SLA defines measurable service expectations between a provider and consumer, such as promising **99.9% monthly uptime** or a maximum response time.
* **SDLC phases:**
  * **Design:** Plan the system architecture, data structures, and interfaces based on requirements.
  * **Develop:** Write and integrate the application code according to the design.
  * **Test:** Verify features, edge cases, and regressions to catch defects.
  * **Deploy:** Release the built application to the target runtime environment.
  * **Maintain:** Monitor, fix issues, and update the running system over time.
* **Where this issue fits:** This work is in the **develop** (and local **test**) phase of the SDLC, and requirement gathering happened in the issue specification / user story and team guidance.

---

### 1.3 Agile, Scrum and Kanban (Revision)
*Sources used: Atlassian (Agile Scrum vs Kanban), Scrum Guide.*

* **Agile:** Agile is an iterative approach to software development that delivers working increments frequently and adapts to feedback and changing needs.
* **Main Scrum parts:** Product backlog, sprint (time-boxed iteration), sprint planning/review/retrospective, daily stand-up, and accountability roles (Product Owner, Scrum Master, Developers).
* **Kanban:** Kanban visualizes work items on a board with workflow columns (such as To Do, In Progress, Done) and uses Work-In-Progress (WIP) limits to keep flow smooth.
* **Scrum vs. Kanban:**

| Aspect | Scrum | Kanban |
|---|---|---|
| **Cadence / Iterations** | Time-boxed sprints (typically 1–4 weeks) | Continuous flow with no fixed sprint length |
| **WIP Limits** | Managed per sprint scope/capacity | Explicit Work-In-Progress limits per column |
| **Roles & Ceremonies** | Defined events (stand-up, review, retrospective) | Fewer prescribed ceremonies; focuses on board flow |

---

### 1.4 Active Directory, IAM and LDAP
*Sources used: Cloudflare (What is identity and access management (IAM)?, What is LDAP?), Microsoft Learn (Active Directory Domain Services overview).*

* **IAM:** Identity and Access Management is the framework of policies, identities, and controls used to manage digital access. It answers **"Who are you?"** (authentication) and **"What may you do?"** (authorization).
* **LDAP:** Lightweight Directory Access Protocol is a protocol used to query, authenticate against, and update directory services over a network.
* **Active Directory:** Active Directory is a Microsoft directory service that stores and manages identities and resources—such as users, groups, permissions, and computers—within an organization.
* **How they relate:** IAM is the overarching security and access-control concept. Active Directory is a concrete directory implementation that stores user and machine identities and group memberships. LDAP is one standard protocol that applications and services can use to look up and verify those directory entries.

---

## Part 2: Spring Boot Change

### Step A: `server.port` and `server.address` in `application.properties`

Configured `server.port=8081` (so the server listens on `8081` instead of `8080`) and tested each `server.address` setting one at a time after restarting the application:

| # | `server.address` Tested | What I Tested & What Happened | Explanation (Using Part 1 Networking Concepts) |
|---|---|---|---|
| 1 | `127.0.0.1` | Tested from my laptop using `127.0.0.1:8081`; ran cleanly and responded as expected. | Binding to `127.0.0.1` restricts the server to the loopback interface on my own machine. |
| 2 | `localhost` | Tested from my laptop; ran cleanly and responded the same way as `127.0.0.1`. | `localhost` resolves locally to loopback on the machine, keeping requests local to my laptop. |
| 3 | Private IP 192.168.68.55 | Tested using my private IPv4 address on port `8081`; ran cleanly and responded the same way as `127.0.0.1`. | Binding to the DHCP-assigned private IPv4 address listens on that specific network interface rather than loopback alone. |
| 4 | `0.0.0.0` | Tested locally and responded the same way as `127.0.0.1`; could not test from a colleague's device because no partners were on the same network. | `0.0.0.0` binds across all available IPv4 interfaces on the host, while same-network colleague testing was not possible with no peers on the same network. |

* **Recommended setting for colleagues on the network:** `0.0.0.0` (with `server.port=8081`), because it listens across all available IPv4 interfaces rather than restricting connections to `127.0.0.1` loopback alone.

---

### Step B: Linking `Feedback` to `Customer` via `customerId`

* **Model & Endpoints:** Added `customerId` to `Feedback` so `POST /feedback` accepts `customerId` along with `id` and `message`, and `GET /feedback` and `GET /feedback/{id}` include `customerId` in the returned JSON.
* **Validation choice for unknown `customerId`:** Returned **`404 Not Found`** (`Customer <id> not found`) when the referenced customer does not exist in memory.
* **Service & Storage:** Kept validation and customer lookup in the service layer with a thin controller and in-memory storage.

---

### Blockers & Learnings

* **Blockers:** Could not test reaching the server from another device on the same network with `0.0.0.0` because no colleagues/partners were on the same network; no application errors occurred.
* **One thing harder than expected:** Making sure `CustomerService` and `CustomerController` shared the same backing customer data and rebuilding cleanly after code changes so the latest compiled classes were running.