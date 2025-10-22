public class T43 {
    public void sortColors(int[] nums) {
        int left = 0;// 指向0的右边界
        int right = nums.length - 1;// 指向2的左边界
        int current = 0;// 当前遍历指针

        while (current <= right){
            if (nums[current] == 0){
                // 遇到0，交换到左边
                swap(nums,left,current);
                left++;
                current++;
            }else if (nums[current] == 2){
                // 遇到2，交换到右边
                swap(nums,current,right);
                right--;
                // 注意：这里current不增加，因为从右边交换过来的元素还没检查
            }else {
                // 遇到1，直接跳过
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
