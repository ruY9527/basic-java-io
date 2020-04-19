package com.yang.basicjavacache.redis.utils;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-4-19
 *
 *  Author          : Gavin
 *
 *  Purpose         :
 *
 *  History         : TODO : Redisson 如果是集群的环境,是采用这个来进行处理吗？
 *
 *</PRE>
 ***************************************************************************/
public class RedisTool {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 尝试获取 分布式锁
     * 我们使用key来当锁，因为key是唯一的。
     * 原因就是我们在上面讲到可靠性时，分布式锁要满足第四个条件解铃还须系铃人，通过给value赋值为requestId，
     * 我们就知道这把锁是哪个请求加的了，在解锁的时候就可以有依据。requestId可以使用UUID.randomUUID().toString()方法生成
     *
     * 这个参数我们填的是NX，意思是SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作
     * 这个参数我们传的是PX，意思是我们要给这个key加一个过期的设置，具体时间由第五个参数决定
     * 设置超时时期
     * @param jedis
     * @param localKey
     * @param requestId  请求表示
     * @param expireTime 超时时间
     * @return
     */
    public static boolean tryGetDistributedLock(Jedis jedis,String localKey,String requestId,int expireTime){
        return LOCK_SUCCESS.equalsIgnoreCase(jedis.set(localKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime));
    }

    /**
     * 释放锁
     * requestId : 请求标识
     * @param jedis
     * @param localKey
     * @param requestId
     * @return
     *
     * 不能直接使用 jedis.del(lockKey) 来删除锁,可能当前进来的锁并不是 先前判断出锁的拥有者
     *
     */
    public static boolean releaseDistributedLock(Jedis jedis,String localKey,String requestId){
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(localKey), Collections.singletonList(requestId));
        return RELEASE_SUCCESS.equals(result);
    }

    /**
     *  先使用 setnx , 在使用 expire ; 如果在expire 之前出现错误的话,那么这个锁不能被释放掉.
     *   Long result = jedis.setnx(lockKey, requestId);
     *     if (result == 1) {
     *         // 若在这里程序突然崩溃，则无法设置过期时间，将发生死锁
     *         int i = 1 / 0;
     *         jedis.expire(lockKey, expireTime);
     *     }
     *
     *
     *  分布式情况下,每台server 之间都需要进行时间同步的问题.
     *  由于是客户端自己生成的过期时间,所以需要强制在分布式下每个客户端的时间必须同步.
     *  当锁过期的时候,如果多个客户端同时执行 jedis.getSet()方法,虽然只有一个客户端可以加锁,但是这个客户端的过期时间可能被其他客户端覆盖.
     *  long expires = System.currentTimeMillis() + expireTime;
     *     String expiresStr = String.valueOf(expires);
     *
     *     // 如果当前锁不存在，返回加锁成功
     *     if (jedis.setnx(lockKey, expiresStr) == 1) {
     *         return true;
     *     }
     *
     *     // 如果锁存在，获取锁的过期时间
     *     String currentValueStr = jedis.get(lockKey);
     *     if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
     *         // 锁已过期，获取上一个锁的过期时间，并设置现在锁的过期时间
     *         String oldValueStr = jedis.getSet(lockKey, expiresStr);
     *         if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
     *             // 考虑多线程并发的情况，只有一个线程的设置值和当前值相同，它才有权利加锁
     *             return true;
     *         }
     *     }
     *
     *     // 其他情况，一律返回加锁失败
     *     return false;
     *
     *
     *
     */

}
