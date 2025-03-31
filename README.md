# real-time-order-processing-system

🛒 Real-Time Order Processing System with Spring Boot Microservices & Kafka

🚀 Overview

This project is a real-time order processing system built using Spring Boot Microservices and Kafka. It ensures high scalability, fault tolerance, and event-driven communication, making it ideal for e-commerce and transactional applications.

🛠️ System Architecture

🔹 Tech Stack

Spring Boot (for microservices)

Kafka (for event-driven communication)

Spring Cloud (for service discovery, API Gateway, Config)

PostgreSQL & MongoDB (for data persistence)

Docker & Kubernetes (for deployment)

🔹 Microservices Involved

1️⃣ Order Service → Places new orders (produces Kafka events)

2️⃣ User Service → Manages user CRUD (add user, update user)

3️⃣ Payment Service → Processes payments (consumes events, confirms payments)

4️⃣ Product Service → Handles order list (add order, command order )

5️⃣ Notification Service → Sends order status updates via email/SMS (consumes events)
