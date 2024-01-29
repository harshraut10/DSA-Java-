import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class leftView {
    static Scanner sc=null;
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        Node root=createTree();
        printLeft(root);
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

    static void printLeftView(Node root, ArrayList list,int level){
        if(root==null) return;
        if(list.get(level)==null){
            list.set(level, root);
        }

        printLeftView(root.left, list, level+1);
        printLeftView(root.right, list, level+1);
        
    }

    static void printLeft(Node root){
        ArrayList<Node> list= new ArrayList<>();
        printLeftView(root, list, 0);
        for(Node cur: list){
            System.out.print(cur.data+" ");
        }
    }
}

class Node{
    Node left,right;
    int data;
    public Node(int data){
        this.data=data;
    }
}