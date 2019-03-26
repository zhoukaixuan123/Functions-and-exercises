/**
 * @Auther: kaixuan
 * @Date: 2019/2/24 16:19
 * @Description:
 *
 *    死锁   模拟线程死锁
 *    过多的用不会造成死锁
 */
public class DeadSynDemo {


    public static void main(String[] args) {
        Object g = new Object();
        Object m = new Object();

        Test test1 = new Test(g,m);
        Test2 test2 = new Test2(g,m);
        Thread thread = new Thread(test1);
        Thread thread2 = new Thread(test2);
        thread.start();
        thread2.start();
    }

}
class Test implements Runnable{
    Object goods;
    Object money ;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }
    @Override
    public void run() {
         while (true){
             test();
         }
    }

    public void  test(){
        synchronized (goods){
            try {
                Thread.sleep(500);
            }catch (Exception e){

            }
        }
            synchronized (money){

            }
            System.out.println("getMoney+++++++");
        }

}

class Test2 implements Runnable{
    Object goods;
    Object money ;

    public Test2(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true){
            test();
        }
    }

    public void  test(){
        synchronized (goods){
            try {
                Thread.sleep(500);
            }catch (Exception e){

            }
        }
        synchronized (money){

        }
        System.out.println("getgoods+++++++");
    }

}