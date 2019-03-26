import redis.clients.jedis.Jedis;

/**
 * @Auther: kaixuan
 * @Date: 2019/3/3 21:40
 * @Description:
 *    测试java  连接 redis 做缓存
 *    jedis-2.9.0.jar
 *
 */
public class redisDemo {

    //是否开启 redis  验证
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
