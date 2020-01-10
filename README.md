Seata AT Mode Demo
==================

How to use?
-----------

1. Set GitHub username and token (with `read:packages` scope for read packages in GitHub Package Registry) in `build.gradle`, modify below contents:

    ```
    username = project.findProperty("gpr.user") ?: System.getenv("GH_OWNER")
    password = project.findProperty("gpr.reader") ?: System.getenv("GH_PKG_READER")
    ```

1. Clean and build service jars

    ```
    $ ./gradlew clean bootJar
    ```

1. Docker compose

    ```
    $ docker-compose up -d
    ``` 

1. Wait for all services boot up
   
1. Access Nacos with `nacos`/`nacos`

    http://localhost:8848/nacos

1. Access business service

    http://localhost:8084

1. Use curl to send a post request

    ```bash
    $ curl -H "Content-Type:application/json" -X POST -d '{"userId":"1","commodityCode":"C201901140001","name":"水杯","count":2,"amount":"100"}' localhost:8084/at/business/buy
    ```
   
    This will send a pay request, and return code is 201.

    The follow request will cause an exception:

    ```bash
    $ curl -H "Content-Type:application/json" -X POST -d '{"userId":"1","commodityCode":"C201901140001","name":"水杯","count":2,"amount":"-10"}' localhost:8084/at/business/buy
    ```

1. Or run integration test to check test result

    ```bash
    $ ./gradlew integrationTest
    ```