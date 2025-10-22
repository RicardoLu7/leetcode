public class T66 {
    public int numSquares(int n) {
        // dp[i] 表示组成整数 i 需要的最少完全平方数的数量
        int[] dp = new int[n + 1];

        // 初始化，最坏情况是全部用1组成
        for (int i = 0; i <= n; i++) {
            dp[i] = i;  // 修正：应该是 i，不是 1
        }

        // 动态规划
        //从小到大计算每个数字的最优解
        for (int i = 1; i <= n; i++) {
            //尝试所有可能的完全平方数 j²，其中 j² ≤ i
            //示例：对于 i=12，j的取值范围是 1, 2, 3（因为 1²=1, 2²=4, 3²=9 都 ≤12）
            for (int j = 1; j * j <= i; j++) {
                //dp[i]：当前已知的最优解（初始化为最坏情况）
                //dp[i - j*j] + 1：使用一个 j² 平方数，加上组成剩余部分 i - j*j 所需的最少平方数
                //Math.min：取两者中的较小值
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


}
