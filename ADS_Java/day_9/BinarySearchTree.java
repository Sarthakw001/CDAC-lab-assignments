package ADS_Java.day_9;

import java.util.Scanner;

class BinarySearchTree {

    class Node {
        private int data;
        private Node left;
        private Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        this.root = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        } else {
            Node currRoot = root, parent = null;
            while (true) {
                parent = currRoot;
                if (data < currRoot.data) {
                    currRoot = currRoot.left;
                    if (currRoot == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    currRoot = currRoot.right;
                    if (currRoot == null) {
                        parent.right = newNode;
                        return;
                    }

                }

            }
        }
    }

    void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BinarySearchTree bst = new BinarySearchTree();
            boolean flag = true;
            while (flag) {
                System.out.println(
                        "1 -> Insert data in BST\n 2 -> preorder\n 3 -> inorder\n 4 -> postorder\n 0 -> Exit\n");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter data into BST");
                        bst.insert(sc.nextInt());
                        break;
                    case 2:
                        bst.preOrder(bst.root);
                        break;
                    case 3:
                        bst.inOrder(bst.root);
                        break;
                    case 4:
                        bst.postOrder(bst.root);
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}