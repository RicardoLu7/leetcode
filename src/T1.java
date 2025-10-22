import java.util.HashMap;

public class T1 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(hashmap.containsKey(complement)){
                return new int[]{hashmap.get(complement),i};
            }
            hashmap.put(nums[i],i);
        }
        return new int[0];
    }
}
