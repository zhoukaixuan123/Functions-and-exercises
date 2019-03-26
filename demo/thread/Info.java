/**
 * @Auther: kaixuan
 * @Date: 2019/2/24 20:06
 * @Description:
 */
public class Info {
    private String name;
    private String content;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}


//生产者
class Producer implements Runnable{
    private Info info=null;
    public Producer(Info info){
        this.info=info;
    }
    public synchronized   void run(){

        for(int i=0;i<10;++i)
        {
            if(i%2== 0){
                this.info.setName("啤酒");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.info.setContent("100ML");
            }else {
                this.info.setName("大饼");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.info.setContent("一斤");
            }

            System.out.println("生产者生产了："+this.info.getName()+"------>"+this.info.getContent());
        }
    }
}

//消费者
class Consumer implements Runnable{
    private Info info=null;
    public Consumer(Info info){
        this.info=info;
    }
    public synchronized   void run(){
        for(int i=0;i<10;i++)
        {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者："+this.info.getName()+"------>"+this.info.getContent());
        }
    }
};