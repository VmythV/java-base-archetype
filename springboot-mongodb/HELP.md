# Getting Started

## docker安装mongodb
docker run -d --name mongodb --restart always --privileged -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=123456 -e MONGO_INITDB_DATABASE=test mongo --auth

## 项目配置
### pom
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
<version>2.7.8</version>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-mongodb</artifactId>
<version>2.7.3</version>
</dependency>
```

### yaml
```yaml
server:
  port: 8083
spring:
  application:
    name: springboot-mongodb-demo
  profiles:
    active: local
  data:
    mongodb:
      #      uri: mongodb://admin:123456@localhost:27017/test
      host: localhost
      port: 27017
      database: test
      username: admin
      password: 123456
```

### Repository
继承MongoRepository
```java
public interface UserRepository extends MongoRepository<User, Long> {
}
```

### mongo创建集合
```shell
db.createCollection( "collName");
```


* [MongoDB Quick Start](https://spring.io/guides/gs/accessing-data-mongodb/)

