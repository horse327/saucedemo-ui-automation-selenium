# SauceDemo UI Automation (Selenium + TestNG)

## Overview

This project is a **UI automation testing framework** for the [SauceDemo](https://www.saucedemo.com/) application, built using **Selenium WebDriver** and **TestNG** with **Java**.

The purpose of this project is to practice and demonstrate **real-world QA automation skills**, including Page Object Model (POM) design, positive and negative test scenarios, and stable UI automation practices.

This repository is intended for **learning, portfolio, and interview demonstration purposes**.

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
│ └── BaseTest.java
├── pages
│ ├── SauceLoginPage.java
│ └── SauceInventoryPage.java
├── tests
│ ├── LoginPositiveTest.java
│ ├── LoginNegativeTest.java
│ └── AddToCartTest.java
└── utils
└── ConfigReader.java

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
- Add product to cart by product name
- Verify cart badge count after adding items

---

## How to Run

### 1. Clone the repository
```bash
git clone https://github.com/horse327/saucedemo-ui-automation-selenium.git
