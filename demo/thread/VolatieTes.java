/**
 * @Auther: kaixuan
 * @Date: 2019/2/15 21:29
 * @Description:
 *
 *    线程中的  轻量级锁      相比synchronized  开销较小
 *
 *
 *
 */
public class VolatieTes{

    /***
     *
     *  每个线程都有自己的  工作内存，这样造成变量不能共享。
     *  只有在主内存中  变量才能共享
     *
     *  volatile  的关键字  在多线程情况下 确保变量共享在主内存当中
     *
     *
     */

    volatile  boolean  status = false;

     //切换状态
     public void  changeStatus(){
         status =true;
     }


     //在掉用changeStatus  后开启线程
     public void  run(){
         if(status){
             System.out.println("你好");
         }

     }


    public static void main(String[] args) {
         //volate   使用
      /*  VolatieTes volatieTes = new VolatieTes();
        volatieTes.changeStatus();
        volatieTes.run();*/



    }


}
