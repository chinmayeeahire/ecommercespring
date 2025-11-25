# eccommerce spring application

POSTMAN----> SPRING BOOT SERVER ----> 3RD PARTY API
                    |
Exposes REST APIs which will be called by our postman client

- CRUD API(REST STANDARDS)

CREATE
READ
UPDATE
DELETE


Gateway Layer -> responsible for external api interaction

class FakeStoreGateway{
    String  baseURl="www.fakestoreapi.com"
}

- 2 Type of information required in any codebase

1. Configurable value - ex: url, port, 
2. sensitive information - ex: 

Q. How to manange there requird information?

A. 1. AWS key service, azure key vault

A. 2. OS - environment variables - key value pairs accesible from OS, any runnnign process can access the env variable.


2nd approach cmds:

export SERVER_NAME="DEV_SERVER" - ADDED ENV VARIABLE IN CACHE

export OWNER_NAME="chini"

export SERVER_PORT=3001

export tp_api="fakestore"

- if you create the env variable like above cmds , if you restart the terminal the env variables are gone, only stored for current terminal

- If you want to persist

vi bashrc 

now write the previous cmds then save(linux and mac)


library  (DOTENV)
------->  special file(EXTENSION .env)----> put all the key value pairs in this file
+ don't push this file on Version Control


Steps:

1. CReated a plain .env file and added that to .gitignore this ensured taht this file is not tracked by Version Control.

2. Put the env variable value in the .env file ---> PORT=3000

3. In the application.properties access the port from env variables using ${PORT}

4. Before runnning the server, load the .env file population and populate the env variables

5. Run the server

# Spring IOC: (Inversion of control)

It is the Container is the core of Spring Framework. It creates the objects, configures and assemble their dependencies, manage their entire life cycle.

- This Container uses Dependency Injection(DI) to manage the components that make up the application.

- helps you to create object on behalf of you(just need to tell spring the class) how - ex: @component

# ANNOTATION

- @Component: indicates that a class should be managed by the Spring IOC container if discovered during component scan

- @Service

- @RestController: giving capabilities as @Controller(semantic purpose) --> @Component

- @Autowired : nnotation driven Dependency Injection. The main annotation of this feature is @Autowired. It allows Spring to resolve and inject collaborating beans into our bean.


