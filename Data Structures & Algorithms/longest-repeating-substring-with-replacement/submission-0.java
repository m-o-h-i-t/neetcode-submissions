class Solution {
    public int characterReplacement(String s, int k) {
       int left = 0;
       Map<Character, Integer> map = new HashMap<>();
       int max= 0;
       int maxLen = 0;
       for(int right = 0; right < s.length(); right++){
        char ch = s.charAt(right);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        max = Math.max(max, map.get(ch));
        while((right - left + 1) - max > k){
            char cha = s.charAt(left);
            map.put(cha, map.get(cha) - 1);
            if(map.get(cha) == 0){
                map.remove(cha);
            }
            left++;
        }
        maxLen = Math.max(right - left + 1, maxLen);
       }
       return maxLen; 
    }
}
