class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int num : asteroids){
            boolean isAlive=true;
            while(!st.isEmpty() && st.peek() > 0 && num < 0){
                if (Math.abs(st.peek()) == Math.abs(num)){
                    st.pop();
                    isAlive=false;
                    break;
                }else if (Math.abs(st.peek()) > Math.abs(num)){
                    isAlive=false;
                    break;
                }else{
                    st.pop();
                }
            }
            
            if (isAlive) st.push(num); 
        }

        int[] result = new int[st.size()];
        for (int i = st.size()-1; i>=0; i--) {
            result[i] = st.pop();
        }
        return result;

    }
}