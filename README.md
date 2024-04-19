MENU CLASS: The menu class displays the CRUD working and uses a command line to display everything from the database

CUSTOMER:It links to database connection and it uses sql commands to select, insert, delete and update functions when car is selected from the menu class

PAYMENT:It links to database connection and it uses sql commands to select, insert, delete and update functions when payment is selected from the menu class

CAR:It links to database connection and it uses sql commands to select, insert, delete and update functions when payment is selected from the menu class

STORE:It links to database connection and it uses sql commands to select, insert, delete and update functions when store is selected from the menu class

DATABASE OPERATIONS:This class provides a contract for customer, payment, car and store so they can perform the CRUD actions.

DATABASE CONNECTION:This class inherits from customer, payment, car and store classes and implements the methods from DATABASE OPERATIONS.

CAR TEST:This is a testing class that uses junit to test the CRUD operations, it checks if the select, insert, update,delete, methods exist and verifies the outcome of the operation.

TEST CONNECTION:This confirms that the user is connected to the database when it is ran, if not it will print an error

OOP Proj is the microsoft project gannt chart
