import java.util.List;

public class Linkedlist {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node() {
            // TODO Auto-generated constructor stub
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // step1= create a node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2= NewNodenext=head
        newNode.next = head;
        // step3=head=newNode
        head = newNode;
    }

    public void addLast(int data) {
        // step1=create a new node
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        // step2= tail.next=new node
        tail.next = newnode;
        // step3= tail=new node
        tail = newnode;
    }

    public void printList() {
        Node temp = head;
        if (head == null) {
            System.out.println("The linkedlist is null");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newnode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int iterativesearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recsearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void deletenth(int n) {
        Node temp = head;
        int sz = 0;
        // calcuate size
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (sz == n) {
            head = head.next;
            return;
        }
        Node prev = head;
        int i = 1;
        while (i < (size - n)) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node midNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkpalin() {
        Node mid = midNode(head);
        if (head == null || head.next == null) {
            return true;
        }
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node righthead = prev;
        Node lefthead = head;
        while (righthead != null) {
            if (righthead.data != lefthead.data) {
                return false;
            }
            lefthead = lefthead.next;
            righthead = righthead.next;
        }
        return true;
    }

    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean check = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                check = true;
                break;
            }
        }
        if (check == false) {
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;

    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;// mid
    }

    public Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }

    public Node mergesort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);

        // ms for lf and rf
        Node righthead = mid.next;
        mid.next = null;
        Node leftnode = mergesort(head);
        Node rightnode = mergesort(righthead);
        // merge
        return merge(leftnode, rightnode);
    }

    public void zigzag() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // 2nd half reverse
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // alternative merge
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            right = nextR;
            left = nextL;
        }
    }

    public static Node getIntersectionNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public void skipMdeleteN(Node head, int m, int n) {
        Node curr = head, t;
        while (curr != null) {
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }
            if (curr == null) {
                return;
            }
            t = curr.next;
            for (int i = 1; i <= n && curr != null; i++) {
                Node temp = t;
                t = t.next;
            }
            curr.next = t;
            curr = t;
        }
    }

    public void swapList(int x, int y) {
        if (x == y) {
            return;
        }
        // for x pointer
        Node currX = head;
        Node prevX = null;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }
        // for y pointer
        Node currY = head;
        Node prevY = null;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
        if (currX == null || currY == null) {
            return;
        }
        if (prevX != null) {
            prevX.next = currY;
        } else {
            currY = head;
        }
        if (prevY != null) {
            prevY.next = currX;
        } else {
            currX = head;
        }
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    public Node OddEvenList(Node head){
            if (head == null || head.next == null) {
                return head;
            }
    
            // Create two dummy nodes for even and odd lists
            Node evenDummy = new Node(0);
            Node oddDummy = new Node(0);
    
            Node even = evenDummy;
            Node odd = oddDummy;
    
            Node current = head;
    
            // Traverse the list and separate even and odd nodes
            while (current != null) {
                if (current.data % 2 == 0) {
                    even.next = current;
                    even = even.next;
                } else {
                    odd.next = current;
                    odd = odd.next;
                }
                current = current.next;
            }
    
            // Connect even list to odd list
            even.next = oddDummy.next;
            odd.next = null; // Mark the end of the odd list
    
            // Return the head of the new modified list
            return evenDummy.next;
        }
        public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.head = new Node(8);
        ll.head.next = new Node(12);
        ll.head.next.next = new Node(10);
        ll.head.next.next.next = new Node(5);
        ll.head.next.next.next.next = new Node(4);
        ll.head.next.next.next.next.next = new Node(1);
        ll.head.next.next.next.next.next.next = new Node(6);
        ll.printList();
        ll.OddEvenList(ll.head);
        ll.printList();
    }
}