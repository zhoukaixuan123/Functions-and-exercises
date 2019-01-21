/**
 * @Auther: kaixuan
 * @Date: 2019/1/19 13:37
 * @Description:
 *
 *   递归方法演示
 *
 */

public class RecursionStudy {

    public static void main(String[] args) {
      String str =   getIndex(90);
      System.out.println(str);
    }

    public static String  getIndex(int param ){

        if(param<100){
            param--;
            if(param==80){
                return "参数到80我结束了";
            }
        }else {
            return "参数大于100不接收";

        }

         return  getIndex(param);
    }


}
