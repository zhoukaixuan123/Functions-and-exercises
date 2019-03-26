/**
 * @Auther: kaixuan
 * @Date: 2019/2/23 23:18
 * @Description:
 *
 *     创建多线程       静态代理的方式进行实现
 *
 *      cpu让出执行时间
 *      java 代码 自往依次运行
 *
 */
public class ManyThread  implements Runnable{
    private int num =10;

    @Override
    public void run() {
        synchronized (ManyThread.class){


        for(int i = 0;i<10;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num--+".....................");
        }
       }
    }

    public static void main(String[] args)throws Exception {





          ManyThread manyThread = new ManyThread();
          proxyClass p = new proxyClass(manyThread);
          Thread thread = new Thread(p);
          thread.start();


    }


}
class  proxyClass implements Runnable{
    private  ManyThread manyThread;

    public proxyClass(ManyThread manyThread){
         this.manyThread=manyThread;
    }

    @Override
    public void run() {
     manyThread.run();
    }
}