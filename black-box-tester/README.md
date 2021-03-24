# Mobile and API test automation framework

This is a test automation framework that runs automated tests against the UI of the Monefy android application and the RESTFul APIs of the Petstore application. The tests are written in Given-When-Then format inside Cucumber feature files. Please follow the rest of this document for instructions on how to install the framework, run the tests and use the generated test report.


## Tech Stack
Here are the main tools used in the framework:
-  **Java - OpenJDK 14.0.1**: JVM languages such as Java and Groovy have an enormous community as well as great tools and libraries for test automation. (Sorry I did not use a newer version. I already had this one installed and didn't want to waste time!)
-  **Gradle 6.3**: Gradle is an intuitive dependency management tool that uses the power of groovy DSL. It also comes with a gradle wrapper file which automatically downloads a predefined gradle version without the need to install gradle on the local machine.
-  **Cucumber**: Java implementation of Cucumber that supports the Gherkin format for writing intuitive functional tests.
-  **Cucumber-reporting**: Test report generator that provides pretty, interactive html output. It can also integrate with Jenkins and expose all sorts of useful information about the tests.
-  **TestNG** Test runner engine used to trigger the code behind Cucumber feature files. I usually prefer this tool because of its powerful support for parallel test execution. Otherwise, JUnit is a healthy alternative.
-  **REST Assured**: Powerful java library to test RESTful APIs. It's very lightweight and easy to set up and configure.
-  **Appium**: Black-Box testing tool used for test automation against web and native applications on mobile platforms. Normally I use platform-specific, grey-box testing tools like Espresso, Detox and Cypress to test the business logic of an application because they are far more stable compared to black-box, general-purpose tools like Selenium or Appium. In this instance I only had access to the Binary of the android app so grey-box was not an option. 


## Install, Configure and Run

Use this link to download OpenJDK 14.0.1: https://jdk.java.net/archive/. Make sure you set the JAVA_HOME environment variable to the path to your unpacked JDK directory. Then add *JAVA_HOME/bin* (backslash for Windows) to your PATH variable. Open a terminal and run the following to make sure java is installed:
 
```bash
java -version
```
To connect the framework to mobile devices or emulators, you also need to install Appium. Please follow the instructions on their website: https://appium.io/docs/en/about-appium/getting-started/?lang=en

You also need to install Android SDK (studio) and adb. Please follow the instructions on their website: https://developer.android.com/studio

Before running the tests, we need to configure the framework. Please go to *src/test/resources/local-config.conf* and update the following parameters:
- **petstoreURL**: URL for Petstore RESTful API
- **appiumURL**: URL for Appium server
- **deviceName, platformName, apkPath**: These are Appium's desired capabilities to install and run the apk file on the target device or emulator. Please refer to this page for instructions on how to set these variables: https://appium.io/docs/en/writing-running-appium/caps/
 

There's no need to install Gradle on you machine. Simply open a terminal on the same directory as this document and make sure the terminal has access to internet. Then run the following command:

```bash
gradlew clean build
```

There is a .bash script for Windows and a Shell script for Linux which after this command, will try to download gradle 6.3. The scripts use JAVA_HOME variable to set the jvm for the installed gradle agent. Finally, gradle will build the project and execute the tests.

## Test Reports
After each round of execution, a html report is generated at the */target/* directory. Test reports are labeled with system timestamp and archived in that directory. Open each report directory and open this file: *cucumber-html-reports/overview-features.html*. This is a powerful reporting tools that exposes all sorts of information about test results. Please refer to their GitHub page for further information: https://github.com/damianszczepanik/cucumber-reporting  

## Navigating in the project
The project structure is a standard gradle project. All the test code can be found in *src/test/java* and all the Cucumber feature files are located in *src/test/resources/features*. Anything specific to Petstore or Monefy applications is placed in a dedicated package or directory. To run the tests on an IDE, go to *src/test/java/com.n26.*.tests* and execute the TestNG test runner. For IntelliJ, you need to install the TestNG plugin. 


## Further Comments
To test any application, we need to first bring it to a known status. Depending on the system under test, this can be done in various ways such as mocking test data in a local database, clearing the cache, restarting the container inside which the application is running, etc. In order to test the functionality of the swagger Pet Store application, the only way we can change the state of the application is through the APIs so we can't test the functionality of any individual endpoint without relying on other endpoints. For example, I need to use a GET API to check if my POST API created the new record successfully. This is also reflected in my cucumber feature files.  