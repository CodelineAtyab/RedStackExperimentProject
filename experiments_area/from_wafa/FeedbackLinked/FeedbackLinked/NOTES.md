
#1.1 Networking Basics
- Private IP: `192.168.x.x` stay inside local networks.
- Public IP:globally unique on the internet.
- Static IP: stay fixed 
- dynamic IP: can change (routers usually assign dynamic IPs to laptop which can shift after a reconnect).
- DHCP: Server assigns IP settings (router) - client requests them via DORA (laptop).
- `127.0.0.1`  : Only your laptop.
- `localhost`:  Only your laptop.
- Private IP (`192.168.1.42`) :  Devices on that network.
- `0.0.0.0` : Any reachable device across interfaces . 
- Why `localhost:8081` fails for a colleague: Each device's `localhost` points to itself not your laptop.
- Why dynamic private IP breaks shared links:reconnect can assign a new IP via DHCP.

#1.2 SDLC
- Requirement Gathering & Planning:Collecting needs and planning scope and resources.
- SRS:Lists functional/non-functional requirements written by analysts owners with stakeholders.
- SDS:Covers how to build it (architecture, components, APIs).
- SLA: Service commitment.
- Phases:Design (plan architecture), Develop(write code), Test(verify & find bugs), Deploy (release), Maintain(monitor & fix).
- Current Issue:Develop / Test phase; requirements come from the issue and acceptance criteria.

#1.3 Agile, Scrum & Kanban
- Agile: Iterative delivery with frequent feedback and adaptation.
- Scrum Parts:Backlog, sprint, planning, daily stand-up, review, retrospective.
- Kanban:Visual board with columns and Work-In-Progress (WIP) limits.
- Scrum vs. Kanban:

Aspect | Scrum | Kanban
Cadence | Fixed sprints | Continuous flow
Ceremonies | Defined roles & sprint events | Minimal ceremonies; focus on flow
Scope | Stable within a sprint | Continuous reprioritization

#1.4 AD, IAM & LDAP
- IAM: Manages identity and access  - (authentication) and  (authorization).
- LDAP:Protocol for querying and checking directory entries.
- Active Directory:Microsoft directory storing users, groups, and computers.
- How They Relate: IAM is the concept-Active Directory is the directory store and LDAP is a protocol used to access it.



#Part 2: Spring Boot Notes

- `127.0.0.1` - `127.0.0.1:8081`, `localhost:8081` Result: Listens only on loopback.
  -`localhost` -`localhost:8081` Result: Listens on local host interface.
  -`<private-ip>` - `<private-ip>:8081` -`localhost:8081` Result: Binds to that specific IP interface.
  -`0.0.0.0` - `localhost:8081`- `<private-ip>:8081`, colleague Result: Listens on all interfaces (if firewall allows).

- Recommended for colleagues: `server.address=0.0.0.0` (with chosen `server.port`) so other devices on the network can connect when the firewall permits.

#Unknown `customerId`
- Return `404 Not Found` or`400 Bad Request` with `"Customer not found"` when `customerId` does not exist.

#Blockers & Lessons Learned
- No blockers.
- Validating `customerId` across services cleanly and checking network reachability across `server.address` values.