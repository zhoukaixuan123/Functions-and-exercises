/**
 * @Auther: kaixuan
 * @Date: 2019/3/26 13:19
 * @Description:
 *
 *   ��Сдת����ϰ
 *   ˼·��  ��д�ַ�  �� 32  ΪСд��ĸ
 *            �õ�������д��ĸתΪСд
 *            ����
 *
 */
public class ToLowerCaseDemo {

    public static void main(String[] args) {
        toLowerCase("zhoukx");
    }
    public static String toLowerCase(String str) {

        if(str.length() == 0){
            return str;
        }
        char[]  newStr =  str.toCharArray();
        for(int i = 0; i <newStr.length; i++){
            if(newStr[i] >= 'A' && newStr[i] < 'Z'){
                //�������е�ֵ ת��ΪСд
                newStr[i]  = (char)(newStr[i]+32);
            }
        }
        String newStri = String.valueOf(newStr);
        return newStri;
    }
}
