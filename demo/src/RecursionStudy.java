/**
 * @Auther: kaixuan
 * @Date: 2019/1/19 13:37
 * @Description:
 *
 *   �ݹ鷽����ʾ
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
                return "������80�ҽ�����";
            }
        }else {
            return "��������100������";

        }

         return  getIndex(param);
    }


}
