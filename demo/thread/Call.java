import java.util.concurrent.*;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/24 00:53
 * @Description:
 *
 *
 *      ������  �����̵߳ķ���  ����
 *   ���ַ�ʽ�з���ֵ
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
        //callballe  �����߳�
        ExecutorService ser =Executors.newFixedThreadPool(1);
        Call call = new Call();
        //�Ѽ̳нӿڵ�ʵ������뵽����
        Future<Integer> future =  ser.submit(call);
        int num =  future.get();
        ser.shutdown();
       System.out.print(num);
    }

}
