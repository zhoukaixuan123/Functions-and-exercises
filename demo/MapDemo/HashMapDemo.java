import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/27 15:50
 * @Description:
 */
public class HashMapDemo {


    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("01","hellp ");
        System.out.println(map.get("01"));

        Map<String,String> map1 = new LinkedHashMap<>(2);
        map1.put("°¢ÈøµÂ","ÄãºÃ");
        map1.put("ÖÜĞÇ³Û","°¢ÈøµÂ");
        map1.put("ÖÜ³Û","×¢Ïú");
        map1.put("ĞÇ³Û","°¡");

        System.out.println(map1.toString());
        System.out.println(map1.get("2"));
        System.out.println(map1.get("3"));


        Map<String,String> map2 = new TreeMap<>();
        map2.put("1","¿­Ğı1");
        map2.put("2","123124");
        map2.put("3","1231231231");

       System.out.println(map2.values());



    }
}
