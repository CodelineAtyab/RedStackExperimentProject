# LimitedCrewMission — UML Diagrams

## Part A: Astronaut Class

```mermaid
classDiagram
    class Astronaut {
        -String name
        -int MAX_ASTRONAUTS$-int recruitedCount$
        -Astronaut(String name)
        +recruit(String name)$ Astronaut
        +getRecruitedCount()$ int
        +getName() String
    }


