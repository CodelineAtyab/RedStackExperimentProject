# LimitedCrewMission — Part B UML Diagram

```mermaid
classDiagram
    class Spaceship {
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
    class Astronaut
    Spaceship *-- LifeSupport : owns
    Spaceship o-- Astronaut : holds