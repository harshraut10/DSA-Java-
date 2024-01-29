import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class levelOrder {

    public static void main(String[] args) {
        sc=new Scanner(System.in);
        Node root=createTree();
        printLevelOrder(root);
    }
     static Scanner sc=null;
    static void printLevelOrder(Node root){
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur=q.poll();
            System.out.println(cur.data);
            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
    }

    static Node createTree(){
        Node root=null;
        System.out.println("Enter data: ");
        int data=sc.nextInt();
        if(data==-1) return null;

        root=new Node(data);
        System.out.println("Enter left data: "+data);
        root.left=createTree();

        System.out.println("Enter right data: "+data);
        root.right=createTree();

        return root;
    }
}
class Node{
    Node left,right;
    int data;
    public Node(int data){
        this.data=data;
    }
}