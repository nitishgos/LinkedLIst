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
    public static int size;
    public  void addFirst(int data){
        //step1= create a node
        Node newNode=new Node(data);
        size++;
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
        size++;
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
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev =head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=tail.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public int iterativesearch(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recsearch(int key){
        return helper(head,key);
    }
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void deletenth(int n){
        Node temp=head;
        int sz=0;
        //calcuate size
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(sz==n){
            head=head.next;
            return;
        }
        Node prev=head;
        int i=1;
        while(i<(size-n)){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    public Node midNode(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean checkpalin(){
        Node mid=midNode(head);
        if(head==null || head.next==null){
            return true;
        }
        Node prev=null;
        Node curr=mid;
        Node next;
        while(curr!=null){
            next=curr.next; 
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node righthead=prev;
        Node lefthead=head;
        while(righthead!=null){
            if(righthead.data!=lefthead.data){
                return false;
            }
            lefthead=lefthead.next;
            righthead=righthead.next;
        }
        return true;
    }
    public  boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean check=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                check=true;
                break;
            }
        }
        if(check==false){
            return;
        }
         slow=head;
         Node prev=null;
         while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
         }
         prev.next=null;

    }
    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow ;//mid
    }
    public  Node merge(Node head1,Node head2){
        Node mergeLL=new Node(-1);
        Node temp=mergeLL;
        while(head1!=null && head2!=null){
            if(head1.data <= head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
            while(head1!=null){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            while(head2!=null){
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        
        return mergeLL.next;
        }
    public Node mergesort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        //find mid
          Node mid=getMid(head);

        //ms for lf and rf
        Node righthead=mid.next;
        mid.next=null;
        Node leftnode=mergesort(head);
        Node rightnode=mergesort(righthead);
        //merge
        return merge(leftnode,rightnode);
    }
    public static void main(String[] args) {
        Linkedlist li=new Linkedlist();
         li.addFirst(1);
         li.addFirst(2);
         li.addFirst(3);
         li.addFirst(4);
         li.addFirst(5);
         li.addFirst(6);
         li.printList();
         li.head= li.mergesort(head);
         li.printList();
    }
}