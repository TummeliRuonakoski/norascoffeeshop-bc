# norascoffeeshop-bc

norascoffeeshop-bc is a Business College Helsinki school project to create a Nora's coffee shop webshop with Spring Boot.

In this project users can:
- register an account
- change forgotten password
- edit their profile info
- look at products from different categories and their info
- search for products from the product list
- logoff from the page

In addition an admin user can add, remove and edit info regarding:
- products
- product makers
- product suppliers

## Tools used in the project

- [Java](https://www.java.com/en/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [H2-database](https://www.h2database.com/html/main.html)
- [Hibernate](https://hibernate.org/)

## Installation

1. Clone the project into your local device
2. Start the project by running "mvn spring-boot:run" in the project root folder
3. Navigate to the project URL http://localhost:8080
4. Register a user and an admin user from the login page
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
7. Manually add the following roles to the database:
```h2-console
insert into ROLE values (1, 'ADMIN');
insert into ROLE values (2, 'USER');
```
8. Manually set one of the added users as admin:
```h2-console
update USERS_ROLES set role_id = 1 where user_id = 1;
```

## Usage
Login to the shop and proceed to add data into different categories.

## Info

Original illustrative drawings and charts for the project can be found from the folder ./src/main/resources/charts