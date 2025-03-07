# CS-320-15800-M01

# Appointment, Contact, and Task Management System

## Overview  
This repository contains a **Java-based management system** designed to handle **Appointments, Contacts, and Tasks** efficiently. It follows **best software development practices**, ensuring functionality, security, and scalability. The system includes **validation checks** to enforce data integrity and provides essential **CRUD (Create, Read, Update, Delete) operations**.

Below, you'll find details on **how I ensure functionality and security in my code, how I interpret user needs, and my approach to software design.**

---

## Ensuring Functionality and Security  

To ensure my code, programs, or software are **functional and secure**, I follow a structured development process that includes **thorough testing, validation, and best coding practices**.  

- **Data validation**: Inputs are rigorously checked (e.g., ID length constraints, valid phone number formats, future appointment dates).  
- **Encapsulation**: All attributes are private and accessible only through getters and setters, preventing direct modification.  
- **Exception handling**: The system prevents invalid operations, such as duplicate IDs or incorrect data formats, by throwing meaningful exceptions.  
- **Testing and maintainability**: The service classes provide structured methods for adding, updating, and deleting records while ensuring system consistency.  
- **Secure storage**: Data is stored in **HashMaps**, preventing duplicate records and allowing efficient retrieval.  
- **Unit testing & validation**: Integration testing and User Acceptance Testing (UAT) are applied to verify software performance.  

---

## Understanding and Incorporating User Needs  

Interpreting user needs begins with **clear and effective communication**. When developing this system, the **user's needs** were carefully considered:  

- **Usability**: Users can easily **add, update, and delete** records while ensuring data remains valid.  
- **Data integrity**: The system prevents **duplicate entries** and enforces correct formats (e.g., phone numbers must be exactly 10 digits).  
- **Scalability**: The design follows a **modular approach**, making it easy to integrate additional features or adapt to future requirements.  
- **Validation-first approach**: Prevents the accidental creation of records with invalid data.  
- **Iterative development**: Feedback loops ensure that the final product aligns with user expectations.  

---

## Software Design Approach  

My approach to designing software follows a structured methodology that balances **functionality, scalability, and maintainability**.  

- **Encapsulation**: Each entity has private attributes with getter and setter methods for controlled access.  
- **Modularity**: Each class has a clear purpose—models handle data, while service classes manage operations.  
- **Validation-first approach**: Data is checked before being stored, reducing the risk of errors.  
- **Exception handling**: The system ensures error-free execution by throwing exceptions when invalid data is encountered.  
- **Separation of concerns**:  
  - **Model Classes**: Define the structure of Appointments, Contacts, and Tasks.  
  - **Service Classes**: Handle the logic for adding, updating, retrieving, and deleting records.  
- **Testing integration**: Ensuring robustness by catching and resolving issues early.  

---

## Features  

### Appointment Management  
- **Create** appointments with a **unique ID, valid date, and description**.  
- **Prevent invalid dates** (past dates are not allowed).  
- **Manage appointments** using an in-memory storage system (**HashMap**).  
- **Delete** appointments when necessary.  

### Contact Management  
- **Store contact details** (first name, last name, phone number, and address).  
- **Validate phone numbers** to be **exactly 10 digits**.  
- **Update contacts** (modify name, phone number, or address).  
- **Ensure unique contact IDs** to prevent duplication.  
- **Delete contacts** when needed.  

### Task Management  
- **Create tasks** with a **unique ID, name, and description**.  
- **Enforce name and description constraints** (name ≤ 20 characters, description ≤ 50).  
- **Update task details** (modify name or description).  
- **Ensure unique task IDs** to prevent duplication.  
- **Delete tasks** when necessary.  



