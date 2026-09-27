# Open AI Demo 🤖

A Spring Boot application demonstrating how to integrate **OpenAI with Spring AI**.

The project is built using **Java 23**, **Spring Boot 3.4.3**, and **Spring AI**, with support for Spring Security and OpenAPI/Swagger documentation.

## 📁 Project Structure

```text
open-ai-demo/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── gradle/
│   └── wrapper/
│
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
├── Dockerfile
└── README.md
```

##  Architecture Components

| Component | Responsibility |
|---|---|
| **User / Client** | Sends requests to the application |
| **Spring Boot** | Main application framework |
| **REST Controllers** | Exposes REST APIs |
| **Spring Security** | Secures application endpoints |
| **Spring AI** | Provides AI integration abstractions |
| **OpenAI API** | Processes AI requests |
| **Environment Variables** | Stores the OpenAI API key |
| **Springdoc OpenAPI** | Provides API documentation and Swagger UI |

---

## 🛠️ Tech Stack

- **Java:** 23
- **Spring Boot:** 3.4.3
- **Spring AI:** 1.0.0-M6
- **Spring Web**
- **Spring Security**
- **Spring AI OpenAI**
- **Springdoc OpenAPI**
- **Gradle**
- **Lombok**
- **JUnit**

