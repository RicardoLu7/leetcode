public class T32 {
    public int[] searchRange(int[] nums, int target) {
        int left = findBound(nums,target,true);
        int right = findBound(nums,target,false);
        return new int[]{left,right};
        
    }

    private int findBound(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right){
            // 计算中间位置，使用 left + (right - left)/2 避免整数溢出
            int mid = left + (right - left) / 2;
            // 情况1：中间值等于目标值
            if (nums[mid] == target){
                index = mid;
                // 根据查找的是左边界还是右边界来决定搜索方向
                if (isLeft){
                    // 如果是查找左边界，继续向左搜索看是否有更早的出现
                    right = mid - 1;
                }else {
                    // 如果是查找右边界，继续向右搜索看是否有更晚的出现
                    left = mid + 1;
                }
                // 情况2：中间值小于目标值，目标值在右半部分
            }else if (nums[mid] < target){
                left = mid + 1;
                // 情况3：中间值大于目标值，目标值在左半部分
            }else {
                right = mid - 1;

            }
        }
        return index;
    }
}
