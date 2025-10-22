public class T31 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            // 判断左半部分是否有序
            if (nums[left] <= nums[mid]){
                // 左半部分有序
                if (nums[left] <= target && target < nums[mid]){
                    // 目标值在有序的左半部分
                    right = mid - 1;
                }else {
                    // 目标值在右半部分
                    left = mid + 1;
                }
            }else {
                // 右半部分有序
                if (nums[mid] < target && target <= nums[right]){
                    // 目标值在有序的右半部分
                    left = mid + 1;
                }else {
                    // 目标值在左半部分
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
