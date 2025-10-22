import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T26 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
/*      外层循环，遍历每个可能的第一个元素
        n-2是因为需要至少3个元素组成三元组*/
        for (int i = 0; i < n - 2; i++) {
             /*跳过重复的第一个元素：
            i > 0 确保不是第一个元素
            nums[i] == nums[i-1] 检查是否与前一个元素相同
            如果相同则跳过，避免重复的三元组*/
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = n - 1;


            while (left < right){
                int sum =  nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                   /* 跳过左侧的重复元素：
                    确保left < right 防止越界
                    检查当前左指针元素是否与下一个相同
                    如果相同则向右移动左指针*/
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                    //如果和小于0，说明需要更大的数
                }else if (sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;

    }
}
