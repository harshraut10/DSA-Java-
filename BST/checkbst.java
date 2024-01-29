public class checkbst{
    boolean isBST(Node root){
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    Boolean isBSTUtil(Node node,int min, int max){
        if(node == null) return true;

        if(node.data < min || node.data > max)
        return false;

        return(isBSTUtil(node.left, min, node.data-1) && isBSTUtil(node.right, node.data+1, max));
    }
}
//https://practice.geeksforgeeks.org/problems/check-for-bst/1