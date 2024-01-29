import java.util.Scanner;

public class Hieght {
    static Scanner sc=null;
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        Node root=createTree();
        
        System.err.println(height(root));
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
    

    static int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) +1;
    }
}

class Node{
    Node left,right;
    int data;
    public Node(int data){
        this.data=data;
    }
}