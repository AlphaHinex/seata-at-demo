Seata AT Mode Demo
==================

How to use?
-----------

1. Build service jars

    ```
    $ ./gradlew bootJar
    ```

1. Docker compose

    ```
    $ docker-compose up -d
    ``` 

1. Wait for all services boot up
   
1. Access Nacos with `nacos`/`nacos`

    http://localhost:8848/nacos

1. Use curl to send a post request

    ```bash
    curl -H "Content-Type:application/json" -X POST -d '{"userId":"1","commodityCode":"C201901140001","name":"风扇","count":2,"amount":"100"}' localhost:8084/at/business/buy
    ```
   
   then this will send a pay request, and return code is 200.