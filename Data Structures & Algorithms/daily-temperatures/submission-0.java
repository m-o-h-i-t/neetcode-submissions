class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> st = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >=0; i--){
            int temp = temperatures[i];
            if(st.isEmpty()){
                st.push(new Pair(temp,i));
                result[i] = 0;
            }else{

                while(!st.isEmpty() && st.peek().val <= temp){
                    st.pop();
                }

                if (!st.isEmpty()){
                    result[i] = st.peek().maxIndex - i;
                }

                st.push(new Pair(temp, i));
                
            }

        }
        return result;

    }

    class Pair{
        int val;
        int maxIndex;

        public Pair(int val, int maxIndex){
            this.val = val;
            this.maxIndex = maxIndex;
        }
    }
}
