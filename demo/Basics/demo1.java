/**
 * @Auther: kaixuan
 * @Date: 2019/3/6 18:43
 * @Description:
 */
public class demo1 {

    public static void main(String[] args) {


        int [] nums =  {2,5,5,11};
        int [] arr =getArr(nums,10);

        System.out.println(arr[0]+"+++++++"+arr[1]);
    }


    public static int[] getArr(int []nums, int  target){

        int [] arr = new int[2];

        for(int i =0 ;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target ){
                    arr[0] =i;
                    arr[1] =j;
                    return arr;
                }

            }
        }
        return null;
    }
}
