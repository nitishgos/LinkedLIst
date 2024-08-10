public class Linkedlist{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public  void addFirst(int data){
        //step1= create a node
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        //step2= NewNodenext=head
        newNode.next=head;
        //step3=head=newNode
        head=newNode;
    }
    public void addLast(int data){
        //step1=create a new node
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        //step2= tail.next=new node
        tail.next=newnode;
        //step3= tail=new node
        tail=newnode;
    }
    public void printList(){
        Node temp=head;
        if(head==null){
            System.out.println("The linkedlist is null");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newnode=new Node(data);
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public static void main(String[] args) {
        Linkedlist li=new Linkedlist();
        li.printList();
        li.addFirst(2);
        li.printList();
        li.addFirst(1);
        li.printList();
        li.addLast(3);
        li.printList();
        li.addLast(4);
        li.printList();
        li.add(2,8);
        li.printList();
    }
}