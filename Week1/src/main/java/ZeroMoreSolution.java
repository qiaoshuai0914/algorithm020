public class ZeroMoreSolution {

    public void zeroMore(int[] nums){
        int i = 0;
        int j = 0;
        int l = nums.length;
        for(;i<l;i++){
            if(nums[i]!=0){
                if(i==j){
                    j++;
                }else{
                    int temp = nums[i];
                    nums[j]=temp;
                    nums[i]=0;
                    j++;
                }

            }
        }

    }
}
