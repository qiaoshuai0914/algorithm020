public class Solution_2 {
    /**
     * 旋转排序数组的最小值；
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，
     * 数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] 。
     * 请找出其中最小的元素。
     * 说明 数组中数组唯一；
     *
     * @param nums
     * @return [4, 5, 6, 7, 0, 1, 2]
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        //不能包含等于 证明如果等于。则不会有正确结果，要么死循环 要么结果不对；
        //二分搜索  边界问题1。数组长度为0 或者1 2的时候
        // 2 。 left = right时候
        // 3。while循环里面if条件==时候
        //4。right 和left  赋值的时候
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                //下标mid的值 可能为最小值，如果mid+1 可能会错过最小值；
                right = mid;
            } else if (nums[mid] > nums[right]){
                //因为nums[mid]>nums[right]且不存在相等，所以这时候mid肯定在大的一堆里面。
                left = mid + 1;
            }else if (nums[mid] == nums[right]){
               System.out.println(right);
                left= mid;
                break;
            }
        }

        return nums[left];
    }

    public static void main(String[] args){
        int[] nums= {3,4,5,1,2};
        Solution_2 solution_2 =new Solution_2();
        solution_2.findMin(nums);
    }
    /**
     * 33. 搜索旋转排序数组
     * 给你一个整数数组 nums ，和一个整数 target 。
     * <p>
     * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。
     * （例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] ）。
     * <p>
     * 请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
     * 1。nums  为很多的时候  left and right 接近的时候  right - left = 0  1  2
     * 可以判断 while循环条件   同时里面的大于等于
     * <p>
     * nums 为 0  1  2 的时候  是否可行
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            // a 起始点   b  中间最大值     c  末尾点
            //mid在 a和b之间包括ab；target 在b的右边；所以right不变  left =mid+1；
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
                // 当[0,mid]发生旋转时，向后规约条件
                //mid在 b和c之间；target 在b的右边；所以right不变  left =mid+1；
            } else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }
}
