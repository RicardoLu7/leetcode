public class T37 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 对于每个元素，选择：要么加入前面的子数组，要么重新开始
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新全局最大值
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
