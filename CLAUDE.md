# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Shadow Run - GM is a Spring Boot 3.5.9 application built with Java 25. This is a Game Master assistant application for the Shadowrun tabletop RPG, integrating AI capabilities via Spring AI with Google Gemini.

## Technology Stack

- **Spring Boot 3.5.9** with Java 25
- **Spring Modulith** (1.4.6) - Modular monolith architecture pattern
- **Spring AI** (1.1.2) with Google Gemini integration
- **Spring Data JDBC** with PostgreSQL
- **Flyway** for database migrations
- **Thymeleaf** for server-side templating
- **Lombok** for reducing boilerplate
- **Testcontainers** for integration testing

## Architecture

This application follows the **Spring Modulith** pattern, which structures a monolithic application as a collection of application modules with well-defined boundaries. Each module should be cohesive and loosely coupled, communicating through published events or explicit dependencies.

Key architectural principles:
- Application modules are organized under `src/main/java/ch/gdevxy/shadowrun/`
- Module boundaries should be enforced at package level
- Cross-module communication should use events (Spring Modulith's event publication registry with JDBC persistence)
- Database schema managed by Flyway migrations

## Development Commands

### Building and Running

```bash
# Build the project
./mvnw clean package

# Run the application (default profile - Docker Compose disabled)
./mvnw spring-boot:run

# Run with DEV profile (Docker Compose enabled)
./mvnw spring-boot:run -Dspring-boot.run.profiles=DEV

# Run application directly
java -jar target/shadowrun-1.0.0-SNAPSHOT.jar
```

### Testing

```bash
# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=ShadowrunApplicationTests

# Run a single test method
./mvnw test -Dtest=ShadowrunApplicationTests#methodName

# Run tests with coverage
./mvnw verify
```

### Database

Flyway migrations should be placed in `src/main/resources/db/migration/` following the naming pattern `V{version}__{description}.sql`.

PostgreSQL database configuration:
- In DEV profile: managed via Docker Compose (when `spring.docker.compose.enabled=true`)
- In default profile: Docker Compose is disabled

## Environment Configuration

Required environment variables:
- `GEMINI_API_KEY` - Google Gemini API key for AI integration

Application profiles:
- **default** - Docker Compose disabled, for production or when using external database
- **DEV** - Docker Compose enabled, for local development with containerized dependencies

## Package Structure

Base package: `ch.gdevxy.shadowrun`

When creating new modules, follow Spring Modulith conventions:
- Each module should be a separate package under the base package
- Use `package-info.java` to document module boundaries and exposed APIs
- Internal implementation details should be in nested packages with package-private visibility
