class Node {
    int data;
    Node left;
    Node right;
    int height;

    Node(int data) {
        this.data = data;
        this.height = 1;
    }
}

public class avl {
    Node root;

    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int balanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    void updateHeight(Node node) {
        if (node != null)
            node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else
            return node; // Duplicate data not allowed

        updateHeight(node);

        int balance = balanceFactor(node);

        // Left heavy
        if (balance > 1) {
            if (data < node.left.data) {
                return rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        // Right heavy
        if (balance < -1) {
            if (data > node.right.data) {
                return rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    void insert(int data) {
        root = insert(root, data);
    }

    void inorder(Node node) {
        
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    void just(Node node){
        System.out.println("root "+node.data);
    }

    public static void main(String[] args) {
        avl tree = new avl();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.println("Inorder traversal of the AVL tree:");
        tree.inorder(tree.root);
        tree.just(tree.root);
    }
}
