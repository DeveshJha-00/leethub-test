class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n==0) return tasks.length;

        Map<Character, Integer> map = new HashMap<>();
        for (Character task : tasks){
            map.put(task, map.getOrDefault(task,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        maxHeap.addAll(map.values());

        int intervals=0;
        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<n+1; i++){ //need to consider n+1 cycles for given n (2: A->B->idle)
                if (!maxHeap.isEmpty()) temp.add(maxHeap.poll());
            }
            for (int freq : temp){ //reduce val and put back in heap
                if (--freq>0) maxHeap.offer(freq);
            }
            intervals += maxHeap.isEmpty() ? temp.size() : n+1;
        }

        return intervals;
    }
}