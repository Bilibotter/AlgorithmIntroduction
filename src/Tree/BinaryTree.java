package Tree;

public class BinaryTree {
    public BinaryTree parent,left,right;
    public int value;

    /*
    public BinaryTree(BinaryTree tree, int value) {
        tree.parent = tree;
        tree.value = value;
    }

     */

    public BinaryTree(int value) {
        this.value = value;
    }

    void insert(BinaryTree root, BinaryTree tree) {
        //BinaryTree root = head.root;
        BinaryTree parent = null;
        while (root != null) {
            parent = root;
            if (root.value > tree.value) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        tree.parent = parent;
        if (tree.value < parent.value) {
            parent.left = tree;
        }
        else {
            parent.right = tree;
        }
    }

    BinaryTree minimum(BinaryTree tree) {
        if (tree == null) {
            return tree;
        }
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    BinaryTree maximum(BinaryTree tree) {
        if (tree == null) {
            return tree;
        }
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    BinaryTree iterativeSearch(BinaryTree tree, int key) {
        while (tree != null && tree.value != key) {
            if (key < tree.value) {
                tree = tree.left;
            }
            else {
                tree = tree.right;
            }
        }
        return tree;
    }

    BinaryTree search(BinaryTree tree, int key) {
        if (tree == null || tree.value == key) {
            return tree;
        }
        if (key < tree.value) {
            return search(tree.left, key);
        }
        else {
            return search(tree.right, key);
        }
    }

    void inorderTreeWalk(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        inorderTreeWalk(tree.left);
        System.out.print(tree.value+", ");
        inorderTreeWalk(tree.right);
    }

    void preorderTreeWalk(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.value+", ");
        inorderTreeWalk(tree.left);
        inorderTreeWalk(tree.right);
    }

    void postorderTreeWalk(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        inorderTreeWalk(tree.left);
        inorderTreeWalk(tree.right);
        System.out.print(tree.value+", ");
    }

    public static void main(String[] args) {
        BinaryTree head = new BinaryTree(12);
        int[] array = {5, 18, 2, 9, 15, 19, 13, 17};
        for (int value:array){
            head.insert(head, new BinaryTree(value));
        }
        head.inorderTreeWalk(head);
        System.out.println("");
        System.out.println(head.maximum(head).value);
        System.out.println(head.minimum(head).value);
    }
}
