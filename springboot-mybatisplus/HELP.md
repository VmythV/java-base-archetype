# Getting Started

## docker安装mysql
docker run -p 33306:3306 --name mysql --restart=always -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7

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
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.48</version>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.3.0</version>
</dependency>
```
### starter
```java
@MapperScan(basePackages = "com.myth.mybatis.mapper")
```

### yaml
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:33306/demo?useSSL=false
    username: root
    password: 123456

mybatis:
  mapper-locations: classpath:mapper/*.xml
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```
### Mapper.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.myth.mybatis.mapper.UserMapper">

    <resultMap id="BaseResultMap" type="com.myth.mybatis.entity.User">
            <result property="id" column="id" jdbcType="BIGINT"/>
            <result property="name" column="name" jdbcType="VARCHAR"/>
            <result property="age" column="age" jdbcType="INTEGER"/>
    </resultMap>
</mapper>
```

* [MyBatis Quick Start](https://mybatis.org/mybatis-3/zh/getting-started.html)

