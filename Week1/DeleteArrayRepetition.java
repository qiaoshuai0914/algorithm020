
/*26. 删除排序数组中的重复项*/
public class DeleteArrayRepetition {

    public static void main(String[] args)throws Exception {
            int[] nums ={0,0,1,1,1,2,2,3,3,4};
            deleteRepetition(nums);
            for(int i =0 ;i< nums.length;i++){
                System.out.println(nums[i]);

            }

    }

    public static int deleteRepetition(int[] nums) {
        int l = nums.length;
        int i = 0;
        int j = 0;
        for (; j < l; j++) {
            if (i != j) {
                if (nums[j] != nums[i]) {
                    int temp = nums[j];
                    if(i+1!=j){
                        nums[i + 1] = temp;
                    }
                    i++;
                }
            }

        }
        return i+1;
    }
}
