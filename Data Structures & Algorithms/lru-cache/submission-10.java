class LRUCache {
    public class Node {
        int value;
        int key;
        Node next;
        Node prev;

        public Node(int k, int val) {
            value = val;
            key = k;
        }
    }
    int remainingCapacity;
    Map<Integer, Node> map;
    Node head;
    Node end;

    public LRUCache(int capacity) {
        remainingCapacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        end = head;
    }
    
    public int get(int key) {
        Node returnValue = map.get(key);
        if ((returnValue != null) && returnValue.next != null) {
            returnValue.next.prev = returnValue.prev;
            returnValue.prev.next = returnValue.next;
            end.next = returnValue;
            returnValue.prev = end;
            end = returnValue;
        }
        if(returnValue != null) {
            return returnValue.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node element = new Node(key, value);
        boolean existingKey = false;
        end.next = element;
        element.prev = end;
        end = element;
        if(map.containsKey(key)) {
            existingKey = true;
            Node oldValue = map.get(key);
            oldValue.next.prev = oldValue.prev;
            oldValue.prev.next = oldValue.next;    
        } else {
            remainingCapacity--;            
        }
        map.put(key, element);
               
        if(remainingCapacity < 0) {
            Node nodeToRemove = head.next;
            nodeToRemove.next.prev = head;
            head.next = nodeToRemove.next;
            map.remove(nodeToRemove.key);

            remainingCapacity++;
        }
    }
}
