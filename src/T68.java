public class T68 {
    public int lengthOfLIS(int[] nums) {
        //边界检查：如果输入数组为空或长度为0，直接返回0
        if(nums == null || nums.length == 0) return 0;
        //n：数组长度
        //tail 数组：核心数据结构
        //tail[i] 存储的是长度为 i+1 的所有递增子序列中，最小的末尾元素值
        //例如：tail[0] 存储长度为1的LIS的最小末尾值
        //len：当前找到的最长递增子序列的长度，初始为0
        int n = nums.length;
        int[] tail = new int[n]; // tail[i]: 长度为i+1的LIS的最小末尾值
        int len = 0;// 当前LIS长度

        //遍历数组中的每个数字
        //对每个数字 num，在 tail[0..len-1] 范围内进行二分查找
        //left = 0, right = len：搜索范围是 [0, len)，左闭右开
        for (int num : nums) {
            // 二分查找：在tail[0..len-1]中找到第一个 >= num 的位置
            int left = 0, right = len;
            while (left < right){
                //mid = left + (right - left) / 2：防止整数溢出，计算中间位置
                //if (tail[mid] < num)：如果中间值小于当前数字
                //说明 num 应该放在 mid 的右边，所以 left = mid + 1
                //else：如果中间值大于等于当前数字
                //说明找到了一个可能替换的位置，但可能左边还有更早的，所以 right = mid
                //循环继续直到 left == right，此时 left 就是第一个大于等于 num 的位置
                int mid = left + (right - left) / 2;
                if (tail[mid] < num){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            // 如果没找到比num大的，就追加到末尾
            //if (left == len)：说明 num 比 tail 中所有元素都大
            //可以扩展最长子序列：tail[len] = num 然后 len++
            //else：找到了第一个大于等于 num 的位置
            //用 num 替换 tail[left]，让该长度的子序列末尾值更小，便于后续扩展
            if (left == len){
                tail[len++] = num;
            }else {
                // 否则替换掉第一个 >= num 的元素
                tail[left] = num;
            }

        }
        return len;
    }
}
