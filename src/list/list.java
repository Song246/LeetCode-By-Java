package list;

import java.util.*;

class Main {
    public static void main (String[] args) {
        /* code */
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int n=sc.nextInt();
            if(n==0) {System.out.println("list is empty");continue;}
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i]=sc.nextInt();
            }
            Node head =  createList(arr);
            show(head);
            Node newHead =  reverse(head);
            show(newHead);
        }
    }

    public static Node createList(int[] arr) {
        Node dummy = new Node(-1);
        Node p = dummy;
        for(int val:arr) {
            p.next=new Node(val);
            p=p.next;
        }
        return dummy.next;
    }

    // 1->2->3
    public static Node reverse(Node head) {
        // 递归栈溢出，
        // if(root==null||root.next==null) return root;
        // list.Node newHead = reverse(root.next);
        // root.next.next=root;
        // root.next=null;
        // return newHead;

        // 只能使用迭代
        if (head==null||head.next==null) return head;
        Node pre = head;
        Node p=head.next;
        head.next=null;
        Node temp;
        while(p!=null) {
            temp=p.next;
            p.next=pre;
            pre=p;
            p=temp;
        }
        return pre;

    }

    public static void show(Node node) {
        while(node!=null) {
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println();
    }
}


class Node {
    Node next;
    int val;
    Node(){};
    Node(int val,Node next) {
        this.val=val;
        this.next=next;
    }
    Node(int val) {
        this.val=val;
    }

}

