public class T61 {
    public int findKthLargest(int[] nums, int k) {
/*        Arrays.sort(nums);
        return nums[nums.length - k];*/
        // 将"第k大"问题转换为"第k小"问题
        // 例如：在6个元素中找第2大的元素 = 找第(6-2)=4小的元素
        k = nums.length - k;// 转换为第k小的索引
        int left = 0,right = nums.length - 1;
        while (left < right){
            // 选择中间元素作为枢轴(pivot)，避免最坏情况
            int pivot = nums[left + (right - left) / 2];
            int i = left, j = right;
            // 分区循环：将数组分为三部分
            // [小于pivot的元素, 等于pivot的元素, 大于pivot的元素]
            while (i <= j){
                // 从左向右找到第一个 >= pivot 的元素
                while (nums[i] < pivot) i++;
                // 从右向左找到第一个 <= pivot 的元素
                while (nums[j] > pivot) j--;
                // 如果i<=j，说明找到了需要交换的元素对
                if (i <= j){
                    int temp = nums[i];
                    nums[i++] = nums[j];  // 交换后i右移
                    nums[j--] = temp;     // 交换后j左移
                }
            }
            // 根据k的位置决定下一步搜索哪个分区
            if (k <= j) {
                // k在左分区，继续在[left, j]中搜索
                right = j;
            } else if (k >= i) {
                // k在右分区，继续在[i, right]中搜索
                left = i;
            } else {
                // k在中间分区，已经找到目标元素
                break;
            }
        }
        // 返回第k小的元素，即原问题的第k大元素
        return nums[k];
    }
}
