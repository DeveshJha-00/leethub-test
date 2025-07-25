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

//DIRECTLY EXTENDING LINKEDHASHMAP --> NOT OPTIMAL THO LOL
// class LRUCache extends LinkedHashMap<Integer, Integer> {
//     private final int capacity;

//     public LRUCache(int capacity) {
//         // true = access order, false = insertion order
//         super(capacity, 0.75f, true);
//         this.capacity = capacity;
//     }

//     public int get(int key) {
//         return super.getOrDefault(key, -1);
//     }

//     public void put(int key, int value) {
//         super.put(key, value);
//     }

//     // Automatically remove eldest (LRU) when size exceeds capacity
//     @Override
//     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         return size() > capacity;
//     }
// }

    class Node {
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    class LRUCache {
        Node head = new Node(0, 0), tail = new Node(0, 0);
        Map <Integer,Node> map = new HashMap();
        int capacity;

        public LRUCache(int _capacity) {
            capacity = _capacity;
            head.next = tail;
            tail.prev = head;
        }
        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insert(Node node) {
            map.put(node.key, node);
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                insert(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    }




/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */