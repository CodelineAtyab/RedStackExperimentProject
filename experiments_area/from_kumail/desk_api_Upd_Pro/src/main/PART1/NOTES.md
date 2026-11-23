Networking Basics:

Private vs Public IP. A private IP (e.g. `192.168.1.42`) works only inside a local network. A public IP identifies the network on the internet.

Static vs Dynamic IP. A static IP stays fixed; a dynamic IP can change. My router assigns my laptop a dynamic IP via DHCP.

DHCP server vs client. The server assigns IPs automatically. My router is the server, my laptop is the client.

Who can reach my server?
- 127.0.0.1 / localhost: only my laptop.
- Private IP: devices that can reach that network interface.
- 0.0.0.0: all interfaces, so others can connect via my private IP (if the firewall allows).

Colleague can't use my localhost. localhost points to whoever makes the request, so they must use my laptop's private IP.

Dynamic IP problem. It can change after reconnecting, breaking the link I shared.

 1.2 SDLC:

Requirement gathering and planning. Find out what users need, then plan tasks, time, and resources.

SRS. Describes what the software must do; usually written by a business analyst with stakeholders.

SDS/SDD. Describes how the software will be built. SRS is the "what", SDS is the "how".

SLA. An agreement on service quality, e.g. 99.9% uptime.

Phases. Design (plan), Develop (code), Test (find errors), Deploy (release), Maintain (fix and update).

This issue. Development (configuring Spring Boot) and Testing (checking other devices can connect).

1.3 Agile, Scrum, Kanban:

Agile. Building software in small steps with frequent feedback.

Scrum. An Agile framework using sprints, with a backlog, daily stand-up, sprint review, and retrospective.

Kanban. A board (To Do, In Progress, Done) with WIP limits on concurrent tasks.

Difference. Scrum uses fixed sprints and set meetings; Kanban is a continuous flow with flexible meetings.

1.4 AD, IAM, LDAP:

IAM. Manages who users are and what they can access.

LDAP. A protocol for searching and accessing directory information.

Active Directory. Microsoft's service for managing users, groups, and computers.

Relation. IAM is the overall idea, Active Directory stores the identity data, and LDAP lets applications talk to it.

Sources:

Cloudflare, Wikipedia, GeeksforGeeks, Atlassian, Scrum Guide, Microsoft Learn