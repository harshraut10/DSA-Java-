import java.util.Scanner;

public class NoNodes {
    static Scanner sc=null;
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        Node root=createTree();
        
        System.err.println(size(root));
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
    

    static int size(Node root){
        if(root == null) return 0;
        return size(root.left) + size(root.right) +1;
    }
}

class Node{
    Node left,right;
    int data;
    public Node(int data){
        this.data=data;
    }
}