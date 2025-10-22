public class T64 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 第一步：计算左侧所有元素的乘积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 第二步：计算右侧所有元素的乘积并同时更新结果
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--){
            answer[i] = answer[i] * rightProduct; // 左侧乘积 × 右侧乘积
            rightProduct *= nums[i]; // 更新右侧乘积
        }

        return answer;
    }
}
