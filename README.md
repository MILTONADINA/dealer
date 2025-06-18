# Java Car Dealership Management System

A complete Java desktop application designed to manage a car dealership’s inventory, dealers, and sales personnel using a relational database backend with JPA integration. This project demonstrates proficiency in Java Swing, persistence API (JPA), and modular software architecture using DAO and MVC design patterns.

---

## 🧠 Key Skills Demonstrated

- **Java GUI Development (Swing):** Multiple interface panels for editing, viewing, and interacting with records
- **Database Integration (JPA):** Uses Jakarta Persistence and MySQL connector for full CRUD operations
- **Object-Oriented Architecture:** Structured into Domain (PD), Data Access (DAO), and UI (HI) layers
- **DAO Pattern:** Isolates persistence logic for entities such as `Car`, `Dealer`, and `SalesPerson`
- **Event-Driven Programming:** Handles user input and interactions through `ActionListener`s and components
- **Modular Development:** Scalable and maintainable structure across clearly defined Java packages

---

## 🧱 Tech Stack

- **Language:** Java SE
- **Frameworks/Libraries:** Swing, JPA (Jakarta Persistence API), EclipseLink
- **Database:** MySQL (via JDBC and persistence.xml configuration)
- **Build Tool:** Manual / IDE-based (Eclipse recommended)
- **JARs:** `mysql-connector-j-9.1.0.jar`, `eclipselink.jar`

---

## 🗂️ Project Structure

DealerProject/
├── src/
│ ├── dealerPD/ → Entity classes (Car, Dealer, SalesPerson)
│ ├── dealerDAO/ → Data Access Objects for persistence
│ ├── dealerHI/ → Swing UI classes (DealerFrame, CarEdit, Selection panels)
│ └── META-INF/ → persistence.xml configuration
├── lib/ → External libraries (JARs)
├── persistence.xml → Database and JPA configuration



---

## 🚀 How to Run

### Option 1: Eclipse (Recommended)
1. Import the project as a Java project
2. Add external JARs:
   - `eclipselink.jar`
   - `mysql-connector-j-9.1.0.jar`
3. Ensure MySQL server is running and the required database exists
4. Run `DealerStart.java` as the entry point

### Option 2: Manual Compile (Advanced)
```bash
javac -cp "lib/*" src/dealerHI/DealerStart.java
java -cp "lib/*:src" dealerHI.DealerStart
