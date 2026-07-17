class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(nums); 
       backtrack(nums, target, 0, result, new ArrayList<>());
       return result; 
    }

    public void backtrack(int[] nums, int remaining, int index, List<List<Integer>> result, List<Integer> temp){
        if(remaining == 0){
            result.add(new ArrayList<>(temp));
        }

        for(int i = index; i < nums.length; i++){
            if(nums[i] > remaining){
                return;
            }
            temp.add(nums[i]);
            backtrack(nums, remaining - nums[i], i, result, temp);
            temp.remove(temp.size() - 1);
        }


    }
}
