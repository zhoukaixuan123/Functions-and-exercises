/**
 * @Auther: kaixuan
 * @Date: 2019/2/15 21:29
 * @Description:
 *
 *    �߳��е�  ��������      ���synchronized  ������С
 *
 *
 *
 */
public class VolatieTes{

    /***
     *
     *  ÿ���̶߳����Լ���  �����ڴ棬������ɱ������ܹ���
     *  ֻ�������ڴ���  �������ܹ���
     *
     *  volatile  �Ĺؼ���  �ڶ��߳������ ȷ���������������ڴ浱��
     *
     *
     */

    volatile  boolean  status = false;

     //�л�״̬
     public void  changeStatus(){
         status =true;
     }


     //�ڵ���changeStatus  �����߳�
     public void  run(){
         if(status){
             System.out.println("���");
         }

     }


    public static void main(String[] args) {
         //volate   ʹ��
      /*  VolatieTes volatieTes = new VolatieTes();
        volatieTes.changeStatus();
        volatieTes.run();*/



    }


}
