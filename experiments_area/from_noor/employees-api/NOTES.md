
# Service Layer – Task #594

## What is a Service?
A service is a class where we put the logic of our application.
We use it so the controller doesn't have to do everything.

## What does @Autowired do?
@Autowired connects the service to the controller.
Spring creates the service object for us, so we don't need to use new.

## Refactored Resource
I worked on my Employees API from task #549.
I moved the employee list and CRUD operations from EmployeeController to EmployeeService.

## Testing
- GET all employees – Passed (200 OK)
- POST employee – Tested
- GET employee by ID – Passed (200 OK)
- PUT employee – Tested
- DELETE /employees/1 – 204 No Content
- DELETE /employees – 204 No Content

## Blockers
Maven was not recognized in my terminal (`zsh: command not found: mvn`), so I ran the Spring Boot application using IntelliJ IDEA.

The harder part was understanding how the controller calls the service using @Autowired.

---

## Task #645 - Feedback Linked to Customer

### Part 1 - Reading Assignment

#### 1.1 Networking Basics

**Private IP vs Public IP**

- A private IP is used inside a local network, like home Wi-Fi.
  Example range: 192.168.0.0 to 192.168.255.255.

- A public IP is used to communicate over the internet.
  Example range: 8.8.8.0 to 8.8.8.255.

**Static IP vs Dynamic IP**

A static IP stays the same, while a dynamic IP can change.

My home router usually gives my laptop a dynamic IP.
If the IP changes, other devices may not be able to connect to my server using the old address.

**DHCP Client and DHCP Server**

A DHCP server automatically gives IP addresses to devices on a network.
A DHCP client requests and receives an IP address.

My laptop is the DHCP client, and my home router acts as the DHCP server.

**Server Address**

- 127.0.0.1: Only my laptop can access the server.
- localhost: Only my laptop can access the server.
- Private IP: My laptop and other devices on the same network can access the server if allowed.
- 0.0.0.0: The server listens on all available IPv4 interfaces, allowing my laptop and other devices to access it if the network allows.

**Why can't my colleague access my server using localhost?**

Localhost refers to the device being used.
My colleague needs to use my private IP address instead of localhost to access my server, if the network and server allow it.

**Dynamic IP After Reboot**

My IP address may change after restarting my laptop.
If it changes, the old server link will no longer work, and I need to share the new IP address with my colleague.

---

#### 1.2 SDLC (Software Development Life Cycle)

**Requirement Gathering and Planning**

Before I start developing a project, I need to understand what the user wants and what the requirements are.
Then I plan how to complete the project.

**SRS (Software Requirements Specification)**

An SRS is a document that helps me understand what the system should do and what the requirements are.
It is usually written by a business analyst or the project team with the client.

**SDS (Software Design Specification)**

An SDS helps me understand how the system will be designed and developed.
The SRS explains what the system should do, while the SDS explains how it will be built.

**SLA (Service Level Agreement)**

An SLA is an agreement between the service provider and the customer about the expected level of service.
For example, the system should be available 99.9% of the time.

**SDLC Phases**

- Design: I plan how the system will be built.
- Development: I write the code and implement the requirements.
- Testing: I check if the system works correctly.
- Deployment: I make the system available for users.
- Maintenance: I fix problems and improve the system after deployment.

**Current SDLC Phase**

I am currently in the development phase because I am working on my Spring Boot project.
The requirements were provided by my trainer in the GitHub issue #645.

---

#### 1.3 Agile, Scrum and Kanban

**Agile**

Agile is a way of developing software step by step instead of completing everything at once.
It helps me improve my work based on feedback and adapt to changes during development.

**Scrum**

Scrum helps me organize my work into short periods called sprints.

The main parts of Scrum are:

- Sprint: A short period to complete planned tasks.
- Backlog: A list of tasks that need to be done.
- Daily Stand-up: A short daily meeting to discuss progress and blockers.
- Sprint Review: We review the work completed during the sprint.
- Retrospective: We discuss what went well and what we can improve.

**Kanban**

Kanban helps me organize and track my tasks using a board.
I can move my tasks between columns like To Do, In Progress, and Done.
It also helps me limit the number of tasks I work on at the same time.

**Scrum vs Kanban**

- Scrum uses sprints, while Kanban uses a continuous workflow.
- In Scrum, tasks are planned before each sprint, while in Kanban, tasks can be added when needed.
- Scrum has specific roles and meetings, while Kanban is more flexible.

---

#### 1.4 Active Directory, IAM and LDAP

**IAM (Identity and Access Management)**

IAM helps me manage user identities and control what users can access in a system.
It answers two questions: Who are you? And what are you allowed to do?

**LDAP (Lightweight Directory Access Protocol)**

LDAP is a protocol used to access and search for user information in a directory.
It can also help applications verify user login details.

**Active Directory (AD)**

Active Directory is a Microsoft directory service that stores information about users, groups, and computers.
It helps organizations manage users and control their access to resources.

**Relationship between IAM, LDAP and Active Directory**

IAM is used to manage user identities and access permissions.
Active Directory stores user information.
LDAP allows applications to access this information and verify users.

---

### References

**Networking Basics**
- https://www.cloudflare.com/learning/dns/glossary/what-is-my-ip-address/
- https://en.wikipedia.org/wiki/Localhost
- https://en.wikipedia.org/wiki/0.0.0.0

**SDLC**
- https://www.geeksforgeeks.org/software-engineering/software-development-life-cycle-sdlc/
- https://www.atlassian.com/itsm/service-request-management/slas

**Agile, Scrum and Kanban**
- https://www.atlassian.com/agile/kanban/kanban-vs-scrum
- https://scrumguides.org/scrum-guide.html

**Active Directory, IAM and LDAP**
- https://learn.microsoft.com/en-us/windows-server/identity/ad-ds/active-directory-domain-services
- https://learn.microsoft.com/en-us/entra/identity/domain-services/overview



### Part 2 - Spring Boot

#### Step A - application.properties

I changed the server port from 8080 to 8081 and tested the server addresses using Postman.

**Testing Results**
- 127.0.0.1: Both localhost and 127.0.0.1 worked (200 OK).
- localhost: Worked successfully (200 OK).
- 192.168.0.224: My private IP worked, but localhost returned a connection refused error.
- 0.0.0.0: Both localhost and my private IP worked (200 OK).

**Testing from another device**
I tested the connection from another device on the same Wi-Fi, and it worked successfully.

**Final Configuration**
I chose 0.0.0.0 and port 8081 because I want other devices on the same network to access my server.
Port 8080 returned 404 Not Found for /feedback.

#### Step B - Feedback Linked to Customer

I changed the IDs from int to String.
I created CustomerService and FeedbackService and moved the logic from the controllers to the services.
I checked if the customer exists before adding feedback.

**Testing Results**

- POST /customers – 201 Created.
- POST /feedback – 201 Created.
- GET /feedback/f1 – 200 OK.
- GET /feedback – 200 OK.
- Unknown customerId – 400 Bad Request.

All five tests passed, and the feedback responses included the customerId.
I chose 400 Bad Request because the customerId is invalid. The error message was "Customer not found".

**Blockers**

- Understanding how to connect FeedbackService with CustomerService using @Autowired.
- Returning the correct status code and error message when the customer does not exist.
- Receiving 404 Not Found when retrieving feedback. I fixed this by creating the feedback before testing the GET request.