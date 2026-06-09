class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                                Comparator.comparingInt(arr -> arr[0])
                                );
        
        for (int i=0; i<Math.min(k, nums1.length); i++){
            minHeap.offer(new int[]{nums1[i]+nums2[0], i, 0});
        }

        while(!minHeap.isEmpty() && k>0){
            int[] curr = minHeap.poll();
            int nums1Idx = curr[1], nums2Idx = curr[2];
            res.add(Arrays.asList(nums1[nums1Idx], nums2[nums2Idx]));
            k--;

            if (nums2Idx + 1 < nums2.length){
                minHeap.offer(new int[]{
                nums1[nums1Idx] + nums2[nums2Idx+1], nums1Idx, nums2Idx + 1});
            }
        }

        return res;
    }
}