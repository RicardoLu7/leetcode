public class T25 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right){
            // 计算当前容量
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // 更新最大容量
            maxArea = Math.max(maxArea, currentArea);
            // 移动高度较小的指针
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
