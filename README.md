# SauceDemo UI Automation (Selenium + TestNG)

## Overview
This project is a **UI automation testing framework** for the [SauceDemo](https://www.saucedemo.com/) application, built using **Selenium WebDriver**, **TestNG**, and **Java**.

The purpose of this project is to **practice and demonstrate real-world QA automation skills**, including:
- Page Object Model (POM) design
- Positive and negative test scenarios
- Stable and maintainable UI automation practices

This repository is intended for **learning, portfolio showcase, and interview demonstration**.

---

## Tech Stack
- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Page Object Model (POM)  
- WebDriverManager  

---

## Project Structure
src/test/java
├── base
│ └── BaseTest.java # WebDriver setup & teardown
├── pages
│ ├── SauceLoginPage.java # Login page actions & validations
│ └── SauceInventoryPage.java # Inventory & cart actions
├── tests
│ ├── LoginPositiveTest.java
│ ├── LoginNegativeTest.java
│ └── AddToCartTest.java
└── utils
└── ConfigReader.java # Configuration handling

src/test/resources
├── config.properties
└── testng.xml


---

## Test Scenarios Covered

### Login
- Login with valid credentials
- Login with invalid credentials
- Login with empty username and password (validation messages)

### Inventory & Cart
- Add product to cart by **product name**
- Verify cart badge count after adding items

---

## How to Run

### 1. Clone the repository
```bash ```
git clone https://github.com/horse327/saucedemo-ui-automation-selenium.git
2. Open in IDE
Open Eclipse / IntelliJ

Import as Existing Maven Project

3. Configure test data
Update credentials in:

src/test/resources/config.properties
Example:

sauce_url=https://www.saucedemo.com/
sauce_username=standard_user
sauce_password=secret_sauce
4. Run tests
Run testng.xml
OR

Run individual TestNG test classes

Framework Highlights
Clean Page Object Model (POM) implementation

Explicit waits to reduce flaky tests

Separation of concerns (tests vs pages vs setup)

Screenshot capture on test failure

Easily extendable for new scenarios

Notes
This project uses public demo credentials provided by SauceDemo

Intended for practice and demonstration only

Chrome browser is used by default

Author
Azhar Munggaran
Junior QA Engineer – Manual & Automation

GitHub: https://github.com/horse327
