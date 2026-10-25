## About This Project

**RedStackExperimentProject** is a collaborative Java learning sandbox for Team Red Stack. It gives every team member their own personal package to experiment, practice, and grow their Java skills — sprint by sprint.

### Tech Stack
- **Language:** Java 17
- **Build Tool:** Maven
- **Entry Point:** `org.example.litedesk.Main`

### Project Structure

All member work lives under `experiments_area`, inside a directory named after the contributor: `from_<name>` (e.g. `from_atyab`, `from_ishaq`). Inside your own directory, create **one directory per exercise, sprint mini project, or Maven project**. Do not leave files loose in `experiments_area/from_<name>/`.

#### Allowed layouts

**1. Practice folder** — for standalone `.java` files (CodingBat, exercises, small programs):

```
experiments_area/
└── from_<name>/
    └── <practice-topic>/          # e.g. CodingBat, HelloWorld, project1
        ├── HelloWorld.java
        └── Warmup1.java
```

All `.java` files directly inside that folder are compiled together with `javac`. Files that reference each other must live in the same folder. Create a separate folder per exercise so class names don't collide.

**2. Maven project** — for anything built with Maven:

```
experiments_area/
└── from_<name>/
    └── <project-name>/           # e.g. demo, WeatherDesk
        ├── pom.xml
        ├── mvnw
        └── src/
            ├── main/java/...
            └── test/java/...
```

#### Not allowed

| Location | Why |
|----------|-----|
| `experiments_area/from_<name>/*.java` | Loose files in your member root; put them in a practice folder |
| `experiments_area/from_<name>/pom.xml` | A Maven project must have its own directory |
| `experiments_area/*.java`, `experiments_area/pom.xml` | Files belong inside a member directory |

#### What CI checks on every pull request

- **Changed Maven projects:** `mvn clean test-compile` with **Amazon Corretto JDK 17**.
- **Changed practice folders:** `javac --release 17` on every `.java` file in that folder.
- Any syntax or compilation error fails the PR.
- Any file in a forbidden location fails the **Check folder layout** job, with an annotation on the offending file.

Java version for all builds is **Amazon Corretto OpenJDK 17**; use that locally to match CI.

### What's Inside

| Area | Examples |
|------|---------|
| **Data Structures** | Stack, Queue, HashMap implementations |
| **Algorithms** | Bubble Sort, Selection Sort, Recursion |
| **Pattern Printing** | Pyramids, Staircases, Number challenges |
| **Mini Applications** | ERP systems, Customer Complaint Manager, Maze Game Bot |
| **Menus & CLI Apps** | Multi-role menus (Customer / Admin / Support Staff) |

---

## Contribution Guidelines

### Step 1
Copy the ticket ID from GitHub issues.

### Step 2
Goto the repo and git status (Make sure you are on main branch)

### Step 3
git pull (Make sure you are up to date)

### Step 4
Create a new branch (replica of main) from the main branch and check it out (switch to the new branch)
Example: `git branch feature/<ticket-id>-ticket-title`

### Step 5
Checkout the new branch using git checkout 
Example: `git checkout feature/<ticket-id>-ticket-title`

### Step 6
Now do your task

### Step 7
Push your changes (branch) to github by doing:
```
git add *
git commit -m "some-message"
git push 
```
NOTE: (if upstream bracnh is not there then run the --set-upstream command given by git only once)

### Step 8
Got GitHub and click on "Compare & pull request"

### Step 9
Add Reviewers and Click on "Create pull request"

### Step 10
Move the ticket to "Ready for Review"

### Step 11
Wait for atleast 3 approvals from the team

### Step 12
After approvals, Please "SQUASH MERGE"

### Step 13
Go back to the main branch
```
git checkout main
```

### Step 14
Pull the latest chages by doing
```
git pull
```

### Step 15
Repeat the same steps from Step 1 for a new task

