class LinkedList {
    ListNode listNode; 
    ListNode dummy; 
    int n = 0;

    public LinkedList() {
        dummy = new ListNode(10);
        dummy.next = listNode;
    }

    public int get(int index) {
        if (index >= n)
            return -1;
            
        ListNode tempNode = listNode;
        int i = 0;
        while (i < index) {
            tempNode = tempNode.next;
            i += 1;
        }

        return tempNode.val;
    }

    public void insertHead(int val) {
        ListNode head = new ListNode(val);
        head.next = listNode;
        dummy.next = head;
        listNode = dummy.next;
        n += 1;
    }

    public void insertTail(int val) {
        if (listNode == null) {
            insertHead(val);
            return;
        }

        ListNode tail = new ListNode(val);
        ListNode currNode = listNode;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = tail;
        n += 1;
    }

    public boolean remove(int index) {
        if (index >= n) 
            return false;

        ListNode currNode = listNode;
        ListNode prevNode = dummy;
        int i = 0;
        while (i < index) {
            prevNode = currNode;
            currNode = currNode.next;
            i += 1;
        }

        prevNode.next = currNode.next;
        listNode = dummy.next;

        n -= 1;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode currNode = listNode;
        while (currNode != null) {
            res.add(currNode.val);
            currNode = currNode.next;
        }

        return res;
    }
}

class ListNode {
    ListNode next;
    int val;

    public ListNode () {}
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
