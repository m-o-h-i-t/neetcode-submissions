class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < strs.size(); i++){
            if(i == strs.size() - 1){
                sb.append(strs.get(i));
            } else{
                sb.append(strs.get(i)).append("idx:");
            }
        }
        
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == null){
            return new ArrayList<>();
        }
        
        String[] strs = str.split("idx:");
        return Arrays.asList(strs);
    }
}

