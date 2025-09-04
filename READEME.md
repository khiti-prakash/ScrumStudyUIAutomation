## PROJECT STRUCTURE OVERVIEW
project-root/
│
├── src/
│   ├── main/java/
│   │   └── com/companyname/framework/
│   │       ├── base/
│   │       │   └── BaseTest.java
│   │       ├── config/
│   │       │   └── ConfigReader.java
│   │       ├── driver/
│   │       │   └── DriverFactory.java
|   |       |   └── DriverManager.java
│   │       ├── utils/
│   │       │   ├── ExcelUtil.java
│   │       │   ├── ScreenshotUtil.java
│   │       │   └── TestUtils.java
│   │       ├── reporting/
│   │       │   └── AllureManager.java
│   │       └── hooks/
│   │           └── Hooks.java
│
│   ├── test/java/
│   │   └── com/companyname/tests/
│   │       ├── runners/
│   │       │   └── TestRunner.java
│   │       ├── stepdefinitions/
│   │       │   └── LoginSteps.java
│   │       └── pages/
│   │           └── LoginPage.java
│
│   └── test/resources/
│       ├── features/
│       │   └── login.feature
│       ├── testdata/
│       │   └── LoginData.xlsx
│       └── config/
│           └── config.properties
│
├── pom.xml
├── testng.xml (if you use TestNG)
├── Jenkinsfile or azure-pipelines.yml
└── README.md


## FOLDER DETAILS
📁 base/

BaseTest.java: Handles driver initialization, teardown, and basic setup using @Before/@After.

📁 config/

ConfigReader.java: Reads config.properties for environment URL, browser, etc.

📁 driver/

DriverFactory.java: Factory pattern to create WebDriver instances using WebDriverManager.

📁 utils/

ExcelUtil.java: Apache POI-based reader for Excel-driven testing.

ScreenshotUtil.java: Captures screenshots on failure.

TestUtils.java: Waits, common actions, assertions, etc.

📁 hooks/

Hooks.java: Implements @Before, @After, attaches screenshots, closes browser.

📁 pages/

Follows Page Object Model (POM). One class per page (e.g., LoginPage.java) with locators + methods.

📁 stepdefinitions/

Maps each Gherkin step to Java methods. Reuses methods from POM classes.

📁 runners/

TestRunner.java: Configures Cucumber to pick feature files, use glue (stepdefs), tags, and reports.

📁 resources/features/

Gherkin .feature files. Tag scenarios as @Smoke, @Regression, @Functional.

📁 resources/testdata/

Excel files used for data-driven scenarios (LoginData.xlsx).

📁 resources/config/

config.properties: Environment URL, browser, timeout settings.