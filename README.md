# chatApp
web Socket spring boot  thymeleaf  chatApp 
## Notable Technologies/Design Decisions
- Backend: Java 8 with Spring Boot
- Frontend: thymleaf , webjars ,jquery  
- Message Broker: spring boot message broker 
- Database: MySQL
- ORM: Hibernate
- WebSocket messaging protocol: Stomp
- WebSocket handler: Sock.js (with cross-browser fallbacks)
- Security: Spring Security



## Setup
1. Install system dependencies: latest versions (at the time of this writing) of Java 8 , MySQL
2. update application.properities  to set up database properities 
3. run application    
4. Visit [http://localhost:8082/](http://localhost:8080) 

## Notes
- register or create new account for you and some other users to test chat application .
- when you login you are directed to chat page 
- Chat messages are persisted to the database
- choose a friend and open chatRoom to  real time private chat  

