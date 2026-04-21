# Byline

Byline is a high-end editorial blog platform designed for visual storytelling, typography-driven layouts, and a clean, minimalist reading experience. This repository contains both the frontend application and the backend API.

## Project Architecture

The project is organized as a monorepo-lite, separating the frontend and backend into isolated directories for clean boundaries and easier deployment.

- **`/web`**: Next.js 15, React, TypeScript, and Tailwind CSS v4.
- **`/api`**: Spring Boot 3.4+ (JDK 25) and MySQL.

---

## Tech Stack

### Frontend (`/web`)

- **Framework:** Next.js 15 (App Router, Server Components)
- **Language:** TypeScript
- **Styling:** Tailwind CSS v4 (CSS-first configuration)
- **Package Manager:** Yarn Berry (v4+) with Zero Installs
- **Animations:** Framer Motion

### Backend (`/api`)

- **Framework:** Spring Boot 3.4+
- **Language:** Java 25
- **Database:** MySQL 8.x
- **Build Tool:** Maven

---

## Directory Structure

```text
byline/
├── web/                  # Frontend Next.js application
│   └── ...
├── api/                  # Backend Spring Boot application
│   └── ...
└── docker-compose.yml    # Local database orchestration
```

---

## Getting Started

### Prerequisites

- Node.js (LTS version)
- JDK 25
- Docker (Optional, but recommended for MySQL setup)

### Database Setup

To run the database locally using Docker, execute the following command in the project root:

```bash
docker-compose up -d
```

If setting up MySQL manually, create a database named `byline` and update the database credentials in `api/src/main/resources/application.yml`.

### Backend Setup (`/api`)

1. Navigate to the api directory:
   ```bash
   cd api
   ```
2. Run the application using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

### Frontend Setup (`/web`)

1. Navigate to the web directory:
   ```bash
   cd web
   ```
2. Since this project uses Yarn Berry with Zero Installs, package dependencies are checked into the repository. You can start the development server immediately:
   ```bash
   yarn dev
   ```

---

## Core Features

- **Editorial Layout:** Clean, magazine-style layouts mimicking professional design journals.
- **Dynamic Slugs:** Clean URLs for post sharing and SEO.
- **Read-Time Calculation:** Automated computation of article length displayed on cards and headers.
- **Responsive Typography:** Fluid scaling across mobile, tablet, and desktop viewports.

---

## Development Guidelines

- **Git Workflow:** Create feature branches from `main` (e.g., `feature/post-listing`) and merge via pull requests.
- **Environment Variables:** Create a `.env.local` file in the `/web` directory to point to the backend API URL. Never commit sensitive credentials or environment files to version control.
