/**
 * @Auther: kaixuan
 * @Date: 2019/3/27 13:08
 * @Description:
 *
 *  �����ַ���J ����ʯͷ�б�ʯ�����ͣ����ַ��� S������ӵ�е�ʯͷ�� S ��ÿ���ַ�������һ����ӵ�е�ʯͷ�����ͣ�����֪����ӵ�е�ʯͷ���ж����Ǳ�ʯ��
 *
 * J �е���ĸ���ظ���J �� S�е������ַ�������ĸ����ĸ���ִ�Сд�����"a"��"A"�ǲ�ͬ���͵�ʯͷ��
 *
 * ʾ�� 1:
 *
 * ����: J = "aA", S = "aAAbbbb"
 * ���: 3
 * ʾ�� 2:
 *
 * ����: J = "z", S = "ZZ"
 * ���: 0
 * ע��:
 *
 * S �� J ��ຬ��50����ĸ��
 *  J �е��ַ����ظ���
 *
 */
public class Test02 {

    public static void main(String[] args) {
       System.out.print( numJewelsInStones("sxc","svt"));
    }

    //�����ַ���J ����ʯͷ�б�ʯ�����ͣ����ַ��� S������ӵ�е�ʯͷ��
    // S ��ÿ���ַ�������һ����ӵ�е�ʯͷ�����ͣ�����֪����ӵ�е�ʯͷ���ж����Ǳ�ʯ��
    public static int numJewelsInStones(String J, String S) {
        char[] jj = J.toCharArray();//��ʯ����
        char[] ss = S.toCharArray();//�ҵ�ʯͷ

        int num = 0;
        for(int i = 0 ;i<jj.length;i++){
            for(int m = 0 ;m<ss.length;m++){
                //�����ʯ������  �ַ� ���ҵ�ʯͷ �е� �ַ����  ����һ�ֱ�ʯ
              if(jj[i] == ss[m]){
                  num++;
              }
            }
        }
        return  num;
    }

}
