import java.math.BigDecimal;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/15 22:05
 * @Description:
 *
 *  Java ��Ӧ��ʹ��ʲô��������������۸�
 *
 *   ��������ر�����ڴ�����ܵĻ���ʹ��BigDecimal������ʹ��Ԥ���徫�ȵ� double ����
 *
 */

public class BigDecimalDemo {
    public static void main(String[] args) {
        bigTest();

    }



    /**
     *
     *  Java ��Ӧ��ʹ��ʲô��������������۸�
     *
     *   ��������ر�����ڴ�����ܵĻ���ʹ��BigDecimal������ʹ��Ԥ���徫�ȵ� double ����
     *
     */
    public static void bigTest(){
        BigDecimal a = new BigDecimal(100);//��ʼ��BigDecimal
        BigDecimal b = new BigDecimal(20);//��ʼ��BigDecimal
        BigDecimal c = new BigDecimal(123456.7897);//��ʼ��BigDecimal

        //�����  ���� ���  ��
        //��  b+a
        System.out.println(b.add(a));
        //��  a -b
        System.out.println(a.subtract(b));
    }




}