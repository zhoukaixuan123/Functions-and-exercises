/**
 * @Auther: kaixuan
 * @Date: 2019/2/24 12:56
 * @Description:
 *
 *    线程阻塞
 *
 *
 */
public class JoinDemo  implements Runnable{

    @Override
    public void run() {
        for(int i  = 0;i<1000;i++){
            System.out.println("Thread++++++++++");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinDemo= new JoinDemo();
        Thread thread = new Thread(joinDemo);
        thread.start();

        for(int i =0;i<1000;i++){
            if(100 == i){
               // thread.join(); //阻塞当前线程
                Thread.yield();  //让出当前线程
            }
            System.out.println("main"+"============="+i);
        }

    }
}
