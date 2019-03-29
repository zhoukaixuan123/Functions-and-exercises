/**
 * @Auther: kaixuan
 * @Date: 2019/3/27 13:08
 * @Description:
 *
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 *
 */
public class Test02 {

    public static void main(String[] args) {
       System.out.print( numJewelsInStones("sxc","svt"));
    }

    //给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
    // S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
    public static int numJewelsInStones(String J, String S) {
        char[] jj = J.toCharArray();//宝石类型
        char[] ss = S.toCharArray();//我的石头

        int num = 0;
        for(int i = 0 ;i<jj.length;i++){
            for(int m = 0 ;m<ss.length;m++){
                //如果宝石类型中  字符 与我的石头 中的 字符相等  就有一种宝石
              if(jj[i] == ss[m]){
                  num++;
              }
            }
        }
        return  num;
    }

}
