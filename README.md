# 🎓 University Course Management System

A powerful **Spring Boot** application that enables **students** to enroll in courses, **instructors** to manage them, and **admins** to oversee the system. The project includes advanced **Hibernate mappings**, **role-based authentication**, and **RESTful APIs**.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14.0-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

## 🚀 Features

✅ **CRUD Operations** for Students, Courses, and Enrollments  
✅ **Advanced Hibernate Mappings** (`OneToMany`, `ManyToMany`, `Composite Keys`)  
✅ **Spring Security** with Role-Based Authentication (`Student`, `Instructor`, `Admin`)  
✅ **PostgreSQL Integration** for efficient data storage  
✅ **Data Validation** using Hibernate Validator  
✅ **Spring Boot Actuator** for monitoring and health checks  
✅ **Swagger API Documentation** for easy testing

## 🛠️ Tech Stack

- **Backend:** Spring Boot, Spring Data JPA, Hibernate
- **Database:** PostgreSQL
- **Security:** Spring Security, JWT Authentication
- **Validation:** Hibernate Validator
- **Logging & Monitoring:** Spring Boot Actuator
- **Documentation:** Swagger/OpenAPI

## 📂 Project Structure

```
src/
├── main/
│   ├── java/com/university/cms/
│   │   ├── config/                 # Configuration classes
│   │   │   ├── SecurityConfig.java
│   │   │   └── SwaggerConfig.java
│   │   ├── controller/             # REST API controllers
│   │   │   ├── CourseController.java
│   │   │   ├── EnrollmentController.java
│   │   │   ├── StudentController.java
│   │   │   └── AuthController.java
│   │   ├── dto/                    # Data Transfer Objects
│   │   │   ├── CourseDTO.java
│   │   │   ├── StudentDTO.java
│   │   │   └── EnrollmentDTO.java
│   │   ├── exception/              # Custom exceptions
│   │   │   ├── GlobalExceptionHandler.java
│   │   │   ├── EntityNotFoundException.java
│   │   │   └── InvalidRequestException.java
│   │   ├── model/                  # Entity classes
│   │   │   ├── Course.java
│   │   │   ├── Enrollment.java
│   │   │   ├── EnrollmentId.java
│   │   │   ├── Student.java
│   │   │   ├── Instructor.java
│   │   │   └── User.java
│   │   ├── repository/             # JPA repositories
│   │   │   ├── CourseRepository.java
│   │   │   ├── EnrollmentRepository.java
│   │   │   ├── StudentRepository.java
│   │   │   └── UserRepository.java
│   │   ├── security/               # Security components
│   │   │   ├── JwtTokenProvider.java
│   │   │   ├── UserDetailsServiceImpl.java
│   │   │   └── JwtAuthenticationFilter.java
│   │   ├── service/                # Business logic
│   │   │   ├── CourseService.java
│   │   │   ├── EnrollmentService.java
│   │   │   ├── StudentService.java
│   │   │   └── AuthService.java
│   │   └── UniversityCmsApplication.java  # Main application class
│   └── resources/
│       ├── application.properties   # App configuration
│       ├── application-dev.properties
│       ├── application-prod.properties
│       └── import.sql               # Initial data
└── test/                           # Unit and integration tests
    └── java/com/university/cms/
        ├── controller/
        ├── service/
        └── repository/
```

## ⚙️ Installation & Setup

### Prerequisites
- Java 17+
- Maven 3.6+
- PostgreSQL 14+

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/university-cms.git
   cd university-cms
   ```

2. **Configure PostgreSQL database**
   ```properties
   # Edit src/main/resources/application.properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/university_cms
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   ```

3. **Build the application**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application**
   - Main application: http://localhost:8080
   - Swagger UI: http://localhost:8080/swagger-ui.html
   - Actuator endpoints: http://localhost:8080/actuator

## 🔐 Authentication

The system uses JWT-based authentication with three user roles:

- **STUDENT**: Can view and enroll in courses
- **INSTRUCTOR**: Can manage their courses and view enrollments
- **ADMIN**: Full system access including user management

### Sample Auth Endpoints

- `POST /api/auth/login` - Get JWT token
- `POST /api/auth/register` - Register new user
- `GET /api/auth/me` - Get current user info

## 📚 API Endpoints

### Student Endpoints
- `GET /api/students` - Get all students
- `GET /api/students/{id}` - Get student by ID
- `POST /api/students` - Create new student
- `PUT /api/students/{id}` - Update student
- `DELETE /api/students/{id}` - Delete student

### Course Endpoints
- `GET /api/courses` - Get all courses
- `GET /api/courses/{id}` - Get course by ID
- `POST /api/courses` - Create new course
- `PUT /api/courses/{id}` - Update course
- `DELETE /api/courses/{id}` - Delete course

### Enrollment Endpoints
- `GET /api/enrollments` - Get all enrollments
- `GET /api/enrollments/student/{studentId}` - Get enrollments by student
- `GET /api/enrollments/course/{courseId}` - Get enrollments by course
- `POST /api/enrollments` - Create new enrollment
- `DELETE /api/enrollments/{studentId}/{courseId}` - Cancel enrollment

## 🐛 Logging and Monitoring

- The application uses SLF4J with Logback for logging
- Spring Boot Actuator is configured for health monitoring
- Access detailed metrics at `/actuator/metrics`
- Health check available at `/actuator/health`

## 🔄 Database Schema

```
+---------------+       +---------------+       +---------------+
|    Student    |       |   Enrollment  |       |    Course     |
+---------------+       +---------------+       +---------------+
| id            |------>| student_id    |       | id            |
| name          |       | course_id     |<------| title         |
| email         |       | enroll_date   |       | description   |
| student_id    |       | grade         |       | credits       |
| graduation_yr |       +---------------+       | instructor_id |
+---------------+                               +---------------+
                                                        |
                                                        |
                                                        v
                                               +---------------+
                                               |  Instructor   |
                                               +---------------+
                                               | id            |
                                               | name          |
                                               | email         |
                                               | department    |
                                               +---------------+
```

## 👥 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📧 Contact

Project Link: [https://github.com/yourusername/university-cms](https://github.com/yourusername/university-cms)

---

⭐️ **Don't forget to star this project if you find it useful!** ⭐️