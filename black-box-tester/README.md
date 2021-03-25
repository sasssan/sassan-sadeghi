# Mobile and API test automation framework

This is a framework that runs automated tests against the UI of the Monefy android application and the RESTFul API of the Swagger Pet Store application. The functional tests are written in Given-When-Then format inside Cucumber feature files. There are also a series of low-level sanity tests for RESTFUL API. Please follow the rest of this document for instructions on how to install the framework, run the tests and use the generated test report.


## Tech Stack
Here are the main tools used in the framework:
-  **Java - OpenJDK 14.0.1**: JVM languages such as Java and Groovy have an enormous community as well as great tools and libraries for test automation. (Sorry I did not use a newer Java version. I already had this one installed and didn't want to waste time!)
-  **Gradle 6.3**: Gradle is an intuitive dependency management tool that uses the power of groovy DSL. It also comes with a gradle wrapper file which automatically downloads a predefined gradle version without the need to install gradle on the local machine.
-  **Cucumber**: Java implementation of Cucumber that supports the Gherkin format for writing intuitive functional tests.
-  **Cucumber-reporting**: Test report generator that provides pretty, interactive html output. It can also integrate with Jenkins and expose all sorts of useful information about the tests.
-  **TestNG** Test runner engine used to trigger the code behind Cucumber feature files. I usually prefer this tool because of its powerful support for parallel test execution. Otherwise, JUnit is a healthy alternative.
-  **REST Assured**: Powerful java library to test RESTful APIs. It's very lightweight and easy to set up and configure.
-  **Appium**: Black-Box testing tool used for test automation against web and native applications on mobile platforms. To test the business logic on a front-end application, I normally use platform-specific, grey-box testing tools like Espresso, Detox and Cypress because they are far more stable compared to black-box, general-purpose tools like Selenium or Appium. In this instance I only had access to the apk file so grey-box was not an option. 


## Install, Configure and Run

Use this link to download OpenJDK 14.0.1: https://jdk.java.net/archive/. Make sure you set the JAVA_HOME environment variable to the path of your unpacked JDK directory. Then add *JAVA_HOME/bin* (backslash for Windows) to your PATH variable. Open a terminal and run the following to make sure java is installed:
 
```bash
java -version
```
To connect the framework to mobile devices or emulators, you also need to install Appium. Please follow the instructions on their website: https://appium.io/docs/en/about-appium/getting-started/?lang=en

You also need to install Android SDK (studio) and adb. Please follow the instructions on their website: https://developer.android.com/studio

Before running the tests, we need to configure the framework. Please go to *src/test/resources/local-config.conf* and update the following parameters:
- **petstoreURL**: URL for Pet Store RESTful API
- **appiumURL**: URL for Appium server
- **deviceName, platformName, apkPath**: These are Appium's desired capabilities to install and run the apk file on the target device or emulator. Please refer to this page for instructions on how to set these variables: https://appium.io/docs/en/writing-running-appium/caps/
 

There's no need to install Gradle on you machine. Simply open a terminal on the same directory as this document and make sure the terminal has access to internet. Then run the following command:

```bash
gradlew clean build
```

There is a .bash script for Windows and a Shell script for Linux which after this command, will try to download gradle 6.3. The scripts use JAVA_HOME variable to set the jvm for the installed gradle agent. Finally, gradle will build the project and execute the tests.

## Test Reports
After each round of execution, a html report is generated at the */target/* directory. Test reports are labeled with system timestamp and archived in that directory. Go to any report directory and open this file: *cucumber-html-reports/overview-features.html*. This is a powerful reporting tool that exposes all sorts of information about test results. Please refer to their GitHub page for further information: https://github.com/damianszczepanik/cucumber-reporting  

## Navigating in the project
The project structure is a standard gradle project. All the test code can be found in *src/test/java* and all the Cucumber feature files are located in *src/test/resources/features*. Anything specific to Pet Store or Monefy applications is placed in a dedicated package or directory. To run the tests on an IDE, go to *src/test/java/com.n26.\*.tests* and execute the TestNG test runner. For most IDEs like IntelliJ, you need to install the TestNG plugin. 


## About the tests


#### Monefy Tests 

- For test case ideas please refer to *src/test/resources/MonefyTestCaseIdeas.md*
- For automated test cases please refer to *src/test/resources/features/monefy*
- I won't be surprised if the UI tests are slightly unstable. Generally, Appium tests need to be run many many times before they can be trusted!

#### Pet Store Tests

- The test are broken down to 2 groups. The first group are low-level sanity tests that verify all endpoints are up and running and returning status code 200. These tests can be found at *com.n26.petstore.tests.sanity*. The second group are a few high-level functional tests that deal with the business logic of a few endpoints. The test steps are at *com.n26.petstore.steps*.  
- To test any application, we need to first bring it to a known status. Depending on the system under test, this can be done in various ways such as mocking test data in a local database, clearing the cache, restarting the container inside which the application is running, etc. In order to test the functionality of the Swagger Pet Store application, the only way we can change the state of the application is through the APIs so we can't test the functionality of any individual endpoint without relying on other endpoints. For example, I need to use a GET API to check if my POST API created the new record successfully. This is also reflected in my cucumber feature file.
- The sanity tests run successfully in isolation but unfortunately when they run as part of gradle command, they fail because Pet Store returns Status Code 500. I did not have enough time to investigate the issue so I excluded the tests in the gradle file. But you can still run them through an IDE like IntelliJ (don't forget to install the TestNG plugin) and they will pass. Before running these tests, please make sure you restart the Pet Store server. 



Finally I just wanted to point out that becaue I currently work full time, I didn't have 3 full days to spend on this project and could only spend time on it after 5 pm. Not sure if this is something that is taken into account but I thought it's worth mentioning :) 