## Part 1 – Research and Learning

### 1.1 Networking Basics

#### Private IP and Public IP
An IP address identifies a device on a network.
- **Private IP:** Used inside a local network, such as home Wi-Fi. Example: `192.168.1.10`.
- **Public IP:** Used to identify a network on the internet. It can be reached from outside the local network depending on network and firewall settings.

#### Static IP and Dynamic IP
- **Static IP:** An IP address that normally stays the same.
- **Dynamic IP:** An IP address assigned automatically and can change.
A home router usually gives a laptop a dynamic private IP using DHCP. If the IP changes, an old link to a server may stop working.

#### DHCP Server and DHCP Client
- **DHCP Server:** Automatically gives devices their IP addresses and network settings.
- **DHCP Client:** A device that requests these settings.
In a home network, the router is usually the DHCP server, and the laptop is the DHCP client.

#### Understanding server.address
The `server.address` property controls which network address the Spring Boot application listens on.
- **127.0.0.1:** Allows access from the same computer.
- **localhost:** Refers to the same computer.
- **Private IP:** Allows the application to listen on a specific network interface.
- **0.0.0.0:** Allows the application to listen on all available IPv4 network interfaces.

A colleague cannot use `localhost` to access my application because it refers to their own computer. They need to use my laptop's private IP address and the application port.
A dynamic private IP can make a shared link unreliable because the IP address may change after reconnecting to Wi-Fi or restarting the laptop.

### 1.2 Software Development Life Cycle (SDLC)

#### What is SDLC?
SDLC stands for Software Development Life Cycle. It is a process used to plan, design, develop, test, deploy, and maintain software.

#### Requirement Gathering and Planning
This stage is about understanding what the users need and planning how to build the software.

#### SRS – Software Requirements Specification
An SRS document describes what the software should do. It includes functional and non-functional requirements. It is usually prepared by a business analyst or requirements engineer with input from stakeholders.

#### SDS / SDD – Software Design Specification
An SDS or SDD explains how the software will be designed and built. It can include the system structure, classes, components, and APIs.

#### SLA – Service Level Agreement
An SLA is an agreement between a service provider and a customer about the expected service level.
Example: The service provider promises 99.9% availability each month.

#### Main SDLC Phases
1. **Planning:** Decide the project goals and schedule.
2. **Requirement Analysis:** Understand and document user needs.
3. **Design:** Plan the system structure and components.
4. **Development:** Write the code.
5. **Testing:** Check that the application works correctly.
6. **Deployment:** Make the application available to users.
7. **Maintenance:** Fix problems and improve the application.

#### Which SDLC Phase Is This Task In?
This task mainly involves development and testing. I configured the Spring Boot server, updated the models and services, and tested the API using Postman. The requirements came from the task description and user story.

### 1.3 Agile, Scrum, and Kanban

#### What is Agile?
Agile is an approach to software development where work is completed in small steps. Teams receive feedback and make changes when needed.

#### Scrum
Scrum is an Agile framework that organizes work into short periods called sprints.
Main Scrum parts:
- **Sprint:** A short period for completing selected work.
- **Product Backlog:** A list of tasks and features.
- **Daily Stand-up:** A short meeting to discuss progress and problems.
- **Sprint Review:** A meeting to show completed work and get feedback.
- **Sprint Retrospective:** A meeting to discuss what went well and what can improve.

#### Kanban
Kanban is a method for organizing and tracking work using a board.
A Kanban board usually has columns such as To Do, In Progress, and Done. A Work in Progress (WIP) limit controls how many tasks can be worked on at the same time.

#### Scrum vs Kanban
Scrum divides work into short periods called sprints, while Kanban manages work continuously. 
Scrum has planned meetings and roles, while Kanban uses a board to track tasks. 
Both help teams organize their work and track progress.


### 1.4 Active Directory, IAM, and LDAP

#### IAM – Identity and Access Management
IAM manages user identities and controls access to systems. It answers two questions:
- Who are you?
- What are you allowed to access?

#### LDAP – Lightweight Directory Access Protocol
LDAP is a protocol used to access information stored in a directory, such as users and groups.

#### Active Directory
Active Directory is a Microsoft directory service. It stores and manages users, groups, computers, and other network resources.

#### How Are They Related?
IAM is the general idea of managing identities and access. Active Directory is a Microsoft service that stores user and group information. LDAP is a protocol that applications can use to access directory information. They can work together to manage and check user access.

-------------------------------------------------------------

## Part 2 – Spring Boot Implementation

### 2.1 Project Information
**Project Name:** FeedbackLinkedToCustomer
**Technologies:**
- Java
- Spring Boot
- Maven
- REST API
- Postman

### 2.2 Server Configuration
I updated `src/main/resources/application.properties` with these settings:

```properties
spring.application.name=FeedbackLinkedToCustomer
server.port=8081
server.address=0.0.0.0
```
The application uses port `8081` instead of the default port `8080`.
I used `0.0.0.0` so the application listens on all available IPv4 network interfaces.

### 2.3 Server Address Testing
I tested the four server address values by changing `server.address` and restarting the application.
- **127.0.0.1:** Used to access the application from my own computer.
- **localhost:** Also refers to my own computer.
- **Private IP:** Used to access the application through my laptop's network address.
- **0.0.0.0:** Allows the application to listen on all available IPv4 network interfaces.
For another device on the same Wi-Fi, the application should be accessed using the laptop's private IP and port `8081`, if the firewall allows the connection.
**Final configuration:** I used `server.address=0.0.0.0` because it allows the server to listen on all available network interfaces.
**Actual test results:** I will record the result of each address test and the test from another device here.

### 2.4 Customer and Feedback Models
The application has two models:
**Customer**
- `id`
- `name`
**Feedback**
- `id`
- `message`
- `customerId`

I added `customerId` to the Feedback model to connect each feedback to a customer. Both IDs use the `String` data type.

### 2.5 Service Implementation
I used two services:
- **CustomerService:** Manages the customer list and searches for customers by ID.
- **FeedbackService:** Manages feedback and checks whether the customer exists before saving feedback.
I used `CustomerService` inside `FeedbackService` to find the customer using `customerId`.
If the customer does not exist, `FeedbackService` throws an `IllegalArgumentException` with a clear message, such as `Customer C999 not found`.

### 2.6 Controller Implementation
I used two controllers:
- **CustomerController:** Handles customer API requests.
- **FeedbackController:** Handles feedback API requests.
The controllers call the services to perform the operations. In `FeedbackController`, I handled the `IllegalArgumentException` and returned `400 Bad Request` when the customer was not found.

### 2.7 Postman Testing
I used Postman to test the following requests:
1. `POST /customers` – Create a customer. Expected: `201 Created`.
2. `POST /feedback` – Create feedback with an existing customer ID. Expected: `201 Created`.
3. `GET /feedback` – Get all feedback. Expected: `200 OK`.
4. `GET /feedback/{id}` – Get feedback by ID. Expected: `200 OK`.
5. `POST /feedback` – Create feedback with an unknown customer ID. Expected: `400 Bad Request`.
The GET responses include the `customerId` field.
For an unknown customer ID, I chose `400 Bad Request` because the request contains a customer ID that does not exist.

### 2.8 Screenshots
- `Create-Customer.png`
- `Create-Feedback.png`
- `Get-All-Feedback.png`
- `Get-Feedback-By-ID.png`
- `Post-Feedback-Unknown-Customer.png`

## Part 3 – Difficulties and Learning

### What I Learned
- How to configure the Spring Boot server address and port.
- The difference between localhost, private IP, and `0.0.0.0`.
- How to connect feedback to a customer using `customerId`.
- How to use `CustomerService` inside `FeedbackService`.
- How to check whether a customer exists before saving feedback.
- How to test REST API requests and status codes using Postman.

### Blockers

No blockers.

## Sources

1. Cloudflare – What is an IP Address?  
   https://www.cloudflare.com/learning/network-layer/what-is-an-ip-address/

2. Microsoft Learn – DHCP  
   https://learn.microsoft.com/en-us/windows-server/networking/technologies/dhcp/dhcp-top

3. Atlassian – Software Development Life Cycle  
   https://www.atlassian.com/agile/software-development

4. Atlassian – Scrum  
   https://www.atlassian.com/agile/scrum

5. Atlassian – Kanban  
   https://www.atlassian.com/agile/kanban

6. Scrum Guide  
   https://scrumguides.org/

7. Microsoft Learn – Active Directory Domain Services  
   https://learn.microsoft.com/en-us/windows-server/identity/ad-ds/get-started/virtual-dc/active-directory-domain-services-overview

8. Spring Boot Documentation – Application Properties  
   https://docs.spring.io/spring-boot/appendix/application-properties/index.html