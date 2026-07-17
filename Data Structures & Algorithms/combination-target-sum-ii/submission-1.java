class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
       backtrack(nums, target, 0, result, new ArrayList<>());
       return result; 
    }

    public void backtrack(int[] nums, int remaining, int index, List<List<Integer>> result, List<Integer> temp){
        if(remaining < 0){
            return;
        }

        if(remaining == 0){
            result.add(new ArrayList<>(temp));
        }

        for(int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i - 1]) continue;
            int val = remaining - nums[i];
            if(val < 0){
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, val, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }


    }
}
