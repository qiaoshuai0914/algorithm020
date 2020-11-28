public class Solution{
    /**
     * 两数之和
     * 数组中只有一个解，并且每个元素只能用一次
     * 利用哈希 时间复杂度是 O(n)  空间复杂度是 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public int[] twoSum(int[] nums,int target){
        for(int i = 0;i<nums.legth;i++){
            for(int j = i+1;j<nums.length ;j++){
                if(nums[i]+nums[j]=target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}