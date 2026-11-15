# Limited Crew Mission

A small Java console program demonstrating astronaut recruitment limits and
spaceship crew capacity.

## How it works

- `Astronaut.recruit(name)` creates astronauts up to a shared limit of four.
  Further recruitment attempts return `null`.
- Each `Spaceship` creates a `LifeSupport` system and can board up to three
  astronauts.
- A ship that has reached capacity leaves additional astronauts behind.
- The demo shows that an astronaut object can be boarded onto another ship.

`Main` recruits five astronauts, boards them onto the *Falcon*, then boards
two of the same astronauts onto the *Comet*. It prints each ship's manifest
and the total number recruited.

## Run

From this directory, compile the Java files and run the main class:

```sh
javac *.java
java Main
```

Requires a JDK. The sources use the default package, so run these commands
from this directory.
