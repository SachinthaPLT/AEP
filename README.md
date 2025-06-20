# Selenium Cucumber POM Framework

This is a Test Automation Framework built using **Selenium WebDriver**, **Cucumber**, and the **Page Object Model (POM)** design pattern. The project is structured for scalability, maintainability, and ease of test automation across web applications.

---

## 🧰 Tech Stack

- **Java**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **TestNG**
- **Maven**
- **Page Object Model (POM)** Design Pattern
- **ExtentReports / Cucumber Reports**

---

## 📁 Project Structure

```
SeleniumCucumberPOMFramework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages             # Page classes (LoginPage, HomePage, etc.)
│   │   │   └── utils             # Utility classes (DriverFactory, ExcelUtil, Hooks, etc.)
│   └── test
│       ├── java
│       │   ├── runners           # Cucumber test runners
│       │   └── stepDefinitions   # Step definition classes
│       └── resources
│           └── features          # Feature files for BDD scenarios
│
├── pom.xml                       # Maven configuration
└── README.md                     # Project documentation (this file)
```

---

## 🚀 How to Run the Tests

1. **Clone the repository**
   ```bash
   git clone <repo-url>
   cd SeleniumCucumberPOMFramework
   ```

2. **Install dependencies**
   Ensure you have Maven and JDK 11+ installed. Then run:
   ```bash
   mvn clean install
   ```

3. **Run tests via Maven**
   ```bash
   mvn test
   ```

4. **Test Reports**
   After execution, HTML reports will be generated under the `target/` folder.

5. **Screenshots**
   When test fail, Screenshots will be generated under the `screenshots/` folder with failed scenario name.

---

## ✍️ Writing Tests

- **Feature Files:** Located in `src/test/resources/features/`
- **Step Definitions:** Link feature steps with Java code in `stepDefinitions/`
- **Page Methods:** Common element interactions go in `pages/` (e.g., `LoginPage.java`)

---

## ✅ Best Practices

- Follow the POM pattern to separate test logic from UI interactions.
- Reuse utility methods for waits, browser management, and data handling.
- Keep feature files readable and expressive (Gherkin syntax).

---

## 🧪 Example Gherkin Scenario

```gherkin
Feature: Login functionality

  Scenario: Valid login
    Given user is on the login page
    When user enters valid credentials
    Then user should be redirected to the homepage
```


