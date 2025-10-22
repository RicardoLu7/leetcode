public class T57 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        // prev2 代表 dp[i-2]，即前前个房屋的最大金额
        int prev2 = 0;
        // prev1 代表 dp[i-1]，即前一个房屋的最大金额
        int prev1 = 0;
        for (int i = 0; i < n; i++) {
            // 计算当前房屋的最大金额
            // 选择1：不偷当前房屋，金额 = prev1
            // 选择2：偷当前房屋，金额 = prev2 + nums[i]
            int current = Math.max(prev1,prev2 + nums[i]);

            // 更新状态，为下一轮做准备
            prev2 = prev1;  // 当前的前一个变成下一轮的前前个
            prev1 = current; // 当前结果变成下一轮的前一个

        }
        return prev1;
    }

}
