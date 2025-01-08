Let's create a **complete end-to-end project** combining **BDD (Cucumber)** and **Page Object Model (POM)** for a simple **login test scenario**. This will demonstrate how to use both frameworks together for automation.

### **Project Overview:**
We will automate a login feature using Cucumber (BDD) and POM. The steps will include:
1. Writing Gherkin feature files to define the behavior of the login process.
2. Using step definitions in Java to execute the test steps and interact with the UI.
3. Structuring the test using the Page Object Model (POM) to separate page interaction logic from test logic.
4. Running the tests with **TestNG** for managing the test execution.

---

### **1. Project Structure:**
Here’s how we will organize the project folder structure:
```
- src
  - main
    - java
      - pages
        - LoginPage.java
      - stepDefinitions
        - LoginSteps.java
  - test
    - java
      - runners
        - TestRunner.java
  - resources
    - features
      - login.feature
  - pom.xml (Maven configuration)
```

---

### **2. Maven Configuration (pom.xml):**
Let's first add the necessary dependencies in your `pom.xml` file.

```xml
<dependencies>
    <!-- Cucumber Dependencies -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.3.2</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-spring</artifactId>
        <version>7.3.2</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-testng</artifactId>
        <version>7.3.2</version>
    </dependency>

    <!-- Selenium WebDriver Dependencies -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>

    <!-- TestNG Dependency for Running Tests -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.3.0</version>
        <scope>test</scope>
    </dependency>

    <!-- WebDriver Manager to handle browser drivers -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>4.4.3</version>
    </dependency>

</dependencies>
```

---

### **3. Feature File (login.feature)**:
The **Feature File** describes the behavior using Gherkin syntax (located in `src/main/resources/features`).

```gherkin
Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the homepage
```

---

### **4. Step Definitions (LoginSteps.java)**:
The **Step Definitions** file maps the Gherkin steps to Java code and interacts with the **Page Object Model** (located in `src/main/java/stepDefinitions`).

```java
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver();  // WebDriver initialization
        loginPage = new LoginPage(driver);
        driver.get("https://www.example.com/login");  // Navigate to login page
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the homepage")
    public void i_should_be_redirected_to_the_homepage() {
        assertTrue(driver.getTitle().contains("Homepage"));
        driver.quit();  // Close the browser
    }
}
```

---

### **5. Page Object Model (LoginPage.java)**:
This class represents the **Login Page** and contains all interactions with web elements (located in `src/main/java/pages`).

```java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Locators for login page elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");

    // Constructor to initialize WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
```

---

### **6. Test Runner (TestRunner.java)**:
The **Test Runner** class configures and runs the Cucumber tests using TestNG (located in `src/test/java/runners`).

```java
package runners;

import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/main/resources/features",   // Location of feature files
    glue = "stepDefinitions",                   // Location of step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"}  // Reports
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Test
    public void runCucumberTests() {
        // TestNG will run the tests defined in the feature files using Cucumber
    }
}
```

---

### **7. Running the Test**:
To run the tests in **IntelliJ IDEA**:

1. Right-click the `TestRunner.java` file and select **Run 'TestRunner'**.
2. **Cucumber** will start running the scenarios defined in the `login.feature` file.
3. **TestNG** will manage the execution, and the results will be displayed in the **TestNG console**.
4. Cucumber reports will be generated in the `target/cucumber-reports.html` file.

### **Conclusion**:
This is a full **end-to-end project** that demonstrates how to:
- Use **BDD** (Cucumber) for writing tests with **Gherkin** syntax.
- Structure your test code using the **Page Object Model (POM)**.
- Manage and run tests using **TestNG**.
- Separate **test logic** from **UI interactions** using **POM** to keep the code maintainable and reusable.

You can now explain this setup during your interview, explaining how BDD and POM work together to create clear, maintainable, and scalable automation tests.

The **Test Runner** class in TestNG is responsible for executing the test scenarios defined in Cucumber feature files. In the case of running Cucumber tests with TestNG, the runner class extends **AbstractTestNGCucumberTests** and is annotated with `@CucumberOptions`.

The `@CucumberOptions` annotation is where you define the location of the feature files (`features`) and the step definitions (`glue`). It also specifies any plugins for reporting. The `runCucumberTests` method (if included) doesn’t need to be explicitly defined, but can be if desired. The TestNG framework handles the execution of Cucumber tests.

Here is an example of how the **TestRunner.java** class looks:

### **TestRunner.java Example:**
```java
package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/main/resources/features",  // Location of the feature files
    glue = "stepDefinitions",                  // Location of step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"}  // Cucumber report plugin
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Test
    public void runCucumberTests() {
        // This method is optional, TestNG will automatically run the tests
        // If added, it would provide more customization or logging for the tests
    }
}
```

### Key Points:
1. **@CucumberOptions**:
    - `features`: Specifies the path where your `.feature` files are located.
    - `glue`: Points to the package where your step definition files (`StepDefinitions`) are located.
    - `plugin`: Defines the output format for Cucumber reports. Here we are generating an HTML report.

2. **AbstractTestNGCucumberTests**:
    - This class is an abstract class provided by the Cucumber TestNG integration. By extending this class, you enable TestNG to run the Cucumber tests.

3. **@Test annotation**:
    - The `runCucumberTests` method can be used to add custom logic for your test execution, though TestNG will automatically trigger the tests if it's left empty.
    - This annotation tells TestNG that this is the method responsible for executing the tests.

### **Why `runCucumberTests` might be empty:**
- TestNG doesn't require you to implement the `runCucumberTests` method manually in most cases. Cucumber's integration with TestNG handles the execution automatically. Therefore, the method can be left empty or omitted if you don't need any special handling.
