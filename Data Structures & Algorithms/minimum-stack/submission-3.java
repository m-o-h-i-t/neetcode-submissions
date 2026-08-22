class MinStack {
    List<Integer> list;
    Stack<Integer> st;
    Integer cMin = Integer.MAX_VALUE;

    public MinStack() {
        list = new ArrayList<>();
        st = new Stack();
    }
    
    public void push(int val) {
        list.add(val);
        cMin = Math.min(cMin,val);
        if (st.isEmpty() || st.peek() >= val){
            st.push(val);
        }

    }
    
    public void pop() {
        if(!list.isEmpty()){
            int val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            if(!st.isEmpty() && st.peek() == val){
                st.pop();
            }
        }
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {

        return st.isEmpty() ? - 1 : st.peek();
    }
}
