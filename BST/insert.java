

public class insert {
    Node insert(Node root, int key){
        // if(root == null){
        //     return new Node(key);
        // }
        // if(root.data > x){
        //     root.left = insert(root.left, key);
        // }else if(root.data < x){
        //     root.right=insert(root.right, key);
        // }

        // return root;


        Node newnode=new Node(key);
        Node cur=root;
        Node parent=null;

        while(cur!=null){
            parent= cur;
            if(key < cur.key)
            cur=cur.left;

            else
            cur=cur.right;
        }

        if(parent ==null)
        parent=newnode;

        else if(key<parent.key)
        parent.left=newnode;

        else
        parent.right=newnode;

        return parent;
    }
}
//https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1