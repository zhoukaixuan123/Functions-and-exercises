import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Auther: kaixuan
 * @Date: 2019/3/3 21:44
 * @Description:
 */
public class redisDemo3 {

    //list����
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //�洢���ݵ��б���
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // ��ȡ�洢�����ݲ����
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("�б���Ϊ: "+list.get(i));
        }

        RedisKeyJava();
    }

    //
    public  static void  RedisKeyJava(){
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");

        // ��ȡ���ݲ����
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
}
