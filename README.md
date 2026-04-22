# Byline

Byline is a high-end editorial blog platform designed for visual storytelling, typography-driven layouts, and a clean, minimalist reading experience. This repository contains both the frontend application and the backend API.

## Project Architecture

The project is organized as a monorepo-lite, separating the frontend and backend into isolated directories for clean boundaries and easier deployment.

- **`/web`**: Next.js 16, React 19, TypeScript, and Tailwind CSS v4.
- **`/api`**: Spring Boot 3.4+ (JDK 25) and MySQL.

---

## Tech Stack

### Frontend (`/web`)

- **Framework:** **Next.js 16** (App Router, Enhanced Server Actions)
- **Engine:** **Turbopack** (Default Bundler)
- **Language:** TypeScript 5.x
- **Styling:** Tailwind CSS v4 (High-performance CSS-first engine)
- **Package Manager:** **Yarn 4 (Berry)** with Plug'n'Play (PnP)
- **Linter:** ESLint 9+ (Flat Config)

### Backend (`/api`)

- **Framework:** Spring Boot 3.4+
- **Language:** Java 25
- **Database:** MySQL 8.x
- **Build Tool:** Maven

---

## Directory Structure

```text
byline/
├── web/                  # Frontend Next.js 16 application
│   └── ...
├── api/                  # Backend Spring Boot application
│   └── ...
├── .github/
│   └── workflows/        # Automated CI/CD Pipelines
└── docker-compose.yml    # Local database orchestration
```

---

## Getting Started

### Prerequisites

- **Node.js 22+** (Recommended for Next.js 16)
- **JDK 25**
- **Docker** (For local database containerization)

### Database Setup

To run the database locally using Docker:

```bash
docker-compose up -d
```

### Backend Setup (`/api`)

1. Navigate to the api directory:
   ```bash
   cd api
   ```
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

### Frontend Setup (`/web`)

1. Navigate to the web directory:
   ```bash
   cd web
   ```
2. Ensure Corepack is enabled for **Yarn 4**:
   ```bash
   corepack enable
   ```
3. Install and run:
   ```bash
   yarn install
   yarn dev
   ```

---

## Core Features

- **Editorial Layout:** Clean, magazine-style layouts mimicking professional design journals.
- **Turbopack-Optimized:** Lightning-fast HMR (Hot Module Replacement) and build times.
- **Server-First Logic:** Leveraging React 19 Server Components for minimal client-side JS.
- **Responsive Typography:** Fluid scaling across mobile, tablet, and desktop viewports.

---

## Development Guidelines

- **Senior Standards:** We prioritize **Clean Architecture**, **Architectural Decision Records (ADR)**, and **Deterministic UI**.
- **CI/CD:** Every PR triggers the `Frontend CI` pipeline, ensuring all Type Checks and Linting pass before merging.
- **Linting:** We use the ESLint 9 Flat Config. To check your code manually, run:
  ```bash
  yarn lint
  ```
- **Type Checking:** Strictly enforced via:
  ```bash
  yarn type-check
  ```

---

## Environment Variables

Create a `.env.local` file in the `/web` directory.

```env
NEXT_PUBLIC_API_URL=http://localhost:8080
```

> **Note:** Never commit `.env` files. Ensure they are listed in your `.gitignore`.
