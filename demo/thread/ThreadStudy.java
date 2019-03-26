/**
 * @Auther: kaixuan
 * @Date: 2019/2/23 22:12
 * @Description:
 */
public class ThreadStudy implements Runnable {

    @Override
    public void run() {
        System.out.println("ThreadA...................");
    }

    public static void main(String[] args)throws Exception {

         //继承实现
         //new ThreadStudy().start();
        // ThreadStudy start = new ThreadStudy();
        // Thread thread = new Thread(start);
         //thread.start();
         //匿名内部类写法
     /*   new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("Thread2。。。。");
            }
        }).start();*/




    }




}
