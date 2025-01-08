Here’s how you can create and run an end-to-end Selenium + TestNG project using Maven in **IntelliJ IDEA**. The example integrates **Page Object Model (POM)**, **Data-Driven Testing (DDT)**, and basic Maven functionalities.

---

## **Step 1: Create a Maven Project in IntelliJ IDEA**

1. Open IntelliJ IDEA.
2. Click **File > New > Project**.
3. Select **Maven** from the list, and click **Next**.
4. Fill in the details:
    - **GroupId**: `com.example`
    - **ArtifactId**: `selenium-maven-project`
    - **Version**: `1.0.0`
5. Click **Finish**. IntelliJ will create a Maven project with a `pom.xml` file.

---

## **Step 2: Configure `pom.xml`**

Add the following dependencies and plugins to your `pom.xml` file:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>selenium-maven-project</artifactId>
    <version>1.0.0</version>

    <dependencies>
        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.10.0</version>
        </dependency>

        <!-- TestNG -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.8.0</version>
        </dependency>

        <!-- WebDriver Manager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.5.3</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Maven Surefire Plugin for Running Tests -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

---

## **Step 3: Folder Structure**

Here’s the structure of the project:

```
src/main/java
    com.example.pages
        LoginPage.java
    com.example.tests
        LoginTest.java
src/test/resources
    testdata
        credentials.xlsx
testng.xml
pom.xml
```

---

## **Step 4: Create the Page Object Class**

**`LoginPage.java`**:

```java
package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
```

---

## **Step 5: Create the Test Class**

**`LoginTest.java`**:

```java
package com.example.tests;

import com.example.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login"); // Replace with your application URL
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPassword");
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.getTitle(), "Dashboard");
    }

    @Test
    public void testInvalidLogin() {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();

        Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
```

---

## **Step 6: Create the TestNG XML File**

**`testng.xml`**:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Selenium Test Suite">
    <test name="Login Tests">
        <classes>
            <class name="com.example.tests.LoginTest" />
        </classes>
    </test>
</suite>
```

---

## **Step 7: Run the Project**

1. Open **IntelliJ IDEA**.
2. Right-click on the `testng.xml` file and select **Run 'testng.xml'**.
3. IntelliJ will execute the test suite, and the results will appear in the console.

---

## **Step 8: Explanation of the Project**

1. **Page Object Model (POM)**:
    - The `LoginPage.java` class encapsulates the locators and actions for the login page.
    - This makes the test code reusable and easy to maintain.

2. **TestNG Integration**:
    - `testng.xml` defines the test suite and classes to run.
    - The `LoginTest.java` class contains multiple test cases to validate login functionality.

3. **Maven**:
    - Maven handles the dependencies (Selenium, TestNG, WebDriver Manager).
    - Running `mvn test` in the terminal will execute the test cases.

---

### **Common Interview Questions Based on This Project**

1. **What is Page Object Model (POM)? Why is it important?**
    - POM is a design pattern that helps structure test automation by separating test logic from UI interactions.

2. **How do you manage dependencies in a Maven project?**
    - Using the `pom.xml` file to include dependencies, which Maven downloads from its repositories.

3. **What is the role of TestNG in your project?**
    - TestNG manages test execution, reporting, and annotations for pre- and post-test configurations.

4. **How do you perform parameterization in TestNG?**
    - Using `@DataProvider` or by passing parameters via the `testng.xml` file.

5. **What is the purpose of the `testng.xml` file?**
    - It organizes test cases into suites and allows for configuration such as parallel execution.

Let’s extend this project by integrating it with **CI/CD using Jenkins** and adding advanced features for better scalability and automation. Here's the plan:

---

### **Step 1: Prepare the Maven Project for Jenkins**

1. **Ensure the `pom.xml` is ready**:
    - We already added dependencies for **Selenium**, **TestNG**, and **WebDriverManager**.
    - The `maven-surefire-plugin` ensures the TestNG tests are executed during the Maven build.

2. **Verify Tests Run Locally**:
    - Run `mvn clean test` in the terminal to confirm the tests execute correctly.

---

### **Step 2: Install Jenkins**

1. **Download and Install Jenkins**:
    - Go to the [Jenkins website](https://www.jenkins.io/download/) and install Jenkins.
    - Once installed, start Jenkins by running:
      ```bash
      java -jar jenkins.war
      ```

2. **Install Required Plugins**:
    - Login to Jenkins and navigate to **Manage Jenkins > Manage Plugins**.
    - Install the following plugins:
        - **Maven Integration Plugin**
        - **Git Plugin**
        - **HTML Publisher Plugin**

---

### **Step 3: Create a GitHub Repository for the Project**

1. Push your project to a GitHub repository:
   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   git branch -M main
   git remote add origin https://github.com/username/selenium-bdd-pom.git
   git push -u origin main
   ```

---

### **Step 4: Configure Jenkins Job**

1. **Create a New Job**:
    - Open Jenkins and click **New Item**.
    - Enter a name (e.g., `Selenium-BDD-POM`).
    - Select **Freestyle Project** and click **OK**.

2. **Link the Git Repository**:
    - In the **Source Code Management** section, select **Git**.
    - Add your repository URL (e.g., `https://github.com/username/selenium-bdd-pom.git`).
    - Provide credentials if needed.

3. **Add a Build Step**:
    - Under **Build**, choose **Invoke top-level Maven targets**.
    - Add the command:
      ```bash
      clean test
      ```

4. **Publish HTML Reports**:
    - Under **Post-build Actions**, add **Publish HTML reports**.
    - Set the path to the TestNG reports (e.g., `target/surefire-reports/html`).

5. **Save the Job** and build it.

---

### **Step 5: Run the Job in Jenkins**

1. Click **Build Now** to execute the pipeline.
2. View the console output to ensure the job runs successfully.
3. Once the build is complete, check the published TestNG report under **Post-Build Actions**.

---

### **Step 6: Advanced Features**

#### **1. Parallel Execution**

Update the `testng.xml` file to run tests in parallel:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Selenium Test Suite" parallel="tests" thread-count="2">
    <test name="Login Tests">
        <classes>
            <class name="com.example.tests.LoginTest" />
        </classes>
    </test>
</suite>
```

#### **2. Cross-Browser Testing**

Modify the test class to use a `@DataProvider` for browser selection:

**Updated `LoginTest.java`**:

```java
import org.openqa.selenium.firefox.FirefoxDriver;
// Add imports for SafariDriver, EdgeDriver as needed.

@DataProvider(name = "browsers")
public Object[][] browserDataProvider() {
    return new Object[][] {
        {"chrome"},
        {"firefox"}
    };
}

@Test(dataProvider = "browsers")
public void testLoginWithMultipleBrowsers(String browser) {
    if (browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    // Setup driver, execute test, and quit
}
```

#### **3. Generate Extent Reports**

Add the Extent Reports dependency to `pom.xml`:

```xml
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.0.9</version>
</dependency>
```

Update the test code to generate Extent Reports:

```java
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginTest {
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setupClass() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void testValidLogin() {
        test = extent.createTest("Valid Login Test");
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPassword");
        loginPage.clickLogin();

        if (loginPage.getTitle().equals("Dashboard")) {
            test.pass("Login successful");
        } else {
            test.fail("Login failed");
        }
    }

    @AfterClass
    public void teardownClass() {
        extent.flush();
    }
}
```

---

### **Step 7: CI/CD Integration**

#### **Pipeline in Jenkins**

1. Convert the freestyle job to a pipeline job.
2. Add the following pipeline script in Jenkins:

```groovy
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/username/selenium-bdd-pom.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Generate Report') {
            steps {
                publishHTML(target: [
                    reportDir: 'target/surefire-reports/html',
                    reportFiles: 'index.html',
                    reportName: 'TestNG Report'
                ])
            }
        }
    }
}
```

3. Save and run the pipeline.

---

### **Common Interview Questions**

1. **What is the role of Maven in your project?**
   Maven manages dependencies and builds the project. It also runs tests using the `maven-surefire-plugin`.

2. **How do you integrate Selenium with Jenkins?**
   By creating a Jenkins job, linking the Git repository, and running Maven commands like `mvn clean test`.

3. **How do you handle cross-browser testing in your framework?**
   Using TestNG's `@DataProvider` to parameterize the browser and WebDriverManager to set up the required driver dynamically.

4. **What is a CI/CD pipeline?**
   CI/CD automates the integration and deployment process. Jenkins builds, tests, and reports test results automatically.

Adding **Selenium Grid** to the framework enhances scalability and allows for distributed test execution across multiple environments. Here's how to integrate Selenium Grid into your project:

---

## **Step 1: Understand Selenium Grid**
Selenium Grid allows you to:
- Run tests in parallel across multiple machines or browsers.
- Perform cross-browser testing efficiently.
- Execute tests remotely.

It has two main components:
1. **Hub**: A central server that distributes tests to the connected nodes.
2. **Nodes**: Machines (physical or virtual) where the tests are executed.

---

## **Step 2: Set Up Selenium Grid**

### **1. Download Selenium Server**
- Download the Selenium Server JAR file from the [Selenium official website](https://www.selenium.dev/downloads/).

### **2. Start the Hub**
Run the following command to start the Selenium Grid Hub:
```bash
java -jar selenium-server-<version>.jar hub
```

### **3. Start Nodes**
Run the following command to start nodes and register them with the hub:
```bash
java -jar selenium-server-<version>.jar node --hub http://localhost:4444/grid/register
```

You can specify browser types and max instances with additional options:
```bash
java -jar selenium-server-<version>.jar node --hub http://localhost:4444/grid/register \
--detect-drivers true --max-sessions 5 --driver-configuration "browserName=chrome,maxInstances=3"
```

- The hub will now distribute tests to available nodes.

---

## **Step 3: Configure Tests to Use Selenium Grid**

1. **Modify the Test Class to Use RemoteWebDriver**
   Update the `LoginTest` class to use `RemoteWebDriver` instead of `ChromeDriver` or `FirefoxDriver`.

```java
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

@Test(dataProvider = "browsers")
public void testLoginWithGrid(String browser) throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    if (browser.equalsIgnoreCase("chrome")) {
        capabilities.setBrowserName("chrome");
    } else if (browser.equalsIgnoreCase("firefox")) {
        capabilities.setBrowserName("firefox");
    }
    
    // Connect to Selenium Grid Hub
    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    
    // Perform test steps
    driver.get("https://example.com/login");
    loginPage.enterUsername("testUser");
    loginPage.enterPassword("testPassword");
    loginPage.clickLogin();

    Assert.assertEquals(driver.getTitle(), "Dashboard");
    driver.quit();
}
```

---

## **Step 4: Run Tests in Parallel on the Grid**

Modify `testng.xml` to execute tests in parallel using Selenium Grid:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Selenium Grid Test Suite" parallel="tests" thread-count="3">
    <test name="Login Tests on Grid">
        <parameter name="hubUrl" value="http://localhost:4444/wd/hub"/>
        <classes>
            <class name="com.example.tests.LoginTest" />
        </classes>
    </test>
</suite>
```

---

## **Step 5: Run the Tests**

1. Start the Selenium Grid Hub and Nodes.
2. Run the TestNG suite using:
   ```bash
   mvn clean test
   ```

---

## **Step 6: Integrate Selenium Grid with Jenkins**

1. Ensure the Selenium Grid hub and nodes are running on the server where Jenkins is set up.
2. Update the Jenkins pipeline to include the Selenium Grid configuration:

**Jenkinsfile Example**:
```groovy
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/username/selenium-bdd-pom.git'
            }
        }
        stage('Run Tests on Grid') {
            steps {
                sh 'mvn clean test -DhubUrl=http://localhost:4444/wd/hub'
            }
        }
        stage('Generate Reports') {
            steps {
                publishHTML(target: [
                    reportDir: 'target/surefire-reports/html',
                    reportFiles: 'index.html',
                    reportName: 'TestNG Report'
                ])
            }
        }
    }
}
```

---

## **Step 7: Advanced Grid Features**

### **1. Dockerized Selenium Grid**
Use **Docker** to run the Selenium Grid and its nodes.

1. Create a `docker-compose.yml` file:
```yaml
version: "3"
services:
  hub:
    image: selenium/hub:4.13.0
    container_name: selenium-hub
    ports:
      - "4444:4444"
  chrome:
    image: selenium/node-chrome:4.13.0
    depends_on:
      - hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
    ports:
      - "5900:5900"
  firefox:
    image: selenium/node-firefox:4.13.0
    depends_on:
      - hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
    ports:
      - "5901:5901"
```

2. Start the Selenium Grid:
```bash
docker-compose up -d
```

3. Update your tests to use the Dockerized Grid's hub URL:
   ```java
   new URL("http://localhost:4444/wd/hub");
   ```

### **2. Cloud-Based Testing**
For scalability and reliability, you can integrate cloud-based platforms like:
- **BrowserStack**
- **Sauce Labs**
- **LambdaTest**

These platforms provide pre-configured Selenium Grid environments.

---

## **Common Interview Questions on Selenium Grid**

1. **What is Selenium Grid?**
   Selenium Grid allows running tests in parallel across multiple machines and browsers for distributed test execution.

2. **How does Selenium Grid improve test execution?**
   It speeds up execution by running tests in parallel and supports cross-browser testing on different environments.

3. **How do you connect to Selenium Grid in your framework?**
   By using `RemoteWebDriver` and specifying the Grid hub URL.

4. **What are the challenges with Selenium Grid?**
    - Setting up and maintaining the hub and nodes.
    - Network latency for remote execution.
    - Handling dynamic scaling of nodes.

5. **What is the difference between a local Selenium setup and a Grid setup?**
   Local setup runs tests on the same machine, while Grid distributes tests across multiple machines or environments.

---

Would you like a complete project setup with Dockerized Selenium Grid, POM, and TestNG for Jenkins integration?