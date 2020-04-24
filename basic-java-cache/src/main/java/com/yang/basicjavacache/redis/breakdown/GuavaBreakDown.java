package com.yang.basicjavacache.redis.breakdown;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;

/**
 * @Author: Mu_Yi
 * @Date: 2020/4/19 22:34
 * @Version 1.0
 * @qq: 1411091515
 *
 *  布隆过滤器
 *  guava 实现的布隆过滤器, bloomfilter 就类似于一个 hash set,用于快速判某个元素是否存在于集合,
 *  其典型的 应用场景 就是快速判断某个key是否存在于某容器
 *
 *  可以看到，100w个数据中只消耗了约0.2毫秒就匹配到了key，速度足够快。然后模拟了1w个不存在于布隆过滤器中的key，
 *  匹配错误率为318/10000，
 *  也就是说，出错率大概为3%，跟踪下BloomFilter的源码发现默认的容错率就是0.03：
 */
public class GuavaBreakDown {

    private static final int capacity	= 1000000;
    private static final int key		= 999998;
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create( Funnels.integerFunnel(), capacity );

    private BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")),capacity);
    static {
        for (int i=0;i<capacity;i++){
            bloomFilter.put(i);
        }
    }

    public String getKey(String key){
        // 模拟从 缓存中获取出来
        String value = "";
        if(StringUtils.isEmpty(value)){
            if(filter.mightContain(key)){
                // 模拟 调用业务代码Service来通过Key获取出Value的信息
                value = "";
                // 设置到缓存中去 ; 这里是还有一个设置到缓存中的实现
                filter.put(value);
                return value;
            } else {
                return null;
            }
        }
        return value;
    }

    public static void main(String[] args) {

        long start = System.nanoTime();
        if ( bloomFilter.mightContain( key ) ) {
            System.out.println( "成功过滤到" + key );
        }
        long end = System.nanoTime();
        System.out.println( "布隆过滤器消耗时间:" + (end - start) );
        int sum = 0;
        for ( int i = capacity + 20000; i < capacity + 30000; i++ )
        {
            if ( bloomFilter.mightContain( i ) )
            {
                sum = sum + 1;
            }
        }
        System.out.println( "错判率为:" + sum );
    }

}
