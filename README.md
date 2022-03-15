# norascoffeeshop-bc

norascoffeeshop-bc is a Business College Helsinki school project to create a Nora's coffee shop webshop with Spring Boot.

## Installation

1. Clone the project into your local device
2. Start the project
3. Create a user
4. Access the local h2 database from http://localhost:8080/h2-console
5. Add the following to the database:
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
update USER_DATA set IS_ADMIN = 'true' where ID = 1;
```

## Usage
Login to the shop and proceed to add date into different categories.

## Info