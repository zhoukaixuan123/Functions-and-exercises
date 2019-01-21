/**
 * @Auther: kaixuan
 * @Date: 2019/1/19 14:09
 * @Description:
 */
public class TwoFalkStudy {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        int  index = getIndex(arr,18);
        System.out.println("索引的位置在第"+index+"位");

    }

    public static int getIndex(int []arr ,int key){
        /**
         *
         *   min  开始位置   也可以理解为最小值
         *   max  结束位置   最大值
         *
         *   mid   索引的中间位置
         *   第一次 从数组的中间进行比较如果，所查找的参数大于 中间索引的值  那么  最小的值进行加+1
         *   从数组的中间进行比较如果，所查找的参数  小于 中间索引的值  那么  最大的值进行加-1
         *
         *   如果最大值  小于了 最小值说明没有找到这个值  返回-1
         *
         */

        //开始位置
        int min =0;
        //结束位置
        int max = arr.length-1;
        //索引位置
        int  mid= (max+min)/2;
        while(true){
           if(key >arr[mid]){
               min=mid+1;  // 中间值加+1   是最小值  舍弃了左边部分
           }else if(key<arr[mid]){
               max=mid-1;  // 中间值 -1   是最大值 舍弃了 右边的部分
           }else{
               //找到了元素  返回索引元素
               return mid;
           }

           //没有找到的情况   最大小于最小值
            if(max<min){
               return -1;
            }

            //重新计算中间/索引值
            mid=(min+max)/2;

        }


    }

}
