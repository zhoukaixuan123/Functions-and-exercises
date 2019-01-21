import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: kaixuan
 * @Date: 2019/1/19 12:02
 * @Description:
 *
 * 冒泡算法
 *
 *
 */
public class AlgorithmStudy {

    public static void main(String[] args) {

        //生成5个随机数
        int [] attr = new int[5];
        for(int j = 0;j<5;j++){
           attr[j] =(int)(Math.random()*10);
        }

        //控制台输入
        Scanner csan = new Scanner(System.in);
        int[] numb =new int[5];
        for (int i =0;i<5;i++){
            System.out.print("连续输入5个数，第"+i+"个");
            //接收控制台信息
            String str= csan.next();
            numb[i] = Integer.parseInt(str);
        }

        //g给两个数组的5个数进行冒泡排序
        for(int k =0;k<numb.length;k++){
            for(int m =0;m<numb.length-1;m++){
                int flag=0;
                //> 大于号从大到小  小于号  从小到大
                if(numb[k]<numb[m]){
                    flag =numb[k];
                    numb[k] =numb[m];
                    numb[m] =flag;

                }
            }
        }
        System.out.print(Arrays.toString(numb));
    }

}
