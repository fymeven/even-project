import com.even.common.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration("classpath:spring/spring-application.xml")
//无论成功与否都进行事务回滚
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class RedisTest {
    @Resource
    private RedisUtil redisUtil;
    @Test
    public void test() {
        String name = (String) redisUtil.get("name");
        System.out.println("name:>>>"+name);
    }
}
