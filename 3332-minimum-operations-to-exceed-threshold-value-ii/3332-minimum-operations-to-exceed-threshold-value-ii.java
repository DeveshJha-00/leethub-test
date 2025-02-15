class Solution {
    public int minOperations(int[] nums, int k) {

        int ct=0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int ele:nums) pq.offer((long)ele);

        while(pq.size() > 1){
            long x = pq.poll();
            long y = pq.poll();
            if (x<k || y<k){
                long newVal = (long)Math.min(x,y)*2 + (long)Math.max(x,y);
                pq.offer(newVal);
                ct++;
            }else{
                break;
            }
        }

        return ct;
    }
}