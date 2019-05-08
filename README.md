# CaféTOWNSEND Test Automation Project

Application [link](http://cafetownsend-angular-rails.herokuapp.com)

## Technology Stack

* macOS High Sierra 10.13.6

* Selenium 3.141.59

* Java 1.8.0_181

* IntelliJ IDEA

* Maven

* TestNG 6.14.3

## Infrastructure setup


1. Java JDK / JRE installation [steps](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-C5F0BF25-3487-4F33-9275-7000C8E1C58C)
and downloads [JDK 1.8.0_181](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html), 
[Java SE Runtime Environment 8](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)

2. IntelliJ IDEA installation [guide](https://treehouse.github.io/installation-guides/mac/intellij-idea-mac.html)

3. Chrome Browser [Version 74.0.3729.131](https://www.google.com/chrome/)

4. ChromeDriver [Version 74.0.3729.6](http://chromedriver.chromium.org/)

## How to run tests via Maven

1. Open the latest GitHub project version in IntelliJ

2. Setup your ChromeDriver path

Copy you local ChromeDriver file path and insert it into the "BaseTest" class the way it is shown on the following example:

```java
@BeforeClass
public void startServer() {
   System.setProperty("webdriver.chrome.driver", "/Users/{Your_User}/Downloads/chromedriver_74");
   DesiredCapabilities caps = DesiredCapabilities.chrome();
```

3. Make sure the Profiles / chrome checkbox is selected in the “Maven Projects” tab on your right hand side.

4. Launch the full test run by clicking on the “test” file in the Lifecycle folder inside the “Maven Projects” tab.





