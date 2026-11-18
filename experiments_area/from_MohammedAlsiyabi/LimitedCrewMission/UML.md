# UML: LimitedCrewMission

```mermaid
classDiagram
    class Astronaut {
        -String name
        -int MAX_ASTRONAUTS$
        -int recruitedCount$
        -Astronaut(String name)
        +recruit(String name)$ Astronaut
        +getRecruitedCount()$ int
        +getName() String
    }
    class Spaceship {
        -int SEATS$
        -String name
        -LifeSupport lifeSupport
        -ArrayList~Astronaut~ crew
        +Spaceship(String name)
        +boardCrew(Astronaut astronaut) void
        +printManifest() void
    }
    class LifeSupport {
        ~LifeSupport()
    }
    Spaceship "1" *-- "1" LifeSupport : owns
    Spaceship "1" o-- "0..3" Astronaut : holds
```


