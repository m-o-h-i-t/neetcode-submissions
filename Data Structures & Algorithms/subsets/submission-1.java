class Solution {
    public List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int start, List<List<Integer>> result, List<Integer> temp ){
        result.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
