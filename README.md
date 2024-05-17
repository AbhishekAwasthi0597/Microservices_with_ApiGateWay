# README

## Overview
This document provides an overview of the architecture and components involved in the microservices-based application depicted in the provided diagram. The system consists of a client application, an API Gateway, and various microservices that handle specific functionalities related to quizzes.

## Architecture Components

### 1. Client
- **Description**: The client is a frontend application that interacts with the backend services via the API Gateway. It provides the user interface for interacting with the quiz system.

### 2. API Gateway
- **Description**: The API Gateway acts as the single entry point for all client requests. It routes requests to the appropriate microservices. It also handles cross-cutting concerns such as authentication, logging, and rate limiting.

### 3. Microservices
The system comprises several microservices, each responsible for a specific aspect of the quiz application. Each service communicates with the API Gateway over HTTP.

#### 3.1 Quiz Services
- **Description**: This service manages the creation, updating, and deletion of quizzes. It also handles the retrieval of quiz data for users.

#### 3.2 Questions Services
- **Description**: This service is responsible for managing the questions associated with quizzes. It includes functionality for adding, updating, and deleting questions within a quiz.

## Communication
- **Protocol**: All services communicate over HTTP.
- **API Gateway**: The API Gateway handles all incoming requests from the client and routes them to the appropriate service.

## Services Overview
### Quiz Services
- **Endpoints**:
  - `POST /quizzes`: Create a new quiz
  - `GET /quizzes/{id}`: Retrieve quiz details
  - `GET /quizzes/`: Retrieve all quiz details

### Questions Services
- **Endpoints**:
  - `POST /quizzes/{quizId}/questions`: Add a new question to a quiz
  - `GET /quizzes/{quizId}/questions/{questionId}`: Retrieve question details

## External Dependencies
- **Databases**: Each microservice interacts with its own dedicated database to store and retrieve data.

## Service Discovery and Load Balancing
- **Service Registry**: Eureka Netflix Server is used for service registry and load balancing. It allows services to find and communicate with each other without hard-coding hostname and port.
- **Feign Client**: The Feign client is used to connect the Quiz Service to the Question Service, facilitating inter-service communication.

## Additional Notes
- The system is designed to be scalable, with each microservice able to be developed, deployed, and scaled independently.
- The architecture promotes separation of concerns, making it easier to maintain and extend each service without affecting others.

---

This README provides a high-level overview of the architecture. For detailed API specifications, database schemas, and deployment instructions, please refer to the respective documentation for each service.
