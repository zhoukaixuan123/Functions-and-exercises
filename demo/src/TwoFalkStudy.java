/**
 * @Auther: kaixuan
 * @Date: 2019/1/19 14:09
 * @Description:
 */
public class TwoFalkStudy {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        int  index = getIndex(arr,18);
        System.out.println("������λ���ڵ�"+index+"λ");

    }

    public static int getIndex(int []arr ,int key){
        /**
         *
         *   min  ��ʼλ��   Ҳ�������Ϊ��Сֵ
         *   max  ����λ��   ���ֵ
         *
         *   mid   �������м�λ��
         *   ��һ�� ��������м���бȽ�����������ҵĲ������� �м�������ֵ  ��ô  ��С��ֵ���м�+1
         *   ��������м���бȽ�����������ҵĲ���  С�� �м�������ֵ  ��ô  ����ֵ���м�-1
         *
         *   ������ֵ  С���� ��Сֵ˵��û���ҵ����ֵ  ����-1
         *
         */

        //��ʼλ��
        int min =0;
        //����λ��
        int max = arr.length-1;
        //����λ��
        int  mid= (max+min)/2;
        while(true){
           if(key >arr[mid]){
               min=mid+1;  // �м�ֵ��+1   ����Сֵ  ��������߲���
           }else if(key<arr[mid]){
               max=mid-1;  // �м�ֵ -1   �����ֵ ������ �ұߵĲ���
           }else{
               //�ҵ���Ԫ��  ��������Ԫ��
               return mid;
           }

           //û���ҵ������   ���С����Сֵ
            if(max<min){
               return -1;
            }

            //���¼����м�/����ֵ
            mid=(min+max)/2;

        }


    }

}
