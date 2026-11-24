1) put: update the object
2) delete: delete the object
3) post: create the object
4) get: show the object

if an id is missing teh server return 404 and id does not exist

no blockers
***
Issue #550:

Design Choices
1) Missing IDs ine (get, put, delete): show 404 Not Found.
2) Unknown customerId on POST /feedback: 400 Bad Request when customerId is missing or does not exist in listOfCustomers.
3) Deleting a customer with existing feedback: when DELETE /customers/{id} runs, it loops backward through FeedbackController.listOfFeedback and removes all feedback tied to that customer before deleting the customer.
4) Customer feedback endpoint path: implemented GET /customers/{id}/feedback inside CustomerController.

What I Copied vs. What I Wrote Myself:

Copied from trainer: he base Customer model structure and initial CustomerController setup

Written by me: Everything else.


no Blockers

Postman test:

***
Issue #594:

Service: It's a layer in the app that hold the logic of the app.

we sue it to keep the code organized, Makes code reusable and Easier to test and fix.

@Autowired is a tag that connect the service to the controller without needing to create the connection ourselves

***
Issue #595:

201 vs 202:
1) 201 is Created while 202 is Accepted.
2) 201 Created something new. While 202 Accepted the request, work still to do.
3) 201 give back The new item or where to find it. While 202 gives back The status of the request and where to check it.
4) Typical use of 201 is A new account, order or upload. While 202 is Long tasks handled in the background.
5) source: https://www.one.com/en-gb/academy/http-200/

ResponseEntity: it's a class of full HTTP response,that give thr controller complete control of the status code. so it allow the controller to respond with 202 or 200 or 404.


• filter tests each stream element against a boolean condition and keeps only the ones that match.

• map applies a function to each stream element to transform it into a new value or type

No Blockers.


***
Issue #645: 


Part 1:

* Networking basics:
1) A private IP address (such as 192.168.0.0 to 192.168.255.255) is used exclusively inside a local network like home Wi-Fi so devices can talk to each other, whereas a public IP address (such as 8.8.8.0 to 8.8.8.255) is globally unique and assigned by the internet provider so the router can send and receive data across the wider internet.
2) A static IP address is permanently fixed to a device while a dynamic IP address is temporary and automatically reassigned over time, which is what home router usually gives the laptop and why it matters for a server—if the laptop's IP changes after a reboot or reconnection, anyone trying to reach that server using the old IP link will fail to connect.
3) A DHCP server automatically assigns available IP addresses and network settings to devices that join the network, while a DHCP client requests and receives that temporary IP address so it can communicate on the network. router is the server and laptop is the client.
4) answered in part 2.
5) Because Localhost is only for the local pc and won't allow outside connections.
6) because the ip address will change.
* SDLC:
1) requirement gathering and planning make up the first phase where the team collects what users need from the software and defines the project's scope, timeline, resources, and risks before writing any code.
2) An SRS (Software Requirements Specification) is a detailed document usually written by a business analyst or systems analyst (with input from the client and lead developers) that describes the software's purpose, exact features it must perform, performance rules, and any technical limits before coding begins.
3) While the SRS explains what the software must do for the user, the SDS (Software Design Specification) is created afterward by software architects or senior developers to explain how the system will actually be built under the hood, detailing its architecture, database tables, classes, and API structure.
4) An SLA (Service Level Agreement) is a formal promise between a service provider and a customer that defines the exact quality and speed of service to expect, such as guaranteeing 99.9% server uptime or promising to respond to critical bug reports within 2 hours.
5) * Design: Architects plan how the system will be built, mapping out its software architecture, database structure, and user interfaces.

   * Develop: Programmers write the actual source code and build the features based on the design blueprints.

    * Test: QA engineers and developers run checks to find and fix bugs, ensuring the software works properly and meets all requirements.

    * Deploy: The finished, tested software is released to a live server so real users can access and use it.

    * Maintain: The team monitors the live system, fixes new issues, and releases updates or improvements over time.
6) This issue happens in Develop (and Test, via Postman) phase of the SDLC, while the requirement gathering happened beforehand when Mr.Atyab wrote the user story, task breakdown, and acceptance criteria in this GitHub issue.

* Agile, Scrum and Kanban:
1) Agile is a flexible approach to building software in small, rapid cycles so teams can deliver working updates early and easily adapt to changing user feedback.
2) Scrum organizes work into fixed time-boxed cycles called sprints (usually 1–4 weeks) where the team pulls tasks from a prioritized backlog, checks progress in quick daily stand-ups, demonstrates finished work in a sprint review, and discusses how to improve their teamwork in a sprint retrospective.
3) Kanban is a visual workflow method that uses a board divided into columns (like To Do, In Progress, and Done) to track tasks continuously while setting a strict Work in Progress (WIP) limit on how many tasks can be active at once so the team finishes current work before starting anything new.
4) | Feature | Scrum | Kanban |
   | --- | --- | --- |
   | **Work Schedule** | Uses fixed time cycles called **sprints** (e.g., 2 weeks) to plan and deliver batches of work. | Uses a **continuous flow** where tasks are pulled and delivered anytime without fixed cycles. |
   | **Mid-Sprint Changes** | Changes to the active sprint's tasks are strongly discouraged once the sprint starts. | New tasks can be added or reprioritized at any time as long as there is open capacity. |
   | **Task Limits** | Limits work by committing to a set list of tasks before a sprint begins. | Limits work by capping how many tasks can sit in each column at once (**WIP limits**). |

* Active Directory, IAM and LDAP:
1) IAM (Identity and Access Management) is a security system that makes sure only the right people can access a company's apps and data by answering "Who are you?" (verifying your identity, known as authentication) and "What may you do?" (checking your permissions, known as authorization).
2) LDAP (Lightweight Directory Access Protocol) is a standard communication protocol—a shared language—that allows applications and systems to query, look up, and verify user accounts and passwords stored inside a central directory service.
3) Active Directory (AD) is a Microsoft directory service used by organizations to store information about all their users, computers, and groups in one central database so administrators can manage logins and security permissions across the entire company network.
4) IAM is the overall security framework for managing digital identities and controlling who has permission to access specific resources. Active Directory is a specific Microsoft software product that puts IAM into practice by storing all of a company's users, groups, and computers in a central database. LDAP is the standard communication protocol (or language) that applications use to query Active Directory over the network to look up user details and check login credentials. Together, they work as a team: IAM defines the security goal, Active Directory holds the data, and LDAP connects apps to that data.

* sources:

1.1 Networking Basics
* [Cloudflare Learning Center: What is an IP address?](https://www.cloudflare.com/learning/dns/glossary/what-is-my-ip-address/)
* [Cloudflare Learning Center: What is a private IP address?](https://www.cloudflare.com/learning/network-layer/what-is-a-private-ip-address/)
* [Cloudflare Learning Center: What is DHCP?](https://www.cloudflare.com/learning/network-layer/what-is-dhcp/)
* [Wikipedia: localhost](https://en.wikipedia.org/wiki/Localhost)
* [Wikipedia: 0.0.0.0](https://en.wikipedia.org/wiki/0.0.0.0)

1.2 SDLC
* [Atlassian: What is SDLC?](https://www.atlassian.com/agile/software-development/sdlc)
* [GeeksforGeeks: Software Requirement Specification (SRS) Document](https://www.geeksforgeeks.org/software-engineering-software-requirement-specification-srs-document/)

* [Atlassian: What is an SLA?](https://www.atlassian.com/itsm/service-request-management/slas)

 1.3 Agile, Scrum and Kanban
* [Atlassian: Agile Scrum vs Kanban](https://www.atlassian.com/agile/kanban/kanban-vs-scrum)
* [The Scrum Guide](https://scrumguides.org/scrum-guide.html)

 1.4 Active Directory, IAM and LDAP
* [Cloudflare Learning Center: What is identity and access management (IAM)?](https://www.cloudflare.com/learning/access-management/what-is-identity-and-access-management/)
* [Cloudflare Learning Center: What is LDAP?](https://www.cloudflare.com/learning/access-management/what-is-ldap/)
* [Microsoft Learn: Active Directory Domain Services Overview](https://learn.microsoft.com/en-us/windows-server/identity/ad-ds/get-started/virtual-dc/active-directory-domain-services-overview)

***
Part 2:
1) 127.0.0.1: Worked with (http://127.0.0.1:8081) and (http://localhost:8081) but Connection refused on my private IP (http://192.168.100.130:8081) and from other devices. because 127.0.0.1 binds the server strictly to the internal IP, so only traffic originating from inside my own PC can reach it.
2) localhost: Worked with http://localhost:8081 and (http://127.0.0.1:8081), but Connection refused on my private IP and from other devices on the Wi-Fi. Because localhost keeps the server isolated to my PC and invisible to the outside network.
3) Private IP (192.168.100.130): Worked with (http://192.168.100.130:8081) from my pc and from another device on the same Wi-Fi, but Connection refused when opening http://localhost:8081 or 127.0.0.1. Because its Binding the IP specifically to the Wi-Fi adapter's private IP means the server only listens on that local network interface.
4) 0.0.0.0: Worked with localhost, 127.0.0.1, my private IP (192.168.100.130), and from another device on the same Wi-Fi using (http://192.168.100.130:8081). Because 0.0.0.0 is a wildcard address that tells the server to listen on all available network interfaces at once.

Recommended setting: server.address=0.0.0.0 Because It allows me to keep testing locally using localhost while also letting colleagues on the same Wi-Fi network connect using my private IP address (and it avoids app startup crashes if my DHCP router assigns me a new private IP later).

Unknown customerId status choice:
I chose 400 Bad Request because the client provided an invalid customer ID reference in the request payload that does not exist in the system, so the request is invalid and cannot be processed.

No Blockers.

