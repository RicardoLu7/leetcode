public class T38 {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // 当前能到达的最远位置

        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置已经超过了能到达的最远位置，说明无法到达
            if (i > maxReach) {
                return false;
            }
            // 更新能到达的最远位置
            maxReach = Math.max(maxReach, i + nums[i]);
            // 如果已经能到达或超过最后一个位置，提前返回
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
