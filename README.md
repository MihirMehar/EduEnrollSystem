Here's a more visually appealing and organized version of your README for the **EduEnrollSystem**. I've added formatting enhancements, icons, and sections to improve readability and engagement.

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
| **`notification-service`** | -   | Listens to Kafka topic and sends success messages.                         |
| **`report-service`**  | -     | Generates daily enrollment reports using **Spring Batch**.                 |
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
- **POST** `http://localhost:7000/api/enrollment/enroll`
- **Body:**
  ```json
  {
    "studentId": 1,
    "courseId": 4,
    "enrollmentDate": "2025-07-21"
  }
  ```

### 📘 Get Enrollment Details by ID
- **GET** `http://localhost:7000/api/enrollment/details/1`
- **Response:**
  ```json
  {
    "enrollmentId": 1,
    "enrollmentDate": "2025-07-19",
    "student": {
      "studentId": 1,
      "studentName": "Mihir Mehar",
      "email": "mihirmehar2769@gmail.com",
      "phone": "8959428793"
    },
    "course": {
      "courseId": 1,
      "courseName": "Spring Boot",
      "courseDescription": "Learn Microservices",
      "category": "Backend",
      "durationInHours": 30
    }
  }
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
[LinkedIn](https://www.linkedin.com/in/mihirmehar) | [GitHub](https://github.com/MihirMehar)

---

## 📌 Future Enhancements

- 📩 Email notifications integration in **notification-service**
- 📝 Export enrollment reports in **CSV/PDF**
- ☁️ Deployment on **AWS (ECS + RDS + S3)**
- 🧪 Add **JUnit/Mockito tests**

⭐ Don’t forget to ⭐ this repo if you found it helpful!

---

Feel free to adjust any sections or add more details as needed!
