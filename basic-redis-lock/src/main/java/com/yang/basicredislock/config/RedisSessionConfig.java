package com.yang.basicredislock.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/14 20:01
 * @Version 1.0
 * @qq: 1411091515
 */

@Configuration
public class RedisSessionConfig {

    /**
     * {@link  org.redisson.config.Config }
     *  config 的参数可以点进去看具体的
     *
     *
     * @return
     */
    @Bean
    public RedissonClient redisSession(){

        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);

        return redissonClient;
    }


}
