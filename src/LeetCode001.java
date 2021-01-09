import java.util.HashMap;
import java.util.Arrays;

public class LeetCode001 {
    public int[] twoSum(int[] nums, int target) {
        //使用hashmap
        int[] index = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(nums[i])){
                index[0] = hm.get(nums[i]);
                index[1] = i;
                break;
            }
            hm.put(target - nums[i], i);
        }
        return index;
        //时间复杂度O(n)


        //暴力求解法，复杂度为O(n^2)
        // int[] result = new int[2];
        // for(int i = 0; i < nums.length - 1; i++){
        //     int sub = target - nums[i];
        //     for(int j = i + 1; j < nums.length; j++){
        //         if(nums[j] == sub){
        //             result[0] = i;
        //             result[1] = j;
        //             return result;
        //         }
        //     }
        // }
        // return null;
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 18;
        LeetCode001 leet = new LeetCode001();
        int[] arr = leet.twoSum(nums,target);
        System.out.println(Arrays.toString(arr));
    }

}
