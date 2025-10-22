import java.util.Arrays;

public class T40 {
    public int uniquePaths(int m, int n) {
        // 只需要一维数组存储上一行的结果
        int[] dp = new int[n];
        // 初始化第一行，每个位置只有一条路径（一直向右）
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[j] 代表上一行当前列的值（即从上方来的路径数）
                // dp[j-1] 代表当前行前一列的值（即从左方来的路径数）
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
