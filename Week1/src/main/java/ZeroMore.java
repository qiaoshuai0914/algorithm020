
/* 283. 移动零 */
public class ZeroMore{
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
                    mums[j]=temp;
                    nums[i]=0;
                    j++;
                }

            }
        }

    }

}