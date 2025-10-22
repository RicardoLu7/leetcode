public class T70 {
    public int coinChange(int[] coins, int amount) {
        // 边界情况处理
        if (amount == 0) return 0;                    // 金额为0，不需要任何硬币
        if (coins == null || coins.length == 0) return -1; // 没有硬币，无法凑出任何金额

        // dp数组定义：dp[i]表示凑出金额i所需的最少硬币数量
        int[] dp = new int[amount + 1];

        // 初始化：除了dp[0]=0外，其他初始化为一个不可能的大值
        // 使用amount+1作为"无穷大"，因为最多只需要amount个1元硬币
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0; // 凑出金额0需要0个硬币

        // 动态规划填表 - 关键修正：i <= amount 而不是 i < amount
        for (int i = 1; i <= amount; i++) {
            // 遍历所有硬币面额
            for (int coin : coins) {
                // 如果当前硬币可以用（面额不超过目标金额）
                if (coin <= i) {
                    // 关键修正：使用Math.min而不是Math.max
                    // 我们要求的是最少硬币数，所以取最小值
                    dp[i] = Math.min(
                            dp[i],              // 当前已知的最小硬币数
                            dp[i - coin] + 1    // 使用当前硬币后的硬币数
                    );
                }
            }
        }

        // 结果判断：如果dp[amount]仍然大于amount，说明无法凑出
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
