This project is developed in Java language and built using Maven, with the implementation of Cucumber framework for behavior-driven testing. The project comprises a scenario named "Create new Users", which involves the creation of users from the users.csv file. The scenario is tagged with "@Users" to run an after-hook, which automatically deletes the created users, ensuring that no conflicts occur in subsequent runs.

A detailed report is generated after each test execution, and it can be found at "target/generated-reports/index.html". The project also employs the Maven Surefire plugin for parallel test execution.

To execute the tests, the command "mvn clean test" can be used.