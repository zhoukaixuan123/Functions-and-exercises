import redis.clients.jedis.Jedis;

/**
 * @Auther: kaixuan
 * @Date: 2019/3/3 21:43
 * @Description:
 *    ���� redis
 *
 *
 */
public class redisDemo2
{
    //�ַ�������
    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //���� redis �ַ�������
        jedis.set("runoobkey", "www.runoob.com");
        // ��ȡ�洢�����ݲ����
        System.out.println("redis �洢���ַ���Ϊ: "+ jedis.get("runoobkey"));
    }
}
