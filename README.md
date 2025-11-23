# ISA Lab - Simple RPG Project

A laboratory project implementing a simple RPG system based on microservices architecture, Docker containerization, and an Angular frontend.

## Project Structure

The solution consists of the following modules:

*   **simple-rpg-character**: Backend microservice responsible for managing characters (Java/Spring Boot).
*   **simple-rpg-profession**: Backend microservice responsible for managing professions (Java/Spring Boot).
*   **simple-rpg-gateway**: API Gateway integrating the services (Java/Spring Boot).
*   **simple-rpg-ng**: Frontend application (Angular/Nginx).

## Requirements

Before running the project, ensure you have the following installed:

*   **Java Development Kit (JDK) 17**
*   **Apache Maven**
*   **Docker** and **Docker Compose**

## Building the Project

The root directory contains a `build.sh` script that automatically compiles all services (using Maven) and builds the Docker images.

To build the entire project, run:

```bash
chmod +x build.sh
./build.sh
```

> **Note:** The build scripts in the subdirectories might expect JDK 17 at a specific path (`/usr/lib/jvm/java-17`). If your Java installation is located elsewhere, ensure your `JAVA_HOME` environment variable is set correctly in your system or adjust the scripts accordingly.

## Running the Application

After successfully building the images, you can start the entire environment using Docker Compose:

```bash
docker-compose up -d
```

This will start containers for all services defined in `docker-compose.yml`.

## Accessing the Application

Once running, the applications are available at the following addresses:

*   **Frontend Application (Web UI):** [http://localhost:8087](http://localhost:8087)
*   **API Gateway:** [http://localhost:8080](http://localhost:8080)

## Stopping

To stop and remove the containers:

```bash
docker-compose down
```
