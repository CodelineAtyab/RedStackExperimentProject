
#Round 1 (My Client / Partner Server)
-Server URL test ("http://192.168.100.105:8080/profile?name=Wafa")
-Connected successfully and print the partner's name and list of favourites 

#Round 2 (Partner Client / My Server)
-My Server URL: ("http://192.168.100.70:8080/profile")
-Partner connected to my Spring Boot server and received my JSON.

#Blockers & Lessons Learned
paste the exact error message if you hit a firewall/network issue
Harder than expected:** Understanding how Spring Boot automatically serializes Java 
objects/maps to JSON without needing manual JSON formatting and getting the local IP address/firewall configured across two laptops.