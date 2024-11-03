class Solution {  
    public int reverse(int x) {  
        long num = 0;  
        Boolean negative = false;
        
        if (x == Integer.MIN_VALUE) return 0;
        if (x < 0) {
            x = -x;
            negative = true;
        }
        while (x != 0) {  
            int a = x % 10; 
            // Check if the next operation is going to cause an overflow
            // and return 0 if it does
            // if (num > (Integer.MAX_VALUE - a) / 10) return 0;
            num = num * 10 + a;  
            if (num>Integer.MAX_VALUE || num<Integer.MIN_VALUE) return 0;
            x = x / 10;  
        }  
        int n = (int) num;
        return negative ? -n : n;  
    }  
} 