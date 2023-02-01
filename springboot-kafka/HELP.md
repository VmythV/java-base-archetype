# Getting Started

在安装kafka之前需要先安装zookeeper，因为kafka 启动会将元数据保存在 zookeeper 中，zookeeper是一种分布式协调服务，可以再分布式系统中共享配置，协调锁资源，提供命名服务。

## zookeeper安装
### 在docker中拉取zookeeper镜像
```shell
docker pull wurstmeister/zookeeper 
```

### 运行zookeeper 服务
```shell
docker run -d --restart=always --log-driver json-file --log-opt max-size=100m --log-opt max-file=2  --name zookeeper -p 2181:2181 -v /etc/localtime:/etc/localtime wurstmeister/zookeeper
```
参数说明：
-v /etc/localtime:/etc/localtime  将本地时间映射到容器中

### 查看docker下是否正常运行zookeeper服务
```shell
docker ps
```


## kafka安装
### 拉取kafka镜像
```shell
docker pull bitnami/kafka:3.2.3
```

### 运行kafka
```shell
docker run -d  --log-driver json-file --log-opt max-size=100m --log-opt max-file=2 --name kafka -p 9092:9092 -e KAFKA_BROKER_ID=0 -e KAFKA_ZOOKEEPER_CONNECT=192.168.12.15:2181/kafka -e ALLOW_PLAINTEXT_LISTENER=yes -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.12.15:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 -v /etc/localtime:/etc/localtime bitnami/kafka:3.2.3
```
注意：zookeeper地址写上面一步的地址，本地安装的写本地ip
参数说明：
-e KAFKA_BROKER_ID=0  在kafka集群中，每个kafka都有一个BROKER_ID来区分自己
-e KAFKA_ZOOKEEPER_CONNECT=192.168.11.129:2181/kafka 配置zookeeper管理kafka的路径
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.11.129:9092  把kafka的地址端口注册给zookeeper
-e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 配置kafka的监听端口
-v /etc/localtime:/etc/localtime 容器时间同步虚拟机的时间

### 查看kafka是否运行正常
```shell
docker ps
```

### 进入kafka容器
```shell
docker exec -it kafka  /bin/bash
```

### 进入kafka的bin目录下
```shell
cd  /opt/kafka__XXX/bin
```

### 创建一个新主题（test-kafka)来存储事件
```shell
./kafka-topics.sh --create --topic test --bootstrap-server localhost:9092
```

### 描述topic分区信息
```shell
./kafka-topic.sh --describe --topic test --bootstrap-server locolhost:9092
```

### 测试消费者
消费者监听消息
```shell
./kafka-console-consumer.sh --topic test --from-beginning --bootstrap-server localhost:9092
```

### 测试生产者
生产者生产消息
```shell
./kafka-console-producer.sh --topic test --bootstrap-server localhost:9092
```

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
<!-- kafka -->
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
    <version>2.9.2</version>
</dependency>
```
### starter
```text
生产者配置
com.myth.kafka.config.KafkaProducerConfiguration

消费者配置
com.myth.kafka.config.KafkaConsumerConfiguration

生产消息
com.myth.kafka.SpringbootKafkaApplication.run

消费消息
com.myth.kafka.SpringbootKafkaApplication.consumerSingle
```

### yaml
```yaml
server:
  port: 8084
spring:
  application:
    name: hello-kafka
  kafka:
    listener:
      #设置是否批量消费，默认 single（单条），batch（批量）
      type: single
    # 集群地址
    bootstrap-servers: 192.168.12.15:9092
    # 生产者配置
    producer:
      # 重试次数
      retries: 3
      # 应答级别
      # acks=0 把消息发送到kafka就认为发送成功
      # acks=1 把消息发送到kafka leader分区，并且写入磁盘就认为发送成功
      # acks=all 把消息发送到kafka leader分区，并且leader分区的副本follower对消息进行了同步就任务发送成功
      acks: all
      # 批量处理的最大大小 单位 byte
      batch-size: 4096
      # 发送延时,当生产端积累的消息达到batch-size或接收到消息linger.ms后,生产者就会将消息提交给kafka
      buffer-memory: 33554432
      # 客户端ID
      client-id: hello-kafka
      # Key 序列化类
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      # Value 序列化类
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
      # 消息压缩：none、lz4、gzip、snappy，默认为 none。
      compression-type: gzip
      properties:
        linger:
          # 发送延时,当生产端积累的消息达到batch-size或接收到消息linger.ms后,生产者就会将消息提交给kafka
          ms: 1000
        max:
          block:
            # KafkaProducer.send() 和 partitionsFor() 方法的最长阻塞时间 单位 ms
            ms: 6000
    # 消费者配置
    consumer:
      # 默认消费者组
      group-id: testGroup
      # 自动提交 offset 默认 true
      enable-auto-commit: false
      # 自动提交的频率 单位 ms
      auto-commit-interval: 1000
      # 批量消费最大数量
      max-poll-records: 100
      # Key 反序列化类
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      # Value 反序列化类
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      # 当kafka中没有初始offset或offset超出范围时将自动重置offset
      # earliest:重置为分区中最小的offset
      # latest:重置为分区中最新的offset(消费分区中新产生的数据)
      # none:只要有一个分区不存在已提交的offset,就抛出异常
      auto-offset-reset: latest
      properties:
        session:
          timeout:
            # session超时，超过这个时间consumer没有发送心跳,就会触发rebalance操作
            ms: 120000
        request:
          timeout:
            # 请求超时
            ms: 120000

```

* [spring-kafka](https://spring.io/projects/spring-kafka)
* [Springboot 整合 Kafka](https://blog.csdn.net/qq_39340792/article/details/117534578)

