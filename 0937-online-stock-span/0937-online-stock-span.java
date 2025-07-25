class StockData{
    int val;
    int span;
    public StockData(int val, int span){
        this.val=val;
        this.span=span;
    }
}

class StockSpanner {
    Stack<StockData> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int currSpan=1;
        while(!st.isEmpty() && price>=st.peek().val){
            currSpan += st.pop().span;
        }
        st.push(new StockData(price, currSpan));
        return currSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */