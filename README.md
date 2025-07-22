---

# 🎓 EduEnrollSystem

A **Microservices-based backend system** designed to manage **student enrollments**, **courses**, **notifications**, and **daily reports**. This system is built using **Spring Boot** and follows best practices with **Spring Cloud**, **Docker**, **Kafka**, **Spring Batch**, and is fully **monitorable via Prometheus + Grafana + Zipkin**.

---

## 🚀 Modules / Microservices

| Service Name          | Port  | Description                                                                 |
|-----------------------|-------|-----------------------------------------------------------------------------|
| **`student-service`** | 8052  | Manages student details (CRUD operations).                                  |
| **`course-service`**  | 8051  | Manages course details (CRUD operations).                                   |
| **`enrollment-service`** | 8053 | Handles student-course enrollments. Integrates with student and course services using **FeignClient**. |
| **`notification-service`** | 8083   | Listens to Kafka topic and sends success messages.                         |
| **`report-service`**  | 8084   | Generates daily enrollment reports using **Spring Batch**.                 |
| **`apigateway`**      | 7000  | Unified entry point for all services using Spring Cloud Gateway.           |
| **`config-server`**   | 8888  | Centralized externalized configuration for all microservices.              |
| **`eureka-service`**  | 8761  | Service discovery using Netflix Eureka.                                     |

---

## ⚙️ Tech Stack

- **Spring Boot (v3+)**
- **Spring Cloud**: Eureka, Config Server, Gateway
- **Spring Data JPA + MySQL**
- **Spring Batch**
- **Apache Kafka** (via Docker)
- **Docker & Docker Compose**
- **Prometheus (9090)** + **Grafana (3000)** + **Zipkin (9411)**
- **Lombok, Feign Client**

---

Here's the modified README section for the **EduEnrollSystem**, including the updated API usage examples for the **course service**, **student service**, and **enrollment service**. I've organized the information for clarity and consistency.

---

## 📦 How to Run (Using Docker Compose)

1. **Clone the repository:**
   ```bash
   git clone https://github.com/MihirMehar/EduEnrollSystem.git
   cd EduEnrollSystem
   ```
2. **Build all services:**
   ```bash
   mvn clean install
   ```
3. **Run using Docker Compose (create `docker-compose.yml` at root):**
   ```bash
   docker-compose up --build
   ```

### 🔗 Dashboard / Tool URLs

| Dashboard / Tool    | URL                     |
|---------------------|-------------------------|
| **Eureka Dashboard**| `http://localhost:8761` |
| **API Gateway**     | `http://localhost:7000` |
| **Grafana**         | `http://localhost:3000` |
| **Prometheus**      | `http://localhost:9090` |
| **Zipkin**          | `http://localhost:9411` |

---

## 📬 Sample API Usage (via Postman)

### ✅ Enroll a Student
- **POST** `http://localhost:8053/api/enrollment`
- **Body:**
  ```json
  {
    "studentId": 1,
    "courseId": 1,
    "enrollmentDate": "2025-07-21"
  }
  ```

### ✅ Create a Course
- **POST** `http://localhost:8051/api/courses`
- **Body:**
  ```json
  {
    "courseName": "React Basics",
    "courseDescription": "Learn the fundamentals of React.js",
    "category": "Frontend",
    "durationInHours": 20
  }
  ```

### 📘 Get Course Details by ID
- **GET** `http://localhost:8051/api/courses/1`
- **Response:**
  ```json
  {
    "courseId": 1,
    "courseName": "Spring Boot",
    "courseDescription": "Learn Microservices",
    "category": "Backend",
    "durationInHours": 30
  }
  ```

### ✅ Create a Student
- **POST** `http://localhost:8052/api/students`
- **Body:**
  ```json
  {
    "studentName": "Mihir Mehar",
    "email": "mihirmehar2769@gmail.com",
    "phone": "8959428463"
  }
  ```

### 📘 Get Student Details by ID
- **GET** `http://localhost:8052/api/students/1`
- **Response:**
  ```json
  {
    "studentId": 1,
    "studentName": "Mihir Mehar",
    "email": "mihirmehar2769@gmail.com",
    "phone": "8959428793"
  }
  ```

### 📘 Get Enrollment Details by ID
- **GET** `http://localhost:7000/api/enrollments/details/5`
- **Response:**
  ```json
  {
    "enrollmentId": 5,
    "enrollmentDate": "2025-07-21",
    "student": {
      "studentId": 4,
      "studentName": "Priya Singh",
      "email": "priya.singh@gmail.com",
      "phone": "9876543210"
    },
    "course": {
      "courseId": 5,
      "courseName": "Responsive Web Design",
      "courseDescription": "Create mobile-friendly websites with responsive design techniques",
      "category": "Frontend",
      "durationInHours": 18
    }
  }
  ```

### 📘 Search Enrollments by Course ID
- **GET** `http://localhost:8053/api/enrollments/courses/5`
- **Response:**
  ```json
  [
    {
      "enrollmentId": 5,
      "enrollmentDate": "2025-07-21",
      "student": {
        "studentId": 4,
        "studentName": "Priya Singh",
        "email": "priya.singh@example.com",
        "phone": "9876543210"
      },
      "course": {
        "courseId": 5,
        "courseName": "Responsive Web Design",
        "courseDescription": "Create mobile-friendly websites with responsive design techniques",
        "category": "Frontend",
        "durationInHours": 18
      }
    }
  ]
  ```

### 📘 Search Enrollments by Student ID
- **GET** `http://localhost:8053/api/enrollments/student/2`
- **Response:**
  ```json
  [
    {
      "enrollmentId": 2,
      "enrollmentDate": "2025-07-19",
      "student": {
        "studentId": 2,
        "studentName": "Riya Sharma",
        "email": "riya.sharma@example.com",
        "phone": "9876543210"
      },
      "course": {
        "courseId": 2,
        "courseName": "Flask for Beginners",
        "courseDescription": "Learn to build web applications with Flask",
        "category": "Backend",
        "durationInHours": 20
      }
    }
  ]
  ```

---

## 📈 Monitoring and Observability

- **Prometheus** collects metrics from `/actuator/prometheus` endpoint.
- **Grafana** visualizes API usage, response time, and custom dashboards.
- **Zipkin** helps trace API request flows across microservices.

---

## 🔥 Developer

👨‍💻 **Mihir Mehar**  
Backend Developer | Java | Spring Boot | Microservices Enthusiast  
[LinkedIn](https://www.linkedin.com/in/mihir-mehar-27b4a9210) | [GitHub](https://github.com/MihirMehar)

---

## 📌 Future Enhancements

- 📩 Email notifications integration in **notification-service**
- 📝 Export enrollment reports in **CSV/PDF**
- ☁️ Deployment on **AWS (ECS + RDS + S3)**
- 🧪 Add **JUnit/Mockito tests**

⭐ Don’t forget to ⭐ this repo if you found it helpful!

---

Feel free to adjust any sections or add more details as needed!
