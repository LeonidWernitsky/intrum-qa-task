# Demo Spring Selenium Automation Project

## Introduction

This is the Homework to create the Test Automation solution with the defined stack of technologies for the designated testing page.

In fact that is just working conception as POC which for the real implementation should be improved and configured (tools like Checkstyle or SpotBugs) in accordance with the Company Rules, Policies and existing CI realization.

## Table of Contents

- [Authors](#authors)
- [Pre-requisites](#pre-requisites)
- [Libraries](#libraries)
- [Reporting](#Reporting)
- [Running Through IntelliJ](#intelliJ)
- [Important Notes](#notes)

## Authors

* [Leonid Wernitsky](https://github.com/LeonidWernitsky)

## Pre-requisites

Please download and install these properly on your system. Visit the websites (linked) to find instructions on how to set them up.

* [Java JDK 11](https://www.java.com/en/download/)
* [Gradle 8.1.1 or later](https://gradle.org/)
* [Firefox 79.0 or later](https://www.mozilla.org/)
* [Selenium GeckoDriver](https://www.toolsqa.com/selenium-webdriver/selenium-geckodriver/)

## Libraries

* [Cucumber](https://cucumber.io/) - library used to support Behavior-Driven Development (BDD).
* [Selenium WebDriver](https://www.selenium.dev/documentation/en/webdriver/) - drives a browser natively, as a real user would, either locally or on remote machines.
* [Spring](https://docs.spring.io/spring-framework/reference/core/beans.html) - framework to support Dependency Injection (DI)
* [Hamcrest](http://hamcrest.org/JavaHamcrest/tutorial) - a framework for writing matcher objects allowing ‘match’ rules to be defined declarative.
* [Lombok](https://projectlombok.org/) - library used to substitute code by annotations like @Data
* [Simple Logging Facade for Java (SLF4J)](http://www.slf4j.org/) - logging utility with six logging levels
* [Checkstyle](https://checkstyle.org/) - plugin to enforce a coding standards
* [SpotBugs](https://spotbugs.readthedocs.io/en/stable/gradle.html) - to find bugs in Java programs

## Running Tests

### Context
You can either run `local` (Firefox is used as specified in Pre-requisites) or `remote` (in Docker containers). Please use "application.yml" file for the configuration. 

The default value is `remote`, but for `local` execution the `context` property should be set as `local`. However, that time the `docker-compose` is set as required every time the test task is executed, so passing `context` as `local` will bring up the Docker containers anyway, even though the execution happens locally.

In the command line you can pass the following argument:
```
./gradlew test -Dcontext=local
```

### Spring Profile
You can run `default` profile on the URL `https://www.intrum.lv/saistibu-parvaldisana/sazinieties-ar-mums/`
Possibility to run `test` profile is reserved for the future ant is not configured completely for now

For the `default` profile you just need to execute Gradle `test` task.

For example, on a "Windows" OS please navigate to the Project root directory, press and hold the "Shift" key and right-click on the free space. 
Click "Open PowerShell window here" in the opened menu, type the command shown below and press the "Enter" key to execute the Tests.
```
./gradlew test
```

### Browser
To run remotely, you have the option of using in a Firefox (default) or a Chrome browser. 
For `chrome` the `browser` property please set the as `chrome` in "application.yml" file.
In the command line you can pass the following argument:
```
./gradlew test -Dbrowser=chrome
```

### Parallel
The project is configured to run in parallel by default. 
You can manage that using `true` or `false` at @DataProvider(parallel = false) in CucumberRunner.java.

The default `threads count` for parallel executions are `10`. You can either change the thread count to `1` and execute them sequentially, or even increase the default number if necessary. 
In the command line you can pass the following argument with the `thread count` wanted:
```
./gradlew test -Ddataproviderthreadcount="1"
./gradlew test -Ddataproviderthreadcount="20"
```

### Tags
All the scenarios will be executed unless the tag group is specified. In the command line, you can pass the following argument with the tag(s):
```
./gradlew test -Dcucumber.filter.tags="@smoke"
```

## Reporting

Please navigate to "RootProjectDirectory/lib/build/test-report/cucumber-html-reports/" directory.
Open "overview-features.html" to see the extended Cucumber Report and screenshots

There are six logging levels used by SLF4J (in order):

* Trace (the least serious)
* Debug
* Info
* Warn
* Error
* Fatal (the most serious)

Use `ROOT` property in `application.yml` file to define your logging level.
 
## IntelliJ
You can also execute the test scenarios through IntelliJ and there are multiple execution options.

### Locally
In the `application.yml` file change the property `context` to `local`.

* Open `Gradle` from the right vertical Tab in IntelliJ, and double-click on `test` from `Tasks` -> `verification`; or
* Right-click on the feature file and select `Run 'Feature: login'`; or
* Right-click on the CucumberRunner.java file and select `Run 'CucumberRunner'`.

### Remote (Docker)
In the `application.yml` file make sure the property `context` is `remote`.

Bring the docker containers `up` by executing the command:
```
docker-compose up -d --scale firefox=2 --scale chrome=2
```

* Open `Gradle` from the right vertical Tab in IntelliJ, and double-click on `test` from `Tasks` -> `verification`; or
* Right-click on the feature file and select `Run 'Feature: login'`.

Bring the docker containers `down` after the test is done by executing the command:
```
docker-compose down
```

## Notes

### Possibly Failed tests
Sometimes one or more test steps might fail due detected issues on the testing site

### Additional configuration need
There is known issue with "geckodriver.exe". 

If you are using  Windows OS,
Please do the configuration or specify your valid path to the "geckodriver.exe" as it's described in "WebDriverManager.java" file in the line 43

If you are using macOS,
Please add the driver file in /usr/local/bin and disable the line 43 in "WebDriverManager.java" file

Please find more details here https://www.toolsqa.com/selenium-webdriver/selenium-geckodriver/

