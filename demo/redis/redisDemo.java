import redis.clients.jedis.Jedis;

/**
 * @Auther: kaixuan
 * @Date: 2019/3/3 21:40
 * @Description:
 *    ����java  ���� redis ������
 *    jedis-2.9.0.jar
 *
 */
public class redisDemo {

    //�Ƿ��� redis  ��֤
    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
    }
}
