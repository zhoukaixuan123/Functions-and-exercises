import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: kaixuan
 * @Date: 2019/1/19 12:02
 * @Description:
 *
 * ð���㷨
 *
 *
 */
public class AlgorithmStudy {

    public static void main(String[] args) {

        //����5�������
        int [] attr = new int[5];
        for(int j = 0;j<5;j++){
           attr[j] =(int)(Math.random()*10);
        }

        //����̨����
        Scanner csan = new Scanner(System.in);
        int[] numb =new int[5];
        for (int i =0;i<5;i++){
            System.out.print("��������5��������"+i+"��");
            //���տ���̨��Ϣ
            String str= csan.next();
            numb[i] = Integer.parseInt(str);
        }

        //g�����������5��������ð������
        for(int k =0;k<numb.length;k++){
            for(int m =0;m<numb.length-1;m++){
                int flag=0;
                //> ���ںŴӴ�С  С�ں�  ��С����
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
