class Solution {
    static String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "utv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == ""){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, "", result);
        return result;
    }

    public void backtrack(String digits, int index, String current, List<String> result){
        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++){
            backtrack(digits, index + 1, current + letters.charAt(i), result);
        }
    }
}
