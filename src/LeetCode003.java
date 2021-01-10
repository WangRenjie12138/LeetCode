import java.util.HashMap;

public class LeetCode003 {
    public int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;
        }
        String[] alpha = s.split("");
        HashMap <String,Integer> hm = new HashMap<>();
        int i = 0, count =0, index = 0;
        while(i<alpha.length){
            Character cur = s.charAt(i);
            if(hm.containsKey(alpha[i])){
                count = count>hm.get(alpha[i-1]) ? count : hm.get(alpha[i-1]);

                //将i回溯至重复字符的下一个位置
                i = i - (index - hm.get(alpha[i]));

                //重置
                hm.clear();
                index = 1;

                hm.put(alpha[i],index);
                i++;
                continue;
            }
            else{
                index++;
                hm.put(alpha[i],index);
                i++;
            }
            if(i==alpha.length){
                count = count>hm.get(alpha[i-1]) ? count : hm.get(alpha[i-1]);
            }

        }
        System.out.println(count);
        return count;

        //下面的做法错误，因为缺少回溯，导致会算少
//        String[] alpha = s.split("");
//        HashMap <String,Integer> hm = new HashMap<>();
//        int i = 0, count =0, index = 0;
//        while(i<alpha.length){
//            if(hm.containsKey(alpha[i])){
//                count = count>hm.get(alpha[i-1]) ? count : hm.get(alpha[i-1]);
//
//                //重置
//                hm.clear();
//                index = 1;
//
//                hm.put(alpha[i],index);
//                i++;
//                continue;
//            }
//            else{
//                index++;
//                hm.put(alpha[i],index);
//                i++;
//            }
//            if(i==alpha.length){
//                count = count>hm.get(alpha[i-1]) ? count : hm.get(alpha[i-1]);
//            }
//
//        }
//        System.out.println(count);
//        return count;
    }
    public static void main(String[] args){
        LeetCode003 leet = new LeetCode003();
        leet.lengthOfLongestSubstring("dvdf");
    }
}
