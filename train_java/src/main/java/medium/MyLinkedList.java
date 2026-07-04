package medium;

class MyLinkedList {

    MyNode head;
    MyNode tail;
    int size;

    public MyLinkedList() {
        head = new MyNode();
        tail = new MyNode();
        head.next = tail;
        tail.pre = head;
        size = 0;
    }
    
    public int get(int index) {
        int currIdx = -1;
        if (index < 0 || index >= size) {
            return -1;
        }
        if (startFromHead(index)) {
            for (MyNode curr = head; curr != null && curr != tail; curr = curr.next) {
                if (index == currIdx) {
                    return curr.val;
                }
                currIdx++;
            }
        } else {
            for (MyNode curr = tail; curr != null && curr != head; curr = curr.pre) {
                if (index == currIdx) {
                    return curr.val;
                }
                currIdx++;
            }
        }

        return -1;
    }
    
    public void addAtHead(int val) {
        MyNode newNode = new MyNode();
        newNode.val = val;

        if (head.next == tail) {
            head.next = newNode;
            tail.pre = newNode;
            newNode.next = tail;
            newNode.pre = head;
        } else {
            head.next = newNode;
            head.next.pre = newNode;
            newNode.next = head.next.pre;
            newNode.pre = head;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        MyNode newNode = new MyNode();
        newNode.val = val;

        if (head.next == tail) {
            head.next = newNode;
            tail.pre = newNode;
            newNode.next = tail;
            newNode.pre = head;
        } else {
            tail.pre = newNode;
            tail.pre.next = newNode;
            newNode.next = tail;
            newNode.pre = tail.pre;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        MyNode curr;
        if (startFromHead(index)) {
            int currIdx = -1;
            for (curr = head; curr != null; curr = curr.next) {
                if (index == currIdx) {
                    MyNode newNode = new MyNode();
                    newNode.val = val;
                    newNode.next = curr;
                    curr.pre = newNode;
                    newNode.pre = curr.pre;
                }
                currIdx++;
            }
        } else {
            int currIdx = size - 2;
            for (curr = tail; curr != null; curr = curr.pre) {
                if (index == currIdx) {
                    MyNode newNode = new MyNode();
                    newNode.val = val;
                    newNode.next = curr;
                    curr.pre = newNode;
                    newNode.pre = curr.pre;
                }
                currIdx--;
            }
        }
        size++;
    }
    
    public void deleteAtIndex(int index) {
        MyNode curr;
        if (startFromHead(index)) {
            int currIdx = -1;
            for (curr = head; curr != null; curr = curr.next) {
                if (index == currIdx) {
                    curr.pre.next = curr.next;
                    curr.next.pre = curr.pre;
                }
                currIdx++;
            }
        } else {
            int currIdx = size - 2;
            for (curr = tail; curr != null; curr = curr.pre) {
                if (index == currIdx) {
                    curr.pre.next = curr.next;
                    curr.next.pre = curr.pre;
                }
                currIdx--;
            }
        }
        size--;
    }

    public boolean startFromHead(int index) {
        return index < size / 2;
    }

    public static class MyNode {
        int val;
        MyNode pre;
        MyNode next;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(0);
        linkedList.addAtTail(2);
        System.out.println(linkedList.get(0));
    }

}