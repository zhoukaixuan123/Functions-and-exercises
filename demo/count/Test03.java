import java.util.Arrays;

/**
 * @Auther: kaixuan
 * @Date: 2019/3/27 13:19
 * @Description:
 * ����һ�����ǵݼ�˳��������������� A������ÿ�����ֵ�ƽ����ɵ������飬Ҫ��Ҳ���ǵݼ�˳������
 *
 */
public class Test03 {

    public static void main(String[] args) {
          int [] m =  {1,10,-1,20};
       System.out.print(Arrays.toString(sortedSquares(m)));
    }
    public static int[] sortedSquares(int[] A) {
        int [] num = new int[A.length];

        for(int i  = 0 ;i < A.length;i++){
            num[i] = (int)Math.pow(A[i],2);
        }
        Arrays.sort(num);
        return num;
    }
}
