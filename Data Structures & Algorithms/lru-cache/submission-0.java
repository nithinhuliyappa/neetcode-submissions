class LRUCache {

    class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private final int cap;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            cache.remove(key);
            remove(node);
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        add(node);

        if(cache.size()>cap){
            Node lru = tail.prev;
            cache.remove(lru.key);
            remove(lru);
        }
    }

    public void add(Node node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


