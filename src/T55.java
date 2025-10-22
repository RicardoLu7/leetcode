public class T55 {
    public int maxProduct(int[] nums) {
        //检查输入数组是否为空或长度为0
        //如果是，直接返回0（因为空数组没有乘积）
        if (nums == null || nums.length == 0) return 0;
        //maxProd：记录以当前位置结尾的子数组的最大乘积
        //minProd：记录以当前位置结尾的子数组的最小乘积（重要：因为有负数）
        //result：记录全局最大乘积结果
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        //从第2个元素开始遍历（索引1）
        //因为第一个元素已经在初始化时处理过了
        for (int i = 1; i < nums.length; i++) {
            //原因：负数会让大的数变小，小的数变大
            //示例：如果当前maxProd=6，minProd=-2，遇到负数-3
            //不交换：6×(-3)=-18，-2×(-3)=6 → 最大值变成6
            //交换后：-2×(-3)=6，6×(-3)=-18 → 最大值还是6，但逻辑更清晰
            if (nums[i] < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;

            }
            //maxProd：取当前数字本身或当前数字×之前最大乘积的较大值
            //minProd：取当前数字本身或当前数字×之前最小乘积的较小值
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);

            // 更新全局最大值
            result = Math.max(result,maxProd);
        }
        return result;
    }
}
