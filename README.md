# Camunda Expense Report Demo
This is a simple demo showing how to use Camunda integrated with a simple project API.

This application is divided in four modules:

### camunda-expense-report-demo
This is the root module that has shared maven properties.

### customized-webjar
This project contains a customization of the colors in the Camunda webapps. It is based on the project [Springboot Customized Webapps](https://github.com/camunda-consulting/code/tree/master/snippets/springboot-customized-webapps).

### model
The model contains the POJOs that can be used inside the Camunda project.

### sb-expensereport-demo
This is the actual Camunda project for the expense report approval.

### services-demo
This contains the services that proxy the Camunda project and that the process interacts with. It also has a transaction database that is maintained together with the actual process.