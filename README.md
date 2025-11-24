# Intern & Batch Management System

A full-stack project built with **Spring Boot** and **Angular** to manage training batches and interns.  
The system supports creating batches, adding interns with auto-generated IDs, and performing CRUD operations from a simple UI.

---

## 🚀 Features

### **Batch Module**
- Create new batches  
- End date auto-calculated (+6 months)  
- View batch list  
- Delete batches

### **Intern Module**
- Add interns  
- Automatic Intern ID generation  
- View intern list  
- Edit and delete interns  
- Assign interns to batches

---

## 🖥️ Screenshots

### Homepage
<img width="1858" height="727" alt="homepage" src="https://github.com/user-attachments/assets/c2b285bc-1e05-4f42-9ed9-4b5ee32a67a5" />


### Add Batch
<img width="812" height="121" alt="Add Batch form" src="https://github.com/user-attachments/assets/265ab806-6d08-4960-a0c0-9fa8701a8a9b" />### Batch List

### Batch List
<img width="388" height="200" alt="Batch List" src="https://github.com/user-attachments/assets/f1a8c156-6fd3-491d-9e80-390fcf244e9b" />

### Add Intern
<img width="1812" height="116" alt="Add Intern form" src="https://github.com/user-attachments/assets/2c9acdcf-c2f2-484d-8c8c-db6fb28b5064" />


### Intern List
<img width="1207" height="272" alt="Intern List" src="https://github.com/user-attachments/assets/edbfa880-8698-462d-bd05-835a28bf9b01" />

### API – Batches
<img width="1480" height="351" alt="api-batches" src="https://github.com/user-attachments/assets/2ed69694-2058-4a21-83b0-a5969b6c3739" />

### API – Interns
<img width="1893" height="183" alt="api-interns" src="https://github.com/user-attachments/assets/3e104074-ca38-46ee-8321-5c9fbcb8b5c9" />


> Create a folder named **images/** in your repo and upload all screenshots inside it.

---

## 📦 Tech Stack

### **Frontend**
- Angular  
- TypeScript  
- HTML / CSS  
- Reactive Forms  
- HttpClient

### **Backend**
- Spring Boot  
- Java  
- Spring Data JPA  
- Hibernate  
- MySQL (or H2)

---

## 📁 Project Structure
intern-batch-project/
│
├── backend/
│ ├── src/main/java/com/example/internbatch
│ └── pom.xml
│
├── frontend/
│ ├── src/app/components
│ └── angular.json
│
└── README.md


---

## ▶️ How to Run the Project

### **Backend**
```sh
cd backend
mvn spring-boot:run
Runs at:
http://localhost:8080

### **Frontend**
cd frontend
ng serve --open
Runs at:
http://localhost:4200

👨‍💻 Author
Dhiraj Shingade
GitHub: https://github.com/shingaded70




