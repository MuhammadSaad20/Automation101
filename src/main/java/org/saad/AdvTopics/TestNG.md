Sure! Let's now focus on **TestNG** for your automation framework, similar to the flow we followed for JUnit.

### **TestNG Overview:**

**TestNG** (Test Next Generation) is a testing framework inspired by JUnit but with additional functionalities, including parallel test execution, parameterized tests, and flexible test configuration. It is widely used for **test automation** because of its powerful features and ease of use.

### **Core Features of TestNG:**
- Annotations for controlling test execution
- Test grouping
- Parallel test execution
- Parameterized tests
- Data-driven testing
- Reporting and logging

---

### **Key TestNG Annotations:**

TestNG provides various annotations that help organize and manage test cases.

1. **`@Test`** – Marks a method as a test method.
2. **`@BeforeClass`** – Runs before the first test method in the current class.
3. **`@AfterClass`** – Runs after all the test methods in the current class.
4. **`@BeforeMethod`** – Runs before each test method.
5. **`@AfterMethod`** – Runs after each test method.
6. **`@BeforeSuite`** – Runs before the entire test suite.
7. **`@AfterSuite`** – Runs after the entire test suite.
8. **`@DataProvider`** – Provides data for parameterized tests.
9. **`@Parameters`** – Pass parameters from testng.xml to test methods.

---

### **Why TestNG?**

**Pros of TestNG:**
- **Parallel Test Execution:** TestNG allows running tests in parallel, which helps speed up execution.
- **Flexible Configuration:** You can define methods to run before/after the test, class, suite, or method.
- **Support for Data-Driven Testing:** It supports data providers and parameterized tests, making it easy to feed external data into test cases.
- **Detailed Reports:** TestNG provides built-in reporting functionality, including a test execution summary.

**Cons of TestNG:**
- **Learning Curve:** The framework has a steep learning curve for beginners due to its wide array of features.
- **Limited Support for Older Versions:** TestNG doesn’t support older versions of Java as extensively as JUnit.

---

### **TestNG Annotations with Code Examples:**

1. **Basic TestNG Annotations Example:**

```java
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNGExample {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class - Runs once before the first test in the class.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class - Runs once after all tests in the class.");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method - Runs before each test method.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method - Runs after each test method.");
    }

    @Test
    public void testMethod1() {
        System.out.println("Test Method 1");
    }

    @Test
    public void testMethod2() {
        System.out.println("Test Method 2");
    }
}
```

**Explanation:**
- **`@BeforeClass`** and **`@AfterClass`** methods run before and after the entire test class.
- **`@BeforeMethod`** and **`@AfterMethod`** methods run before and after each test method.
- **`@Test`** marks a method as a test case.

### **TestNG XML Configuration File:**

TestNG also uses an XML configuration file to define and manage test suites.

Example of `testng.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<suite name="Sample Suite">
    <test name="Sample Test">
        <classes>
            <class name="TestNGExample"/>
        </classes>
    </test>
</suite>
```

**Explanation:**
- **`<suite>`** defines the test suite.
- **`<test>`** defines a set of tests that belong together.
- **`<class>`** defines the class containing the test methods.

### **TestNG - Data Provider Example:**

Data-driven testing is one of the strengths of TestNG. You can use the `@DataProvider` annotation to pass different sets of data to your test methods.

```java
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderExample {

    @DataProvider(name = "testData")
    public Object[][] dataProvider() {
        return new Object[][] {
            {"Test1", 1},
            {"Test2", 2},
            {"Test3", 3}
        };
    }

    @Test(dataProvider = "testData")
    public void testWithDataProvider(String name, int number) {
        System.out.println("Running test with " + name + " and number " + number);
    }
}
```

**Explanation:**
- **`@DataProvider`** supplies the test method with different sets of data.
- **`@Test(dataProvider = "testData")`** tells TestNG to use the data provided by the `dataProvider` method.

---

### **TestNG Project Folder Structure (Enterprise Level):**

```plaintext
TestNG_Project
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               ├── tests
│   │               │   └── TestNGExample.java
│   │               └── utils
│   │                   └── WebDriverUtils.java
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── tests
│                       └── TestNGDataProviderExample.java
├── testng.xml
└── lib
    └── selenium.jar
    └── testng.jar
```

**Explanation:**
- `src/main/java`: Contains the main code, including utility classes like `WebDriverUtils`.
- `src/test/java`: Contains test code, including test methods and test data classes.
- `testng.xml`: Defines the test suite and its configuration.
- `lib`: Contains all the external dependencies (like Selenium WebDriver and TestNG JAR files).

---

### **Interview Questions for TestNG:**

1. **What is TestNG and how is it different from JUnit?**
    - **Answer:** TestNG is a testing framework inspired by JUnit but with additional features like annotations for grouping tests, parallel test execution, data-driven testing, etc. It is more flexible and powerful than JUnit, especially for large-scale test automation.

2. **What are TestNG annotations, and how do they work?**
    - **Answer:** TestNG annotations are special markers used to define methods that should run before or after test methods, suites, or classes. Key annotations include `@Test`, `@BeforeClass`, `@AfterClass`, `@BeforeMethod`, `@AfterMethod`, `@DataProvider`, and `@Parameters`.

3. **How would you run a TestNG test in parallel?**
    - **Answer:** You can configure parallel test execution in TestNG using the `<suite>` or `<test>` tags in the `testng.xml` file. By setting the `parallel` attribute to `methods`, `tests`, or `classes`, TestNG will execute the tests concurrently.

4. **What is a DataProvider in TestNG and how do you use it?**
    - **Answer:** A DataProvider in TestNG is used to provide test data to methods. It allows you to run the same test method multiple times with different input values. You can define a DataProvider using the `@DataProvider` annotation and associate it with the test method.

5. **Explain the TestNG XML configuration.**
    - **Answer:** TestNG uses an XML configuration file (`testng.xml`) to define test suites, test groups, and classes. It allows you to organize tests and configure parallel execution, reporting, and grouping.

---

### **Next Steps:**

With the concepts above, you can now confidently discuss **TestNG** in interviews and explain its role in test automation frameworks.
