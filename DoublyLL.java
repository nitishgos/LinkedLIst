public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public int removefirst(){
        if(size==0){
            System.out.println("The Linkedlist is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    public int  removeLast(){
        if(size==0){
            System.out.println("The LinkedList is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        Node temp=head;
        int val=temp.data;
        while(temp.next!=null){
            temp=temp.next;
        }
        tail=temp.prev;
        tail.next=null;
        size--;
        return val;
    }
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<=>");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLL dll=new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.out.println(size);
        dll.removefirst();
        dll.print();
        System.out.println(size);
        dll.addLast(4);
        dll.addLast(5);
        dll.print();
        System.out.println(size);
        dll.removeLast();
        dll.print();
    }
}
