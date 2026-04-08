# Cargo Management

Spring Boot application for managing **delivery drivers** and **cargo routes** (boarding point, departure point, travel window). Useful as a learning project or a small internal logistics demo.

**Repository:** [github.com/sasimohith/cargo-management](https://github.com/sasimohith/cargo-management)

---

## Business context

| Area | Description |
|------|-------------|
| **Problem** | Track who drives deliveries and which routes they run. |
| **Drivers** | Store driver identity, contact, and license details. |
| **Routes** | Each route belongs to one driver; includes locations and start/end times for planning and auditing. |
| **Users** | Operators use the **web UI** for drivers; integrations or tools use the **REST API** for routes. |

---

## Tech stack

| Layer | Technology |
|-------|------------|
| **Runtime** | Java 11 |
| **Framework** | Spring Boot 2.7.x |
| **Web** | Spring MVC (JSP views), Spring REST |
| **Persistence** | Spring Data JPA, Hibernate |
| **Database (runtime)** | MySQL 8+ |
| **Testing** | JUnit 5, Spring Boot Test, H2 (in-memory) |
| **Build** | Maven (wrapper included) |
| **UI** | JSP, JSTL, Bootstrap 5, jQuery DataTables |

---

## Modules and layout

The code lives under the **`cargomanagement`** Maven module.

| Package / area | Responsibility |
|----------------|----------------|
| `com.amdocs.cargomanagement` | Application entrypoint |
| `...controller` | `DriverController` (MVC + JSP), `RouteController` (JSON REST) |
| `...service` | Business logic (`DriverService`, `RouteService`, `DriverServiceImpl`) |
| `...repo` | Spring Data JPA repositories |
| `...model` | JPA entities `Driver`, `RouteEntity` |
| `...exception` | `ResourceNotFoundException`, `GlobalExceptionHandler` (404 JSON for APIs) |
| `src/main/webapp/jsp` | `driver.jsp`, `view.jsp`, `editDriver.jsp` |

**Relationships:** one **Driver** has many **RouteEntity** records (`@OneToMany` / `@ManyToOne`).

---

## Prerequisites

- **JDK 11** (or compatible; project targets Java 11)
- **Maven** (or use `./mvnw` / `mvnw.cmd`)
- **MySQL** running locally (or adjust JDBC URL), with a database created (e.g. `amdocs_db`)

---

## Configuration

Secrets are **not** committed. Set environment variables (or JVM/system properties) before running:

| Variable | Purpose | Example |
|----------|-----------|---------|
| `MYSQL_URL` | JDBC URL | `jdbc:mysql://localhost:3306/amdocs_db` |
| `MYSQL_USER` | DB user | `root` |
| `MYSQL_PASSWORD` | DB password | *(your password)* |

Defaults in `application.properties` use `MYSQL_URL` / `MYSQL_USER` / `MYSQL_PASSWORD` with sensible fallbacks for URL and username only; **set `MYSQL_PASSWORD`** if your MySQL user requires a password.

See `cargomanagement/src/main/resources/application.properties.example` for a copy-paste template.

**Server port:** `8099` (change in `application.properties` if needed).

---

## Run locally

```bash
cd cargomanagement
# Windows PowerShell example:
$env:MYSQL_PASSWORD="yourpassword"
./mvnw.cmd spring-boot:run
```

Then open:

- **Driver UI:** [http://localhost:8099/](http://localhost:8099/)
- **REST base path for routes:** `/Route` (see table below)

---

## REST API (routes)

Base URL: `http://localhost:8099`

| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/Route/insert/{dno}` | Create a route for driver id `{dno}` (JSON body: route fields) |
| `GET` | `/Route/allRoutes` | List all routes |
| `GET` | `/Route/{routeid}` | Get one route |
| `PUT` | `/Route/update/{routeid}` | Update route |
| `DELETE` | `/Route/delete/{routeid}` | Delete route (204 No Content on success) |

Missing driver or route returns **404** with JSON body `{"error":"..."}`.

---

## Tests

Uses **H2** and profile **`test`** (no MySQL required):

```bash
cd cargomanagement
./mvnw.cmd clean test
```

---

## License

No license file is included by default; add one (e.g. MIT, Apache 2.0) if you publish this for reuse.
