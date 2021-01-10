import java.util.ArrayList;
import java.util.List;
public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        int isFirst = 1;
        int isLast = 0;
        int firstOne = nums[0];
        int temp = nums[0]-1;
        int i = 1;
        ArrayList<String> list = new ArrayList<>();
        for(int p:nums){
            if(p != temp + 1){
                isFirst = 1;
                isLast = 1;
            }

            if(isLast == 1){
                if(temp != firstOne) {
                    list.add(Integer.toString(firstOne) + "->" + Integer.toString(temp));
                }
                else{
                    list.add(Integer.toString(firstOne));
                }
                isLast = 0;
            }

            if(isFirst == 1){
                isFirst = 0;
                firstOne = p;
            }
            temp = p;
            //判断是否为最后一个
            if(nums.length == i) {
                if (temp != firstOne) {
                    list.add(Integer.toString(firstOne) + "->" + Integer.toString(temp));
                } else {
                    list.add(Integer.toString(isFirst));
                }
            }
            i++;

        }
        return list;
    }

    public static void main(String[] args){
        int[] a = {0, 1, 2, 4, 5, 7};
        LeetCode228 leet = new LeetCode228();
        leet.summaryRanges(a);
    }
}
