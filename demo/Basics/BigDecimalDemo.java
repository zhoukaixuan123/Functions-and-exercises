import java.math.BigDecimal;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/15 22:05
 * @Description:
 *
 *  Java 中应该使用什么数据类型来代表价格
 *
 *   如果不是特别关心内存和性能的话，使用BigDecimal，否则使用预定义精度的 double 类型
 *
 */

public class BigDecimalDemo {
    public static void main(String[] args) {
        bigTest();

    }



    /**
     *
     *  Java 中应该使用什么数据类型来代表价格
     *
     *   如果不是特别关心内存和性能的话，使用BigDecimal，否则使用预定义精度的 double 类型
     *
     */
    public static void bigTest(){
        BigDecimal a = new BigDecimal(100);//初始化BigDecimal
        BigDecimal b = new BigDecimal(20);//初始化BigDecimal
        BigDecimal c = new BigDecimal(123456.7897);//初始化BigDecimal

        //对象点  参数 相加  减
        //加  b+a
        System.out.println(b.add(a));
        //减  a -b
        System.out.println(a.subtract(b));
    }




}