public class T62 {
    public int maximalSquare(char[][] matrix) {
        // 获取矩阵的行数和列数
        int m = matrix.length, n = matrix[0].length;
        // 创建dp数组，比原矩阵多一行一列，用于处理边界情况
        // dp[i+1][j+1] 表示以matrix[i][j]为右下角的最大正方形边长
        int[][] dp = new int[m + 1][n + 1];
        // 记录最大正方形的边长
        int max = 0;

        // 遍历原矩阵的每一个元素
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前元素是'1'，才有可能构成正方形
                if (matrix[i][j] == '1'){
                    dp[i + 1][j + 1] = Math.min(
                            Math.min(dp[i][j + 1],     // 上方的正方形边长
                                    dp[i + 1][j]),    // 左方的正方形边长
                            dp[i][j]                   // 左上角的正方形边长
                    ) + 1;
                    // 更新最大边长
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
                // 如果当前元素是'0'，dp[i+1][j+1]保持默认值0
            }
        }
        // 返回最大正方形的面积（边长平方）
        return max * max;
    }

}
