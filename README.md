# Playwright Java BDD Framework

A starter automation project demonstrating the integration of **Playwright Java** with **Cucumber BDD**. This framework is designed for scalability and follows best practices like the Page Object Model (POM).

## 🚀 Features
- **Browser Automation**: Powered by Microsoft Playwright.
- **BDD Integration**: Gherkin scenarios managed via Cucumber.
- **Design Pattern**: Page Object Model (POM) for clean, maintainable code.
- **Configuration**: Dynamic property management for environment-specific data.
- **Reporting**: Detailed HTML reports generated after every run.

## 📁 Project Structure
```text
src/
 ├── main/java/com/automation/pages/       # Page Object classes
 ├── main/java/com/automation/utils/       # DriverFactory and ConfigReaders
 ├── test/java/com/automation/runner/      # JUnit/TestNG Runners
 ├── test/java/com/automation/stepDef/     # Cucumber Step Definitions
 └── test/resources/features/              # Gherkin .feature files
src\test\java\com\automation\playwright_bdd\configs\config.properties       # Environment variables
pom.xml                                    # Maven dependencies
