import java.util.Scanner;

public class max {
    static Scanner sc=null;
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        Node root=createTree();
        
        System.err.println(maxim(root));
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
    

    static int maxim(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(
            maxim(root.left),
            maxim(root.right)
        ));
    }
}

class Node{
    Node left,right;
    int data;
    public Node(int data){
        this.data=data;
    }
}