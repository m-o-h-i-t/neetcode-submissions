class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length()){
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        int left  = 0;
        for(int right  = 0; right < s2.length(); right++){
            char ch = s2.charAt(right);
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);

            while(right - left + 1 > s1.length()){
                char cha = s2.charAt(left);
                s2Map.put(cha, s2Map.getOrDefault(cha, 0) - 1);
                if(s2Map.get(cha) == 0){
                    s2Map.remove(cha);
                }
                left++;
            }

            if(s1Map.equals(s2Map)){
                return true;
            }
        }
        return false;
    }
}
