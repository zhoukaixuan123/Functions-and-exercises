/**
 * @Auther: kaixuan
 * @Date: 2019/3/26 13:19
 * @Description:
 *
 *   大小写转换练习
 *   思路：  大写字符  加 32  为小写字母
 *            拿到单个大写字母转为小写
 *            返回
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
                //覆盖现有的值 转换为小写
                newStr[i]  = (char)(newStr[i]+32);
            }
        }
        String newStri = String.valueOf(newStr);
        return newStri;
    }
}
