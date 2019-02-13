/**
 * @Auther: kaixuan
 * @Date: 2019/1/27 14:16
 * @Description:
 *
 *   遍历队列
 *
 */
public class QueueStudy {

    static final int defaultsize = 10;// 默认队列的长度
    int front; // 对头
    int rear; // 队尾
    int count;// 统计元素个数的计数器
    int maxSize; // 队的最大长度
    Object[] queue; // 队列，使用数组实现

    // 默认构造
    public QueueStudy() {
        init(defaultsize);
    }

    public QueueStudy(int size) {
        // 通过给定长度进行构造
        init(size);
    }
   //初始化
    public void init(int size) {
        maxSize = size;
        front = rear = 0;
        count = 0;
        queue = new Object[size];
    }

    //插入队里
    public void append(Object obj) throws Exception {
        // TODO Auto-generated method stub
        if (count > 0 && front == rear) {
            throw new Exception("队列已满");
        }
        // 队尾插入数据
        queue[rear] = obj;
        // 通过这种方法让对标索引值不停的重复！！！
        rear = (rear + 1) % maxSize;
        count++;
    }

    //删除方法
    public Object delete() throws Exception {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new Exception("队列为空");
        }
        // 去除对头的元素，同时修改对头的索引值
        Object obj = queue[front];
        // 对头索引值，一样通过+1驱魔运算来实现循环索引效果
        front = (front + 1) % maxSize;
        count--;
        return obj;
    }


    public Object getFront() throws Exception {
        // TODO Auto-generated method stub
        if (!isEmpty()) {
            return queue[front];
        } else {
            // 对为空返回null
            return null;
        }
    }

    //判断队列为空
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return count == 0;
    }

    public static void main(String[] args)throws Exception {
        QueueStudy queueStudy = new QueueStudy();
        queueStudy.append("你还的哦");
        queueStudy.append("123");
        queueStudy.delete();
        System.out.println("清空完成");
    }


}
