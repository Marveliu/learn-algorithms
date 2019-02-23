import java.util.*;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 * 
 * LRU的缓存实现，基于双向链表和hashmap
 * 
 */
public class Solution {

    class LRUCache {

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int k, int v) {
                this.key = k;
                this.value = v;
            }
        }

        Map<Integer, Node> map = new HashMap<>();
        Node head;
        Node tail;
        int capacity = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public synchronized int get(int key) {
            Node ans = map.get(key);
            if (ans != null) {
                moveHead(ans);
            }
            return ans == null ? -1 : ans.value;
        }

        public synchronized void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                moveHead(node);
                return;
            }
            if (capacity <= map.size()) {
                delTail();
            }
            Node add = new Node(key, value);
            map.put(key, add);
            addHead(add);
        }

        private void addHead(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
        }

        private void moveHead(Node node) {
            if (node.prev == head)
                return;
            node.next.prev = node.prev;
            node.prev.next = node.next;
            addHead(node);
        }

        private void delTail() {
            Node del = tail.prev;
            if (del == head)
                return;
            del.prev.next = del.next;
            del.next.prev = del.prev;
            del.next = null;
            del.prev = null;
            map.remove(del.key);
        }

    }

    public static void print(LRUCache cache) {
        LRUCache.Node p = cache.head.next;
        while (p != cache.tail) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        LRUCache cache = s.new LRUCache(2);

        cache.put(1, 1);
        print(cache);
        cache.put(2, 2);
        print(cache);
        cache.get(1); // returns 1
        print(cache);
        cache.put(3, 3); // evicts key 2
        print(cache);
        cache.get(2); // returns -1 (not found)
        print(cache);
        cache.put(4, 4); // evicts key 1
        print(cache);
        cache.get(1); // returns -1 (not found)
        print(cache);
        cache.get(3); // returns 3
        print(cache);
        cache.get(4); // returns 4
        print(cache);
    }
}