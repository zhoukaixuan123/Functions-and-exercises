/**
 * @Auther: kaixuan
 * @Date: 2019/1/27 14:16
 * @Description:
 *
 *   ��������
 *
 */
public class QueueStudy {

    static final int defaultsize = 10;// Ĭ�϶��еĳ���
    int front; // ��ͷ
    int rear; // ��β
    int count;// ͳ��Ԫ�ظ����ļ�����
    int maxSize; // �ӵ���󳤶�
    Object[] queue; // ���У�ʹ������ʵ��

    // Ĭ�Ϲ���
    public QueueStudy() {
        init(defaultsize);
    }

    public QueueStudy(int size) {
        // ͨ���������Ƚ��й���
        init(size);
    }
   //��ʼ��
    public void init(int size) {
        maxSize = size;
        front = rear = 0;
        count = 0;
        queue = new Object[size];
    }

    //�������
    public void append(Object obj) throws Exception {
        // TODO Auto-generated method stub
        if (count > 0 && front == rear) {
            throw new Exception("��������");
        }
        // ��β��������
        queue[rear] = obj;
        // ͨ�����ַ����öԱ�����ֵ��ͣ���ظ�������
        rear = (rear + 1) % maxSize;
        count++;
    }

    //ɾ������
    public Object delete() throws Exception {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new Exception("����Ϊ��");
        }
        // ȥ����ͷ��Ԫ�أ�ͬʱ�޸Ķ�ͷ������ֵ
        Object obj = queue[front];
        // ��ͷ����ֵ��һ��ͨ��+1��ħ������ʵ��ѭ������Ч��
        front = (front + 1) % maxSize;
        count--;
        return obj;
    }


    public Object getFront() throws Exception {
        // TODO Auto-generated method stub
        if (!isEmpty()) {
            return queue[front];
        } else {
            // ��Ϊ�շ���null
            return null;
        }
    }

    //�ж϶���Ϊ��
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return count == 0;
    }

    public static void main(String[] args)throws Exception {
        QueueStudy queueStudy = new QueueStudy();
        queueStudy.append("�㻹��Ŷ");
        queueStudy.append("123");
        queueStudy.delete();
        System.out.println("������");
    }


}
