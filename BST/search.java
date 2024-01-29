

public class search {
    boolean search(Node root, int x){
        if(root==null) return false;

        if(root.data==x) return true;

        if(root.data> x) {
            return search(root.left, x);
        }
        return search(root.right, x);

    }
}

//https://practice.geeksforgeeks.org/problems/search-a-node-in-bst/1
