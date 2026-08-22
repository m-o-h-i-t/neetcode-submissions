class Solution {
    Set<String> operators = Set.of("+","-","*","/");
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String ch : tokens){
            if (operators.contains(ch)){
                int op1 = st.pop();
                int op2 = st.pop();

                int val;
                if (ch.equals("+")){
                    val = op1 + op2;
                }else if (ch.equals("-")){
                    val = op2 - op1;
                }else if (ch.equals("*")){
                    val = op1*op2;
                }else{
                    val = op2/op1;
                }
                st.push(val);
                // System.out.println("op1 " + op1 + " op2 " + op2 + " st " + st.peek() + " size " + st.size() + " val " + val);
            }else{
                st.push(Integer.parseInt(ch));
            }
        }
        return st.peek();
    }
}
