# AGENTS.md — desk-api

## How you must respond (most important rule)

This project is a **learning/experiment** project. The owner wants to write the code, not have it written for them.

**Default mode: RECOMMEND, do not implement.**

When I ask about something (a feature, a bug, a refactor, "how do I…", "what's wrong with…"), respond with a **numbered, step-by-step plan of recommended changes** and stop there:

1. Do **not** edit, create, or delete files unless I explicitly say "implement it", "apply it", "make the change", "go ahead", or similar.
2. Do **not** run commands that change the repo (no `git commit`, `git checkout`, formatters, generators) in this mode.
3. Read-only investigation is always fine: reading files, searching, `git status`/`git diff`/`git log`, and running the build or tests to understand the current state.
4. Use the format below for every recommendation.

### Required shape of a recommendation

- **What's wrong / what's missing** — a short diagnosis, citing the actual file paths and line numbers.
- **Step 1, Step 2, …** — small, ordered, independently verifiable steps. Each step states:
  - the file to change (full path),
  - what exactly to add/change/remove (a short code snippet is fine),
  - why it matters.
- **Verify** — how to check it worked (command to run, URL to hit, expected result).
- **Options / trade-offs** — if there is more than one reasonable approach, name them and say which you'd pick and why.
- **End with a question** — e.g. "Want me to implement step 1?" Do not proceed on your own.

Keep the plan minimal: prefer the smallest change that solves the problem, and don't bundle unrelated improvements into it. Mention them separately as "optional follow-ups" instead.

If I ask "why" or "explain", explain — don't produce a change plan.

Only switch to implementation mode when I clearly authorize it. Even then, make the changes **one step at a time**, tell me what you changed, and stop before the next step unless I say continue.

## Project facts

- **Stack:** Spring Boot `4.1.2`, Java 17, Maven (use the wrapper: `./mvnw`).
- **Web starter:** `spring-boot-starter-webmvc` (Boot 4 naming — not `-web`). Test starter: `spring-boot-starter-webmvc-test`.
- **Base package:** `com.reddesk.desk_api`
- **Build file:** `pom.xml`
- **Entry point:** `src/main/java/com/reddesk/desk_api/DeskApiApplication.java`

### Current layout (small — keep it this way until asked)

```
src/main/java/com/reddesk/desk_api/
├── DeskApiApplication.java
├── controller/CustomerController.java   # @RestController, /customers
└── model/Customer.java                  # POJO with public fields id, name
src/main/resources/application.properties
src/test/java/com/reddesk/desk_api/DeskApiApplicationTests.java
```

### Current state to keep in mind

- Data is stored **in memory** in an `ArrayList` inside `CustomerController` — no database, no service layer, no repository yet.
- `Customer` uses public fields (`id`, `name`) — no getters/setters, no validation.
- `getSpecificCustomer` calls `.findFirst().get()` — throws `NoSuchElementException` (HTTP 500) when the id doesn't exist.
- No error handling, no DTOs, no persistence, no API docs.
- Use these as context for recommendations, but **do not "fix" them unprompted**.

## Conventions to follow when recommending code

- Package-by-layer: `controller`, `model`, and (when introduced) `service`, `repository`, `dto`, `exception`, `config`.
- Constructor injection for beans — no field `@Autowired`.
- `@RestController` + `@RequestMapping` at class level, method-level mapping annotations for verbs.
- Prefer `ResponseEntity<>` when a non-200 status is possible.
- Java 17 features are fine (`record`, `var`, `switch` expressions, text blocks).
- Tests go under `src/test/java/...` mirroring the main package; use `@WebMvcTest` for controllers.
- Match the existing style: 4-space indent, `com.reddesk.desk_api.*` imports.

## Useful commands

```bash
./mvnw spring-boot:run          # run the app (default port 8080)
./mvnw test                     # run tests
./mvnw clean package            # build the jar into target/
curl localhost:8080/customers   # exercise the API
```

Always use `./mvnw`, not a system `mvn`.

## Scope

- Work only inside `desk-api/`. The surrounding repo (`experiments_area/from_atyab/…`) is shared training material — do not edit it.
- Do not add dependencies to `pom.xml` as part of a recommendation plan without calling it out as its own step with a justification.
