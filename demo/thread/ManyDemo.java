/**
 * @Auther: kaixuan
 * @Date: 2019/2/23 23:18
 * @Description:
 *
 *     创建多线程
 *
 *     模拟 抢票系统
 *
 */
public class ManyDemo implements Runnable{
    //还有50张票
    private int num =50;

    @Override
    public synchronized void run() {


        while(true){
            if(num<= 0){
                System.out.println("one++++++");
                break;
            }
            try {
                Thread.sleep(100);
            }catch (Exception e){

            }
            System.out.println(Thread.currentThread().getName()+"........"+num--);

        }
    }

    public static void main(String[] args)throws Exception {





        ManyDemo manyThread = new ManyDemo();
        Thread thread1 = new Thread(manyThread,"tome");
        Thread thread2 = new Thread(manyThread,"zee");
        Thread thread3 = new Thread(manyThread,"poo");
        thread1.start();
        thread2.start();
        thread3.start();


    }


}