SEATA AT Mode Demo
==================

[![Check](https://github.com/AlphaHinex/seata-at-demo/workflows/Check/badge.svg)](https://github.com/AlphaHinex/seata-at-demo/actions?query=workflow%3ACheck)

How to use?
-----------

### Prepare

Set GitHub username and token (with `read:packages` scope for read packages in GitHub Package Registry) in `build.gradle`, modify below contents:

    ```
    username = project.findProperty("gpr.user") ?: System.getenv("GH_OWNER")
    password = project.findProperty("gpr.reader") ?: System.getenv("GH_PKG_READER")
    ```

### Check result

* [master](https://github.com/AlphaHinex/seata-at-demo/tree/master) branch: build 4 services without global transaction
* [seata-at](https://github.com/AlphaHinex/seata-at-demo/tree/seata-at) branch: base on master branch, apply SEATA AT mode to control global transaction

switch to each branch and do the steps below to check result:

1. Change branch, `master` or `seata-at`

    ```bash
    $ git checkout <branch_name>
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
