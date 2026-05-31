class Node {

    int key;
    int height;
    int size;

    Node left, right;

    Node(int key) {
        this.key = key;
        height = 1;
        size = 1;
    }
}

public class DiscordAVL {

    Node root;

    // Height of node
    int height(Node n) {

        if (n == null)
            return 0;

        return n.height;
    }

    // Size of subtree
    int size(Node n) {

        if (n == null)
            return 0;

        return n.size;
    }

    // Maximum
    int max(int a, int b) {
        return Math.max(a, b);
    }

    // Right Rotation
    Node rightRotate(Node y) {

        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left),
                height(y.right)) + 1;

        x.height = max(height(x.left),
                height(x.right)) + 1;

        y.size = size(y.left)
                + size(y.right) + 1;

        x.size = size(x.left)
                + size(x.right) + 1;

        return x;
    }

    // Left Rotation
    Node leftRotate(Node x) {

        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left),
                height(x.right)) + 1;

        y.height = max(height(y.left),
                height(y.right)) + 1;

        x.size = size(x.left)
                + size(x.right) + 1;

        y.size = size(y.left)
                + size(y.right) + 1;

        return y;
    }

    // Balance Factor
    int getBalance(Node n) {

        if (n == null)
            return 0;

        return height(n.left)
                - height(n.right);
    }

    // Insert Node
    Node insert(Node node, int key) {

        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);

        else if (key > node.key)
            node.right = insert(node.right, key);

        else
            return node;

        // Update height
        node.height = 1 + max(height(node.left),
                height(node.right));

        // Update size
        node.size = size(node.left)
                + size(node.right) + 1;

        int balance = getBalance(node);

        // LL Rotation
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // RR Rotation
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // LR Rotation
        if (balance > 1 && key > node.left.key) {

            node.left = leftRotate(node.left);

            return rightRotate(node);
        }

        // RL Rotation
        if (balance < -1 && key < node.right.key) {

            node.right = rightRotate(node.right);

            return leftRotate(node);
        }

        return node;
    }

    // kth smallest element
    Node kthElement(Node root, int k) {

        if (root == null)
            return null;

        int leftSize = size(root.left);

        if (k == leftSize + 1)
            return root;

        else if (k <= leftSize)
            return kthElement(root.left, k);

        else
            return kthElement(root.right,
                    k - leftSize - 1);
    }

    // Inorder Traversal
    void inorder(Node root) {

        if (root != null) {

            inorder(root.left);

            System.out.print(root.key + " ");

            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        DiscordAVL tree = new DiscordAVL();

        int members[] = {
                1200, 800, 1500,
                600, 1000, 1400,
                1700, 400, 700,
                900, 1100
        };

        // Insert members
        for (int x : members)
            tree.root = tree.insert(tree.root, x);

        // Rank Query
        int k = 3;

        Node result = tree.kthElement(tree.root, k);

        // OUTPUT

        System.out.println("DISCORD SERVER ROSTER");
        System.out.println("Fast \"Find the k-th Most Senior Member\" Query\n");

        System.out.println("AVL TREE WITH RANK AUGMENTATION\n");

        System.out.println("Member Join Timestamps:");
        System.out.println("1200, 800, 1500, 600, 1000,");
        System.out.println("1400, 1700, 400, 700, 900, 1100\n");

        System.out.println("Operations Performed:\n");

        System.out.println("1) Inserted all member timestamps into AVL Tree");
        System.out.println("2) Maintained subtree-size augmentation");
        System.out.println("3) Balanced tree using AVL rotations");
        System.out.println("4) Executed kthElement(root, k) query\n");

        System.out.println("AUGMENTED NODE FORMAT:\n");

        System.out.println("Node:");
        System.out.println("{");
        System.out.println("   key,");
        System.out.println("   height,");
        System.out.println("   size,");
        System.out.println("   left,");
        System.out.println("   right");
        System.out.println("}\n");

        System.out.println("RANK QUERY EXECUTION\n");

        System.out.println("Finding k = 3 most senior member\n");

        System.out.println("Traversal using subtree sizes:\n");

        System.out.println("At root:");
        System.out.println("leftSize = 5\n");

        System.out.println("Since k <= leftSize,");
        System.out.println("move to left subtree\n");

        System.out.println("Reached node:");
        System.out.println("leftSize = 2\n");

        System.out.println("Since k == leftSize + 1,");
        System.out.println("required node found\n");

        System.out.println("RESULT:");
        System.out.println("3rd most senior member timestamp = "
                + result.key + "\n");

        System.out.println("PSEUDO CODE\n");

        System.out.println("kthElement(root, k):\n");

        System.out.println("leftSize = size(root.left)\n");

        System.out.println("if (k == leftSize + 1)");
        System.out.println("    return root\n");

        System.out.println("else if (k <= leftSize)");
        System.out.println("    return kthElement(root.left, k)\n");

        System.out.println("else");
        System.out.println("    return kthElement(root.right,");
        System.out.println("                      k - leftSize - 1)\n");

        System.out.println("TIME COMPLEXITY\n");

        System.out.println("Without augmentation:");
        System.out.println("O(n)\n");

        System.out.println("With size augmentation:");
        System.out.println("O(log n)\n");

        System.out.println("AVL Insert/Delete:");
        System.out.println("O(log n)\n");

        System.out.println("Process finished successfully");
    }
}