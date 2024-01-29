import java.util.Scanner;

public class contacts {
    static class ContactNode {
        String name;
        int phoneNumber;
        int height;
        ContactNode left, right;

        ContactNode(String name, int phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            height = 1;
        }
    }

    static class ContactAVLTree {
        ContactNode root;

        int height(ContactNode N) {
            if (N == null)
                return 0;
            return N.height;
        }

        int max(int a, int b) {
            return (a > b) ? a : b;
        }

        ContactNode rightRotate(ContactNode y) {
            ContactNode x = y.left;
            ContactNode T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = max(height(y.left), height(y.right)) + 1;
            x.height = max(height(x.left), height(x.right)) + 1;

            return x;
        }

        ContactNode leftRotate(ContactNode x) {
            ContactNode y = x.right;
            ContactNode T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = max(height(x.left), height(x.right)) + 1;
            y.height = max(height(y.left), height(y.right)) + 1;

            return y;
        }

        int getBalance(ContactNode N) {
            if (N == null)
                return 0;
            return height(N.left) - height(N.right);
        }

        ContactNode insert(ContactNode node, String name, int phoneNumber) {
            if (node == null)
                return (new ContactNode(name, phoneNumber));

            if (phoneNumber < node.phoneNumber)
                node.left = insert(node.left, name, phoneNumber);
            else if (phoneNumber > node.phoneNumber)
                node.right = insert(node.right, name, phoneNumber);
            else
                return node;

            node.height = 1 + max(height(node.left), height(node.right));

            int balance = getBalance(node);

            if (balance > 1 && phoneNumber < node.left.phoneNumber)
                return rightRotate(node);

            if (balance < -1 && phoneNumber > node.right.phoneNumber)
                return leftRotate(node);

            if (balance > 1 && phoneNumber > node.left.phoneNumber) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            if (balance < -1 && phoneNumber < node.right.phoneNumber) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        void preOrder(ContactNode node) {
            if (node != null) {
                System.out.println("Name: " + node.name + ", Phone: " + node.phoneNumber);
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        ContactNode minValueNode(ContactNode node) {
            ContactNode current = node;
            while (current.left != null)
                current = current.left;
            return current;
        }

        ContactNode deleteNode(ContactNode root, int phoneNumber) {
            if (root == null)
                return root;

            if (phoneNumber < root.phoneNumber)
                root.left = deleteNode(root.left, phoneNumber);
            else if (phoneNumber > root.phoneNumber)
                root.right = deleteNode(root.right, phoneNumber);
            else {
                if (root.left == null || root.right == null) {
                    ContactNode temp = null;
                    if (temp == root.left)
                        temp = root.right;
                    else
                        temp = root.left;

                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else
                        root = temp;
                } else {
                    ContactNode temp = minValueNode(root.right);
                    root.phoneNumber = temp.phoneNumber;
                    root.right = deleteNode(root.right, temp.phoneNumber);
                }
            }

            if (root == null)
                return root;

            root.height = max(height(root.left), height(root.right)) + 1;

            int balance = getBalance(root);

            if (balance > 1 && getBalance(root.left) >= 0)
                return rightRotate(root);

            if (balance > 1 && getBalance(root.left) < 0) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }

            if (balance < -1 && getBalance(root.right) <= 0)
                return leftRotate(root);

            if (balance < -1 && getBalance(root.right) > 0) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }

            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactAVLTree contactTree = new ContactAVLTree();

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a contact");
            System.out.println("2. Delete a contact");
            System.out.println("3. Display all contacts");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    int phoneNumber = scanner.nextInt();
                    contactTree.root = contactTree.insert(contactTree.root, name, phoneNumber);
                    System.out.println("Contact added!");
                    break;
                case 2:
                    System.out.println("Enter phone number of contact to delete:");
                    int numberToDelete = scanner.nextInt();
                    contactTree.root = contactTree.deleteNode(contactTree.root, numberToDelete);
                    System.out.println("Contact deleted!");
                    break;
                case 3:
                    System.out.println("Contacts in the AVL tree (preorder traversal):");
                    contactTree.preOrder(contactTree.root);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}
