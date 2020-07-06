package com.qiuhuu.common.core.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;

/**
 * 重写redisTemplate
 * @author : qiuhuu
 * @date : 2020-07-02 15-39
 */
public class RedisTemplate extends org.springframework.data.redis.core.RedisTemplate {
    @Autowired
    private RedisProperties redisProperties;

    public ThreadLocal<Integer> indexdb = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return redisProperties.getDatabase();
        }
    };

    @Override
    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        Integer dbindex = indexdb.get();
        try {
            if (dbindex != null){
                if (connection instanceof JedisConnection){
                    if (((JedisConnection)connection).getNativeConnection().getDB() != dbindex){
                        connection.select(dbindex);
                    }
                }else {
                    connection.select(dbindex);
                }
            }else {
                connection.select(0);
            }
        } finally {
            indexdb.remove();
        }
        return super.preProcessConnection(connection, existingConnection);
    }
}
