class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int p = 1;
        for(int i =0 ;i < nums.length;i++){
            left[i] = p*nums[i];
            p = left[i];
        }

        p = 1;
        int right[] = new int[nums.length];
        for(int i = nums.length - 1 ;i >= 0;i--){
            right[i] = p*nums[i];
            p = right[i];
        }

        for(int i = 0; i< nums.length; i++){
            if(i==0){
                nums[i] = right[i+1];
            }else if(i == nums.length - 1){
                nums[i] = left[i-1];
            }else{
            nums[i] = left[i-1] * right[i+1];
        }
    
        }
        return nums;
    }
}  
