// class LRUCache {
//     Map<Integer, Integer> map;
//     Deque<Integer> dq;
//     int capacity;

//     public LRUCache(int capacity) {
//         map = new HashMap<>();
//         dq = new ArrayDeque<>();
//         this.capacity=capacity;
//     }
    
//     public int get(int key) {
//         if (map.containsKey(key)){
//             dq.remove(key);       
//             dq.offer(key);
//             return map.get(key);
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         if (map.containsKey(key)){
//             dq.remove(key);
//         }else{
//             if (map.size()==capacity){
//                 map.remove(dq.pollFirst());
//             }
//         }
//         map.put(key, value);
//         dq.offer(key);
//     }
// }

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        // true = access order, false = insertion order
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    // Automatically remove eldest (LRU) when size exceeds capacity
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */