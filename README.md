# TestProject - REST API

## Getting started

Tools for the project:

Development Kit: **JAVA JDK**
Test Framework: **TestNG** (The other popular test runner framework is JUnit)
IDE: **IntelliJ Community Edition**
JDK: **Java 17**
Build System: **Maven**
Local Server: **JSON SERVER**

## How to run tests

1. git clone https://github.com/svenradic/TestProject.git

2. open IntelliJ Community Edition and load the project

3. Check Node.js and npm version using commands **node -v** and **npm -v**

4. Check for json-server version
   **json-server --version**

5. If not detected, install Node.js and npm
   **https://nodejs.org/en/download/**,
   **npm install -g json-server@0.16.3**

6. It creates a directory for json-server
   **C:\Users\[user]\AppData\Roaming\npm**

7. Create db.json file with starting data on that path
   **C:\Users\[user]\AppData\Roaming\npm\db.json**
   (db.json file can be found in the project folder)

8. Create routes.json file with starting routes on that path
   **C:\Users\user\AppData\Roaming\npm\routes.json**
   (routes.json file can be found in the project folder)

9. Start json-server on path -> **C:\Users\[user]\AppData\Roaming\npm**
   json-server --port 7000 --routes routes.json --watch db.json
   open http://localhost:7000/ in your browser

10. Right click on **textng.xml** file in IntelliJ and run the file or open test package, java package and RestApiTest class and run it.
