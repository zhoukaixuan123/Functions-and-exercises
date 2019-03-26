import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/24 16:50
 * @Description:
 *
 *
 *
 *           任务调度定时器
 */
public class TimerDemo {

    public static void main(String[] args) {
        Timer  timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("so easy..................");
            }
        },new Date(System.currentTimeMillis()+1000),200);


    }
}
