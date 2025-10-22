public class T67 {
    public int findDuplicate(int[] nums) {
        //slow 和 fast 都从数组的第一个元素开始
        //注意：这里不是从索引0开始走，而是直接取 nums[0] 的值作为起始位置
        //例如 nums = [1,3,4,2,2]：slow = nums[0] = 1，fast = nums[0] = 1
        int slow = nums[0];
        int fast = nums[0];

        // 第一阶段：找到相遇点
        do{
            //slow = nums[slow]：慢指针每次走一步
            //fast = nums[nums[fast]]：快指针每次走两步
            //循环继续直到 slow == fast，说明在环内相遇
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        // 第二阶段：找到环的入口
        //将快指针重置到起点（索引0的位置）
        //注意：这里重置的是位置，不是值，所以是 fast = nums[0]
        fast = nums[0];
        while (slow != fast){
            //现在两个指针都每次只走一步
            //当它们再次相遇时，相遇点就是环的入口，也就是重复的数字
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
