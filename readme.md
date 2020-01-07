# CarRental
  
CarRental App is a meticulously developed web application for car renting. It lets your customers to search the cars in your offer, make reservations as well as pay and manage their rentals online. 
  
CarRental was developed using Spring MVC providing efficient and scalable online business environment. 
  
## Prerequisites
  
Java 11  
Apache Maven 3.x

## Installation and running
  
Clone the https://github.com/sacret2/CarRentalApp.git repository and run the application by issuing the following commands in the /CarRentalApp directory:
```
mvn clean package
mvn spring-boot:run
```
Application is now available under http://localhost:8080

## Introduction
  
You are Able to sign in as one of three user types:
  
* administrator
* customer
* employee
  
Administrator's role is to delete and add company branches and employees. He has can view the statistics pertaining rentals in the current month and similar historical statistics for the previous months and years. Admin account is added by default with login credentials:
```
username: admin
password: admin
```
***
Customer has the ability to search for available cars in the branch desired and reserve them for the period of time he chooses. Reservations can be canceled without a fee for a week by default what is subject to change if needed. 
***
Employee is a person that gives the customer the car keys and carries out all the formalities with the client. On website, employee creates rentals out of clients' reservations and manages them from then on.  
After the customer has returned the car overtime a special overdue penalty is added to the rental's price. If the situation occurs an employee adds the damage report with description of car damage and loss of worth estimate created by an expert witness. Loss of worth is added to the rental price. 

## Use cases

### Home page  

<img src="src\main\resources\static\img\readme\home.png" alt="Home view">  
After clicking on Register button you are redirected to the user registration form:
<img src="src\main\resources\static\img\readme\homeCreateUserForm.png" alt="Home view">  
After clicking on Login button you are redirected to the user login form:
<img src="src\main\resources\static\img\readme\homeLogin.png" alt="Home view">  

### Employee User Case  

After passing the correct credentials and clicking Login you are authenticated. You may see now the main user panel (pictured below) adequate to the user type - in this case it's an *employee* user type. Let's see cars in your offer by clicking the *Cars* button:
<img src="src\main\resources\static\img\readme\ECarsClick.png" alt="E cars click">  
The list of available cars appears:
<img src="src\main\resources\static\img\readme\EAddCarClick.png" alt="E add car click"> 
You may add a new car by cliking an *Add new car* button and provide details in the ensuing form:
<img src="src\main\resources\static\img\readme\EAddCarForm.png" alt="E add car form"> 
Then the car is on the list.  
You may edit the car by clicking an *Update* button which redirects you to the update form:
<img src="src\main\resources\static\img\readme\EUpdateCarClick.png" alt="E Update Car Click"> 
Here, in the update form we change the base price and click *Add car*:
<img src="src\main\resources\static\img\readme\EUpdateCar.png" alt="E Car Edited"> 
The changes appear on the car list:
<img src="src\main\resources\static\img\readme\ECarEdited.png" alt="E Car Edited"> 
You may also delete car by clicking the *delete* button next to a chosen car:
<img src="src\main\resources\static\img\readme\ECarDeleteClick.png" alt="E Car Delete Click"> 
And, as expected, the car is no longer present on the list:
<img src="src\main\resources\static\img\readme\ECarDeletedRes.png" alt="E Car Deleted Res"> 
Now in the user panel let's click the *Reservations* button:
<img src="src\main\resources\static\img\readme\EReservationsClick.png" alt="E Reservations Click"> 
And then create a new Rental from a Reservation (reservation is automaticaly deleted as a consequence):
<img src="src\main\resources\static\img\readme\ECreateRentalClick.png" alt="E Create Rental"> 
Now we specify the actual date of car returning and the overdue penalty and click *Add Rental*:
<img src="src\main\resources\static\img\readme\EAddRentalClick.png" alt="E Add Rental Click"> 
Let's see if the rental is there by clicking the *Rentals button*: 
<img src="src\main\resources\static\img\readme\ERentalsClick.png" alt="E Add Rental Click">
The rental is there and finally we are able to generate an invoice from your rental by clicking the *Create invoice* button:
<img src="src\main\resources\static\img\readme\ECreateInvoiceClick.png" alt="E Rentals Click"> 
Let's click the *Invoices* button:
<img src="src\main\resources\static\img\readme\EInvoicesClick.png" alt="E Invoices Click"> 
The authomatically generated invoice from your rental is present as expected:
<img src="src\main\resources\static\img\readme\EInvoicesList.png" alt="E Invoices List"> 

## Version 
Beta
  
## Authors
* **Kamil Nowosad**
* **Marcin Bartosiak**

For source code documentation go to the Documentation folder under the path: CarRentalApp/Documentation 
  
Technologies used:

<p float="left">
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/320px-Spring_Framework_Logo_2018.svg.png" alt="spring" width="200"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="http://fruzenshtein.com/wp-content/uploads/2014/01/Hibernate-logo.png" alt="hibernate" width="200"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="https://d1.awsstatic.com/rdsImages/postgresql_logo.6de4615badd99412268bc6aa8fc958a0f403dd41.png" alt="postgres" width="200"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="https://memorynotfound.com/wp-content/uploads/spring-boot-thymeleaf-logo.png" alt="thymeleaf" width="200"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <img src="http://training.bizleap.com/wp-content/uploads/2018/02/maven-logo.png" alt="maven" width="200"/>   
    <img src="https://cdn-images-1.medium.com/max/800/1*AiTBjfsoj3emarTpaeNgKQ.png" alt="junit" width="200"/>&nbsp;&nbsp;&nbsp;&nbsp;
</p>



