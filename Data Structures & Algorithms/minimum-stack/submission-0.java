class MinStack {
    private static class elementWithMin {
        public int element;
        public int min;

        public elementWithMin(int val, int minVal) {
            element = val;
            min = minVal;
        }
    };

    private Stack<elementWithMin> s;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if(!s.isEmpty()) {
            min = Math.min(min, s.peek().min);
        }
        s.push(new elementWithMin(val, min));
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().element;
    }
    
    public int getMin() {
        return s.peek().min;
    }
}
