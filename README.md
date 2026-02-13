# Blood Bank Management System  
### (JSP + Servlets + JDBC + Oracle)

A web-based application developed using **JSP, Servlets, JDBC, and Oracle Database** to manage blood donor records efficiently.  

The system allows adding, viewing, and managing donor information with proper validations and database connectivity.  

This project follows the **MVC (Model–View–Controller) Architecture** for structured development.

---

## Project Objective

The objective of this project is to design and develop a Blood Bank Management System that enables:

- Adding donor records  
- Viewing donor records based on name and donation date  
- Viewing all donor records  
- Maintaining structured donor data in a database  

This application covers limited functionalities for assessment purposes.

---

## Objectives

The system is designed to:

- Store donor details securely  
- Generate unique record IDs automatically  
- Validate donor information before insertion  
- Prevent duplicate donor records  
- Retrieve specific donor records  
- Display all available donor records  
- Handle error and success scenarios properly  

---

## Technologies Used

- **Programming Language:** Java  
- **Frontend:** HTML, JSP  
- **Backend:** Servlets  
- **Database:** Oracle  
- **Connectivity:** JDBC  
- **Server:** Apache Tomcat  
- **IDE:** Eclipse  
- **Architecture:** MVC  

---

## 🗄 Database Design

### 📋 Table: BLOODBANK_TB

| Column Name     | Data Type            | Description |
|---------------|----------------------|------------|
| RECORDID      | VARCHAR2(12 BYTE)    | Primary Key |
| DONORNAME     | VARCHAR2(40 BYTE)    | Not Null |
| BLOODGROUP    | VARCHAR2(10 BYTE)    | Not Null |
| DONATION_DATE | DATE                 | Not Null |
| AGE           | NUMBER               | Donor Age |
| CONTACT       | VARCHAR2(15 BYTE)    | Contact Number |
| REMARKS       | VARCHAR2(100 BYTE)   | Additional Notes |

### 🔢 Sequence: BLOODBANK_SEQ

- **Start Value:** 10  
- **Max Value:** 99  
- **Increment By:** 1  

---

## Project Structure

```plaintext
BloodBankManagementSystem
│
├── com.wipro.bloodbank.util
│   ├── DBUtil.java
│   └── InvalidInputException.java
│
├── com.wipro.bloodbank.bean
│   └── BloodBankBean.java
│
├── com.wipro.bloodbank.dao
│   └── BloodBankDAO.java
│
├── com.wipro.bloodbank.service
│   └── Administrator.java
│
└── com.wipro.bloodbank.servlets
    └── MainServlet.java
```

## Features

### Donor Management
- Add new donor records  
- Automatically generate unique Record ID  
- Prevent duplicate entries  

### Record Viewing
- View specific donor record  
- View all donor records  
- Display appropriate message if no records exist  

### Validations
- Null value validation  
- Donor name length validation  
- Date validation  
- Duplicate record validation  

### Controller Handling
- Redirect to success page on successful insertion  
- Redirect to error page on failure  
- Forward data to JSP pages dynamically  

---

## UI Pages

- `menu.html`
- `addDonor.jsp`
- `viewDonor.jsp`
- `viewAllDonors.jsp`
- `displayDonor.jsp`
- `displayAllDonors.jsp`
- `success.html`
- `error.html`

---

## How to Run the Project

1. Open Eclipse  
2. Import the project  
3. Configure Oracle database connection in `DBUtil.java`  
4. Add Oracle JDBC Driver to the project  
5. Configure Apache Tomcat Server  
6. Run the project on server  
7. Open browser and access `menu.html`  
8. Perform Add / View / View All operations  

---

## 🖥 Output

### 🔹 Main Menu
<img src="https://github.com/user-attachments/assets/16c0ecc8-c1e9-4469-b02b-f249c336b315" width="650"/>

---

### 🔹 Add Donor Record
<img src="https://github.com/user-attachments/assets/957c88e0-e9da-4e94-9232-1db482c23d0c" width="650"/>

---

### 🔹 View Donor Record
<img src="https://github.com/user-attachments/assets/77c0704e-25f5-4a02-b135-c20550b5216b" width="650"/>

---

### 🔹 Display Donor Details
<img src="https://github.com/user-attachments/assets/025852dc-a534-41ec-9024-7e88164ebfa4" width="650"/>

---

### 🔹 View All Donor Records
<img src="https://github.com/user-attachments/assets/d80634a3-a4eb-435b-9640-d975cb2cb43f" width="650"/>

<br>

<img src="https://github.com/user-attachments/assets/cc55323a-2ee1-4ac6-8443-c1f60a4a6773" width="650"/>


## Test Cases Covered

- Add donor record with valid input  
- Add donor record with invalid input  
- Add donor record with null values  
- Add duplicate donor record  
- View donor record with valid input  
- View donor record with invalid input  
- Fetch all donor records  
- Fetch records when database is empty  

---

## Student Details

**Name:** Nikitha S  
**Roll No:** 717823P136  
