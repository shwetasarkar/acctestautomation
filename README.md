# acc-test-automation

UI automation scenario for ACC production application.


As per the requirements, this project focuses on UI automation testing.

**Technology stack**: Selenium and Java for UI automation, Cucumber for BDD and reporting, Maven for build management, Junit for testing, Log4J for logging.


**Software versions:**

Google Chrome Version: 80.0.3987.122
Chromedriver version: ChromeDriver 80.0.3987.106 (https://chromedriver.storage.googleapis.com/index.html?path=80.0.3987.106/)
Eclipse IDE: Version: Oxygen.3a Release (4.7.3a)
OS: Windows 10

**Note**: Chrome browser and chromedriver major versions need to match. In case your browser version doesn't match the one we have used, kindly download the respective chromedriver version from here(https://chromedriver.chromium.org/downloads) and replace it with chromedriver present on location "src/test/resources/drivers/chromedriver_win32/".


**Setup**:

Clone the project from the git repository.
The project can be imported into eclipse as a maven project. All dependencies present in pom.xml will get downloaded by maven.

**Feature File**
All the test BDD scenarios are present in searchJobs.feature file located in "features" folder.

**Execution**:

Method 1): Tests can be executed once the project is imported into the IDE(in this case eclipse). Run the TestRunnerJunit.java class present in com.acc.testrunner package.

OR

Method 2): It can be run from cmd prompt or terminal using the command(From project root directory)
"mvn test"
Note: Maven should be installed and path should be set up in order to run scripts from cmd/terminal


**Reporting**:

Reporting is done using a customer cucumber plugin(https://gitlab.com/monochromata-de/cucumber-reporting-plugin).
Reports are generated in "taget/cucumber/cucumber-html-reports" folder with name "report-feature-xxxx"


The default logging level is INFO which can be changed in log4j.xml