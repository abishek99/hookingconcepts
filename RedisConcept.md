# **REDIS**

## What is Redis?

Redis is an open source (BSD licensed) in-memory remote data structure store (database) that offers high performance,
replication, and a unique data model. The full form of Redis is Remote Directory Server. Moreover, we can use it in
multiple forms. Redis provides data structures such as strings, hashes, lists, sets, sorted sets with range queries,
bitmaps, hyperloglogs, geospatial indexes, and streams.

You can use Redis from most programming languages. Redis is written in ANSI C and works in most POSIX systems like
Linux, *BSD, and OS X, without external dependencies. Linux and OS X are the two operating systems where Redis is
developed and tested the most.

## What is Redis Used for?

We can use Redis in the following forms.

1) In-Memory Database: As an In-Memory database, We will get some empty memory to perform database operations. Moreover,
   it acts as No-SQL database and there are No Tables, No Sequences, No Joins concept. We can store data in the form of
   String, Hash Operations***, List, Set etc. In-built services will be available.
2) Cache: We can also use Redis as a Cache to increase our application performance.

In real time application, Redis is popular for a Cache Manager as compared to database & message broker. As a cache
manager, it reduces network calls and improves the performance of an application.

## What is Redis Cache?

Redis Cache is nothing but a Cache Management feature offered by Redis. Redis is normally used as a cache to store
repeatedly accessed data in memory so that the user can feel the better performance of the application. The Redis Cache
offers various features like how long you want to keep data, and which data to remove first, and some other bright
caching models.

## What is the advantage of using Redis Cache in your application?

Like any other Caching Technique, Redis Cache also minimizes the number of network calls made by your application, which
in return improves performance of the application as a whole. One request from an application to the DB is similar to
one network call. We can also achieve the better scaling once we apply any caching mechanism in the application as the
database can serve more calls in this case.

## How does the Redis Cache work in the Application?

When we perform a DB retrieve operation via an Application, the Redis Cache stores the result in it’s cache. Further,
when we perform the same retrieve operation, it returns the result from the cache itself and ignore the second call to
database. Similarly, when we perform a DB update operation, the Redis Cache also updated the result in its cache.
Needless to say, for delete operation also it deleted the data from the cache accordingly. In this way, there are no
chances of getting incorrect data.

## What is Redis Database?

Redis Database is an in-memory database that persists on disk. It means when we use Redis Database, we occupy a memory
on the disk to use as a Database. The data model is key-value, but many several kind of values are supported such as
Strings, Lists, Sets, Sorted Sets, Hashes, Streams, HyperLogLogs, Bitmaps etc.

## What is Redis Server?

The full form of Redis is REmote DIctionary Server. When we use Redis in any form such as database, cache or Message
Broker, we need to download a Redis Server in our system. People in the industry just call it Redis Server.

## DataTypes and command in Redis
For Redis data types and command vists website https://redis.io/docs/data-types/

## Depedencies for enabling redis in spring boot
            <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
            <dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
		</dependency>
		<dependency>
			<groupId>io.lettuce</groupId>
			<artifactId>lettuce-core</artifactId>
		</dependency>

## application.properties 
    spring.redis.url = redis://localhost:6379
    spring.redis.timeout = 30000
    spring.cache.type=redis
    spring.cache.redis.cache-null-values=true

## Config File
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jcf = new JedisConnectionFactory();
        return jcf;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(2L)))
                .build();
    }
