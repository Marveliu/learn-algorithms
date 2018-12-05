// 链表实现

class link {

    int size = 0;
    node head = new node(null);

    class node {
        Integer value;
        node prev;
        node next;

        public node(Integer v) {
            value = v;
        }

        public node getPrev() {
            return this.prev;
        }

        public node getNext() {
            return this.next;
        }
    }

    public link(int capacity) {
        size = capacity;

        node tmp = head.next;
        node pre = head;
        for (int i = 0; i < capacity; i++) {
            tmp = new node(null);
            tmp.prev = pre;
            pre.next = tmp;
            tmp = tmp.next;
            pre = pre.next;
        }
        head = head.next;
    }

    public void add(int n) {
        node tmp = head;
        while (tmp != null && tmp.value != null) {
            tmp = tmp.next;
        }
        node add = new node(n);
        addAfterNode(tmp, add);
    }

    public void addAt(int n, int index) {
        if (index > size - 1) {
            return;
        }
        node tmp = head;
        int i = 0;
        while (i != index) {
            tmp = tmp.next;
            i++;
        }
        node add = new node(n);
        addAfterNode(tmp, add);
    }

    /**
     * 在指定的节点后面添加
     * 
     * @param tmp
     * @param add
     */
    public void addAfterNode(node tmp, node add) {
        if (tmp == null) {
            head = add;
            return;
        }
        if (tmp.value == null) {
            tmp = add;
            return;
        }
        if (tmp.next == null) {
            tmp.next = add;
            add.prev = tmp;
        } else {
            tmp.next = add;
            tmp.next.prev = add;
        }
        size++;
    }

    /**
     * 删除
     * 
     * @param n
     */
    public void del(int n) {
        node tmp = head;
        while (tmp != null) {
            if (tmp.value == n) {
                break;
            }
            tmp = tmp.next;
        }
        delNode(tmp);
    }

    public void delAt(int n) {
        if (index > size - 1) {
            return;
        }
        node tmp = head;
        int i = 0;
        while (i != index) {
            tmp = tmp.next;
            i++;
        }
        delNode(tmp);
    }

    public void delNode(node tmp) {
        if (tmp.prev.value != null && tmp.next != null) {
            tmp.next.prev = tmp.prev;
            tmp.prev.next = tmp.next;
        }
        // 尾节点
        if (tmp.next.value == null) {
            if (tmp.prev.value != null) {
                tmp.prev.next = null;
                tmp.prev = null;
            }
        }
        // 首节点
        if (tmp.prev.value == null) {
            if (tmp.next != null) {
                head = tmp.next;
                tmp.next = null;
                tmp.prev = null;
            }
        }
        size--;
    }

    public void print() {
        node tmp = head;
        int i = 0;
        while (tmp.value != null) {
            System.out.println(String.format("%d: %d", i, tmp.value));
            i++;
            tmp = tmp.next;
        }
        System.out.println(String.format("size: %d", this.size));
    }

    public static void main(String[] args) {
        link l = new link(3);
        l.add(3);
        l.add(2);
        l.add(5);
        l.print();
    }

}
