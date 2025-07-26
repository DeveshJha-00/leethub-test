class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones) maxHeap.offer(stone);

        while(maxHeap.size()>1){
            int s2 = maxHeap.poll();
            int s1 = maxHeap.poll();
            if (s1!=s2){
                maxHeap.offer(Math.abs(s1-s2));
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}