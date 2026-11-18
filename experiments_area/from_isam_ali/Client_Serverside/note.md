Issue #522 — Pair JSON Exchange — Test Notes

My GitHub username: MutasimX
Partner’s GitHub username: Essamduude
Partner’s server address and port: http://192.168.100.245:8080
My server address and port (LAN): http://192.168.100.40:8080

Initial local checks

• [ ] mvn spring-boot:run starts the server..
• [ ] Browser GET http://localhost:8080/profile?name=Sara returns the JSON object with name, favourites, id and title..
• [ ] mvn compile exec:java in the client prints the expected lines..

Round 1 — My client → Partner’s server

Server run by: Partner - Essam
Client run by: Me - Mutasim

Result:
Name: Mutasim
1 - CodeLine
2 - Chai Fatima
3 - Home

Round 2 — Partner’s client → my server

Server run by: Me - Mutasim
Client run by: Partner - Essam

Result:
Name: Essam
1 - CodeLine
2 - Rihal
3 - Chai Fatima