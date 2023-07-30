package class04test;




public class Code02_QueueTest {
    public static class Node<V>{
        public V value;
        public Node<V> next;

        public Node(V v) {
            value = v;
            next = null;
        }
    }
    public static class MyQueue<V>{
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        /**
         *  加一个节点
         * @param value
         * @author ljceng
         */
        public void offer(V value) {
            Node<V> current = new Node<V>(value);
            if (tail == null){
                head = current;
                tail = current;
            }else {
                tail.next = current;
                tail = current;
            }
            size++;
        }

        // C/C++的同学需要做节点析构的工作

        /**
         *  出队列
         * @author ljceng
         */
        public V poll() {
            V ans = null;
            if(head != null){
                ans = head.value;
                head = head.next;
                size--;
            }
            if (head == null){
                tail = null;
            }
            return ans;
        }

        // C/C++的同学需要做节点析构的工作
        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }
}
