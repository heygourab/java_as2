## Java Servlet Application Assignments
### By Gourab Sarkar
## File Structure for each project
```css
AppName/
│
├── WebContent/
│   ├── WEB-INF/
│   │   ├── web.xml
│   └── app.html
│
└── src/
    └── com/
        └── example/
            └── AppServlet.java
```
## Explanation
### 1. AppName/
#### This is the root directory of your servlet application. It contains all the necessary files and directories for the web application.

### 2. WebContent/

#### This directory holds the web-related files such as HTML pages, JSP files, and configuration files served to the client (browser).
#### WEB-INF/
##### This directory contains configuration files and libraries that are necessary for the web application but are not directly accessible from the web. Only the server can access files in this directory.
#### web.xml
##### This is the deployment descriptor for the web application. It defines the servlet mappings, initialization parameters, and other configuration settings for the web application. It is crucial to configure how the servlets interact with the web application.
#### lib/
##### This directory holds JAR files on which the web application depends. These JAR files are libraries used by the servlets or other components of the application. For example, if you are using external libraries, you would place their JAR files here.
#### app.html
##### This is an HTML file that provides the user interface for the calculator application. It contains a form where users can input numbers and select an arithmetic operation.
### 3. src/
#### This directory contains the source code for the servlet application.
#### com/example/
##### This is the package structure for the Java classes. It organizes the code into packages to avoid naming conflicts and improve code manageability.
##### AppServlet.java
##### This is the Java servlet class that handles HTTP requests from the client. It processes the form data submitted by the user, performs the specified arithmetic operation, and returns the result to the client.
