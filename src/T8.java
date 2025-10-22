public class T8 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min_price = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < min_price){
                min_price = price;
            }
            else if (price - min_price > maxProfit){
                maxProfit = price - min_price;
            }
        }
        return maxProfit;
    }
}
