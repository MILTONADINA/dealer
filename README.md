# Java Car Dealership Management System

A complete Java desktop application designed to manage a car dealership’s inventory, dealers, and sales personnel using a relational database backend with JPA integration. This project demonstrates proficiency in Java Swing, persistence API (JPA), and modular software architecture using DAO and MVC design patterns.

---

## 🧠 Key Skills Demonstrated

- **Java GUI Development (Swing):** Multiple interface panels for editing, viewing, and interacting with records
- **Database Integration (JPA):** Uses Jakarta Persistence and Hibernate for full CRUD operations
- **Object-Oriented Architecture:** Structured into Domain (PD), Data Access (DAO), and UI (HI) layers
- **DAO Pattern:** Isolates persistence logic and transaction management for entities such as `Car`, `Dealer`, and `SalesPerson`
- **Testing:** Automated DAO tests using JUnit 5 and an in-memory H2 database

---

## 🧱 Tech Stack

- **Language:** Java 17+
- **Frameworks/Libraries:** Swing, JPA (Jakarta Persistence API), Hibernate
- **Database:** MySQL (Production) & H2 (Testing)
- **Build Tool:** Maven

---

## 🗂️ Project Structure

```text
DealerProject/
├── pom.xml → Maven build configuration
└── src/
    ├── main/
    │   ├── java/
    │   │   ├── dealerPD/  → Entity classes (Car, Dealer, SalesPerson)
    │   │   ├── dealerDAO/ → Data Access Objects managing JPA transactions
    │   │   └── dealerHI/  → Swing UI forms and selection panels
    │   └── resources/
    │       └── META-INF/persistence.xml → MySQL Database configuration
    └── test/
        ├── java/
        │   └── dealerDAO/ → JUnit 5 Tests for DAOs
        └── resources/
            └── META-INF/persistence.xml → H2 In-Memory DB configuration
```

---

## 🚀 How to Run

### Option 1: Using Maven (Recommended)

1. Ensure Java 17+ and Maven are installed on your system.
2. Navigate to the `DealerProject` directory.
3. Start your local MySQL server (ensure root has no password, or update `src/main/resources/META-INF/persistence.xml` to match your credentials).
4. Run the application:
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="dealerHI.DealerStart"
   ```

### Option 2: Running Tests

1. No active database required (uses in-memory H2 DB automatically).
2. Run standard Maven verification:
   ```bash
   mvn clean test
   ```

### Option 3: IDE

Import the directory as an existing Maven project into IntelliJ IDEA, Eclipse, or VS Code. Run `DealerStart.java` as the entry point or run the test suite directly from your IDE GUI.
