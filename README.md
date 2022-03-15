# norascoffeeshop-bc

norascoffeeshop-bc is a Business College Helsinki school project to create a Nora's coffee shop webshop with Spring Boot.

## Installation

1. Clone the project into your local device
2. Start the project by running "mvn spring-boot:run" in the project root folder
3. Navigate to the project URL http://localhost:8080
4. Register a user from the login page
5. Access the local h2 database from http://localhost:8080/h2-console
6. Manually add the following departments to the database:
```h2-console
insert into DEPARMENT values (1, 0,'coffee machines');
insert into DEPARMENT values (2, 0,'consumer products');
insert into DEPARMENT values (3, 1,'espresso machines');
insert into DEPARMENT values (4, 1,'filter coffee');
insert into DEPARMENT values (5, 1,'coffee grinders');
insert into DEPARMENT values (6, 2,'filters');
insert into DEPARMENT values (7, 2,'coffee');
insert into DEPARMENT values (8, 7,'espresso');
insert into DEPARMENT values (9, 7,'filter coffees');
```

## Usage
Login to the shop and proceed to add data into different categories.

## Info

Original illustrative drawings and charts for the project can be found from the folder ./src/main/resources/charts