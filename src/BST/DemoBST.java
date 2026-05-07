package BST;

class Node {

    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
    }
}

class BST {

    Node root;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (data > current.data) {
                    if (current.right == null) {
                        current.right = newNode;
                        break;
                    }
                    current = current.right;
                } else {
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    }
                    current = current.left;
                }
            }
        }
    }

    public boolean find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data == key) {
                return true;
            } else if (key > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return false;
    }

    public int min() {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public void delete(int key) {
        Node current = root;
        Node parent = null;
        boolean right = false;
        while (key != current.data) {
            parent = current;
            if (key > current.data) {
                right = true;
                current = current.right;
            } else {
                right = false;
                current = current.left;
            }
        }

        if (current.right == null && current.left == null) {//tidak punya anak
            if(current == root){
                root = null;
            }else if (right) {
                parent.right = null;
            } else {
                parent.left = null;
            }
        } else if (current.right != null) {//anak 1 kanan
            if(current == root){
                root = current.right;
            }else if (right) {
                parent.right = current.right;
            } else {
                parent.left = current.right;
            }
        } else if (current.left != null) {//anak 1 kiri
            if(current == root){
                root = current.left;
            }else if (right) {
                parent.right = current.left;
            } else {
                parent.left = current.left;
            }
        } else {//2 anak
            Node suc = getSuccecor(current);
            delete(suc.data);
            if(current == root){
                root.data = suc.data;
            }else if(right){
                parent.right.data = suc.data;
            }else{
                parent.left.data = suc.data;
            }
        }

    }

    public Node getSuccecor(Node del) {
        Node current = del.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
}

public class DemoBST {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(60);
        bst.insert(80);
        bst.insert(20);
        bst.insert(10);
        bst.insert(5);
        bst.insert(90);
        bst.delete(20);
        bst.inOrder(bst.root);

    }
}
