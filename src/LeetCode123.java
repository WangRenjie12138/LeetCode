public class LeetCode123 {
    //买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        /*
        对于一天，考虑四个变量
        firstBuy  当天第一次花费的价格
        firstSell 在当天第一次卖出股票可获得最大收益
        secBuy    在当天第二次买入股票可获得的最大收益
        secSell   在当天第二次卖出股票可获得的最大收益
        */

        int firstBuy = Integer.MAX_VALUE, firstSell = 0;
        int secBuy = Integer.MAX_VALUE, secSell = 0;

        for(int p : prices){
            firstBuy = Math.min(firstBuy, p);
            firstSell = Math.max(firstSell, p - firstBuy);
            secBuy = Math.min(secBuy, p - firstSell);
            secSell = Math.max(secSell, p - secBuy);
        }
        return secSell;


        //动态规划算法，超时
        // int maxProfit = 0;
        // //假如只进行一笔交易
        // for(int i = 0; i < prices.length - 1; i++){
        //     for(int j = i + 1; j < prices.length; j++ ){
        //         int currentProfit1 = prices[j] - prices[i];

        //         //取当前较大利润作为最大利润
        //         if(currentProfit1 > maxProfit){
        //             maxProfit = currentProfit1;
        //         }

        //         //判断是否可尝试第二笔交易
        //         if(currentProfit1 > 0 && j < prices.length - 2){
        //             for(int k = j + 1; k < prices.length - 1; k++){
        //                 for(int l = k + 1; l < prices.length; l++){
        //                     int currentProfit2 =prices[l] - prices[k];

        //                     //判断两笔利润和是否大于最大利润
        //                     if(currentProfit1 + currentProfit2 > maxProfit){
        //                         maxProfit = currentProfit1 + currentProfit2;
        //                     }

        //                 }
        //             }
        //         }
        //     }
        // }
        // return maxProfit;
    }
    public static void main(String[] args){
        int[] test = {3, 3, 5, 0, 0, 3, 1, 4};
        LeetCode123 leet = new LeetCode123();
        System.out.println(leet.maxProfit(test));
    }
}
