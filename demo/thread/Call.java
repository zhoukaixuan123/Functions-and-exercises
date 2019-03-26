import java.util.concurrent.*;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/24 00:53
 * @Description:
 *
 *
 *      第三种  创建线程的方法  区别
 *   这种方式有返回值
 *
 *
 *
 */
public class Call implements Callable<Integer> {

    @Override
    public Integer call() {
        return 1000;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //callballe  创建线程
        ExecutorService ser =Executors.newFixedThreadPool(1);
        Call call = new Call();
        //把继承接口的实体类放入到里面
        Future<Integer> future =  ser.submit(call);
        int num =  future.get();
        ser.shutdown();
       System.out.print(num);
    }

}
