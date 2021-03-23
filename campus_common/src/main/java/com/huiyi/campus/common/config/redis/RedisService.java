package com.huiyi.campus.common.config.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: liyukai
 * @Email: 2919529566@qq.com
 * @Description: redis缓存常用方法工具
 * @date: 2021-03-23 14:27
 * @Version V1.0
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
public class RedisService {

    private Logger LOG = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 从缓存中删除指定的key
     * @param keys
     */
    public void del(final String... keys) {
        try {
            redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    long result = 0;
                    for (int i = 0; i < keys.length; i++) {
                        result = connection.del(keys[i].getBytes());
                    }
                    return result;
                }
            });

        } catch (Exception e) {
            LOG.error("RedisService del error",e);
        }
    }

    /**
     * 重缓存中删除指定的key 模式匹配，效率低
     * @param keys
     */
    public void delByReg(final String... keys) {
        try {
            redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    long result = 0;
                    for (int i = 0; i < keys.length; i++) {
                        Set<byte[]> keyset = connection.keys((keys[i] + "*").getBytes());
                        for (byte[] key : keyset) {
                            result = connection.del(key);
                        }
                    }
                    return result;
                }
            });

        } catch (Exception e) {
            LOG.error("RedisService delByReg error",e);
        }
    }

    /**
     * 判断一个键是否存在于缓存中
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        Boolean result = false;
        try {
            result = (Boolean) redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.exists(key.getBytes());
                }
            });

        } catch (Exception e) {
            LOG.error("RedisService exists error",e);
        }

        return result;
    }

    /**
     * 向缓存中插入数据 yyl
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(final byte[] key, final byte[] value, final long liveTime) {
        try {
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Long doInRedis(final RedisConnection connection) throws DataAccessException {
                    connection.set(key, value);
                    if (liveTime > 0) {
                        connection.expire(key, liveTime);
                    }
                    return 1L;
                }
            });
        } catch (Exception e) {
            LOG.error("RedisService set error",e);
        }
    }
    // yyl
    public <T> void set(String key, T value, long liveTime, Class<T> type) {
        if (value == null) {
            return;
        }
        try {
            Jackson2JsonRedisSerializer<T> serializer = new Jackson2JsonRedisSerializer<T>(type);
            byte[] _value = serializer.serialize(value);
            this.set(key.getBytes(), _value, liveTime);
        } catch (Exception e) {
            LOG.error("RedisService set error",e);
        }
    }

    public void set(String key, String value, long liveTime){
        try {
            this.set(key.getBytes(), value.getBytes("utf-8"), liveTime);
        }catch (Exception e){
            LOG.error("RedisService only set error",e);
        }
    }

    public void set(String key, String value) {
        this.set(key.getBytes(), value.getBytes(), 0);
    }


    /**
     * 从缓存中获取数据
     * @param key
     * @return
     */
    public String get(final String key) {
        String cacheValue = "";
        try {
            cacheValue = redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection connection) throws DataAccessException {
                    try {
                        byte[] cacheBytes = connection.get(key.getBytes());
                        if (cacheBytes != null) {
                            String cacheStr = new String(cacheBytes, "utf-8");
                            return cacheStr;
                        }
                    } catch (Exception e) {
                        LOG.info(e.getMessage());
                    }
                    return "";
                }
            });
        } catch (Exception e) {
            LOG.error("RedisService get error",e);
        }
        return cacheValue;
    }


    public byte[] getBytes(final String key) {
        byte[] cacheValue = null;
        try {
            cacheValue = redisTemplate.execute(new RedisCallback<byte[]>() {
                @Override
                public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                    try {
                        byte[] cacheBytes = connection.get(key.getBytes());
                        if (cacheBytes != null) {
                            return cacheBytes;
                        }
                    } catch (Exception e) {
                        LOG.info(e.getMessage());
                    }
                    return new byte[0];
                }
            });
        } catch (Exception e) {
            LOG.error("RedisService getBytes error",e);
        }
        return cacheValue;
    }

    public <T> T get(final String key, final Class<T> clazz) {
        T t = null;
        t = redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] data = connection.get(key.getBytes());
                if (data != null) {
                    return new Jackson2JsonRedisSerializer<T>(clazz).deserialize(data);
                }
                return null;
            }
        });
        return t;
    }

    /**
     * 清空缓存
     */
    public void flushDB() {
        try {
            redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.flushDb();
                    return "ok";
                }
            });
        } catch (Exception e) {
            LOG.error("RedisService flushDB error",e);
        }
    }

    /**
     * 添加至有序集合
     * @param key
     * @param score
     * @param value
     */
    public void zadd(final byte[] key, final double score, final byte[] value) {
        try {
            redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.zAdd(key, score, value);
                    return "ok";
                }
            });
        } catch (Exception e) {
            LOG.error("RedisService zadd error",e);
        }
    }

    /**
     * 按条件获取有序集合元素子集
     * @param key
     *            有序集合key
     * @param min
     *            范围最小值
     * @param max
     *            范围最大值
     * @param offset
     *            从第0ffset+1个元素起
     * @param count
     *            返回上限
     * @return
     */
    public Set<byte[]> zRangeByScore(final byte[] key, final double min, final double max, final long offset,
                                     final long count) {
        Set<byte[]> set = null;
        try {
            set = redisTemplate.execute(new RedisCallback<Set<byte[]>>() {

                @Override
                public Set<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.zRangeByScore(key, min, max, offset, count);
                }

            });
        } catch (Exception e) {
            LOG.error("RedisService zRangeByScore error",e);
        }
        return set;
    }

    /**
     * 添加指定map至缓存
     * @param key map唯一标识
     * @param hashes
     */
    public void hMSet(final byte[] key, final Map<byte[], byte[]> hashes, final long liveTime) {
        try {
            redisTemplate.execute(new RedisCallback() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.hMSet(key, hashes);
                    if (liveTime > 0) {
                        connection.expire(key, liveTime);
                    }
                    return null;
                }
            });

        } catch (Exception e) {
            LOG.error("RedisService hMSet error",e);
        }
    }

    /**
     * @describe: 操作hashMap
     * @author：caoxiaohong
     * @createtime：2016年9月28日 下午5:34:06
     * @param key
     * @param hashes
     * @return void
     */
    public void hMSet(final String key, final Map<String, String> hashes) {
        StringRedisSerializer serializer = new StringRedisSerializer();
        Map<byte[], byte[]> byMap = new HashMap<byte[], byte[]>();
        for(Map.Entry<String,String> entry:hashes.entrySet()) {
            byMap.put(serializer.serialize(entry.getKey()), serializer.serialize(entry.getValue()));
        }
        hMSet(serializer.serialize(key), byMap, 0);
    }

    /**
     * 设置生命周期
     * @param key
     * @param hashes
     * @param liveTime
     */
    public void hMSet(final String key, final Map<String, String> hashes, final long liveTime) {
        StringRedisSerializer serializer = new StringRedisSerializer();
        Map<byte[], byte[]> byMap = new HashMap<byte[], byte[]>();
        for(Map.Entry<String,String> entry:hashes.entrySet()) {
            byMap.put(serializer.serialize(entry.getKey()), serializer.serialize(entry.getValue()));
        }
        hMSet(serializer.serialize(key), byMap, liveTime);
    }

    /**
     * 获取指定map中指定键对应的值列表
     * @param key map的唯一标识
     * @param fields 键数组
     * @return 值数组
     */
    public List<byte[]> hMGet(final byte[] key, final byte[]... fields) {
        List<byte[]> cacheValue = null;
        try {
            cacheValue = redisTemplate.execute(new RedisCallback<List<byte[]>>() {
                @Override
                public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.hMGet(key, fields);
                }
            });
        } catch (Exception e) {
            LOG.error("RedisService hMGet error",e);
        }
        return cacheValue;
    }

    public void hMSet(final byte[] key, final byte[] field, final byte[] value, final long liveTime) {
        try {
            redisTemplate.execute(new RedisCallback() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.hSet(key, field, value);
                    if (liveTime > 0) {
                        connection.expire(key, liveTime);
                    }
                    return null;
                }
            });

        } catch (Exception e) {
            LOG.error("RedisService hMSet error",e);
        }
    }

    /**
     * @describe: 设置hash存储单个属性
     * @author：caoxiaohong
     * @createtime：2016年9月29日 下午12:03:53
     * @param key
     * @param field
     * @param value
     * @return void
     */
    public void hMSet(String key, String field, String value) {
        StringRedisSerializer serializer = new StringRedisSerializer();
        hMSet(serializer.serialize(key), serializer.serialize(field), serializer.serialize(value), 0);
    }


    public byte[] hMGet(final byte[] key, final byte[] field) {
        byte[] cacheValue = null;
        try {
            cacheValue = redisTemplate.execute(new RedisCallback<byte[]>() {
                @Override
                public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.hGet(key, field);
                }
            });
        } catch (Exception e) {
            LOG.error("RedisService hMGet error",e);
        }
        return cacheValue;
    }

    /**
     * @describe: 获取单个hash字段
     * @author：caoxiaohong
     * @createtime：2016年9月29日 下午3:51:14
     * @param key
     * @param field
     * @return
     * @return String
     */
    public String hMGet(String key, String field) {
        String value = "";
        StringRedisSerializer serializer = new StringRedisSerializer();
        if(null != hMGet(serializer.serialize(key), serializer.serialize(field))) {
            value = serializer.deserialize(hMGet(serializer.serialize(key), serializer.serialize(field)));
        }
        return value;
    }


    /**
     * @describe: 检测hash中属性值是否存在
     * @author：caoxiaohong
     * @createtime：2016年9月29日 下午3:56:21
     * @param key
     * @param field
     * @return
     * @return boolean
     */
    public boolean hExists(final String key, final String field) {
        Boolean result = false;
        try {
            result = (Boolean) redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.hExists(key.getBytes(), field.getBytes());
                }
            });

        } catch (Exception e) {
            LOG.error("RedisService hExists error",e);
        }

        return result;
    }


    /**
     * @describe: 设置hash增加值
     * @author：caoxiaohong
     * @createtime：2016年9月29日 下午4:26:58
     * @param key
     * @param field
     * @param delta
     * @return
     * @return Long
     */
    public Long hIncrBy(final String key, final String field, final long delta) {
        Long result = null;
        try {
            result = (Long) redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.hIncrBy(key.getBytes(), field.getBytes(), delta);
                }
            });
        } catch (Exception e) {
            LOG.error("RedisService hIncrBy error",e);
        }

        return result;
    }


    public Map<byte[], byte[]> hGetAll(final byte[] key) {
        Map<byte[], byte[]> cacheValue = null;
        try {
            cacheValue = redisTemplate.execute(new RedisCallback<Map<byte[], byte[]>>() {
                @Override
                public Map<byte[], byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.hGetAll(key);
                }
            });
        } catch (Exception e) {
            LOG.error("RedisService hGetAll error",e);
        }
        return cacheValue;
    }

    /**
     * @describe: 获取hash下所有值
     * @author：caoxiaohong
     * @createtime：2016年9月29日 下午5:08:03
     * @param key
     * @return
     * @return Map<String,String>
     */
    public Map<String, String> hGetAll(final String key) {
        StringRedisSerializer serializer = new StringRedisSerializer();
        Map<String, String> allMap = new HashMap<String, String>();
        Map<byte[], byte[]> byMap = hGetAll(key.getBytes());
        for(Map.Entry<byte[],byte[]> entry:byMap.entrySet()) {
            allMap.put(serializer.deserialize(entry.getKey()), serializer.deserialize(entry.getValue()));
        }
        return allMap;
    }

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }
}
