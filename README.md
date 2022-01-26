# spring-microservice

Demo microservice architecture with Spring ,Spring Cloud Gateway , Spring Cloud config server , Eureuka , keycloak and Docker.
Architecture : 

## Architecture 


## Install and run with docker
`docker-compose up --build`

## Configure Keycloak 
1. Go to http://localhost:8080/auth/admin/ and connect with admin/admin
2. Click on the clients menu from the left pane and choose spring-micro-gateway
3. On the credentials tab , click on regenerate Secret button to generate secret for the spring-micro-gateway Client .
4. Override the client-secret propertie under service api-gateway on the docker-compose.yml file
5. from the me,u , click users to open the user list page .
6. click add user and enter a name in the username field . Click on the credentials tab and set a password for the new user and disable the temporary flag.
7. restart the api-gateway application 
`docker-compose restart api-gateway`

## Fetch access token from the keycloak server

Via postman , Post a request to get an access token:
`POST http://localhost:18080/auth/realms/spring-micro-main/protocol/openid-connect/token&client_id=spring-micro-gateway&username=<username>&password=<password>&grant_type=password&client_secret=<the generated secret on step2> `  
 `Content-Type: application/x-www-form-urlencoded`
 

## Post a message with the producer microservice :

`GET localhost:8080/api/produce/`  
 `Authorization: Bearer <your bearer token here>`


Check microservice-consumer application logs , we had successfully send a message from producer to consumer via kafka.
