import java.util.*;

public class BST {

    private BST_Node root = null;
    private int count = 0;

    public BST() {
    }

    public void add(int nVal) {
        // Create a new BST_Node for nVal
        int level = 0;
        BST_Node newNode = new BST_Node(nVal, level);
        int result;

        // Insert newNode into the tree and scan
        // the tree from root node to leaf nodes
        BST_Node curNode = root, parentNode = null;
        while (curNode != null) {
            result = curNode.nodeValue - newNode.nodeValue;
            if (result == 0) {
                // curNode is same as newNode, duplicates not allowed so do
                // nothing
                return;
            } else if (result > 0) {
                // curNode.NodeValue > newNode.NodeValue, go left
                parentNode = curNode;
                curNode = curNode.left;
                level++;
            } else if (result < 0) {
                // curNode.NodeValue < newNode.NodeValue, go right
                parentNode = curNode;
                curNode = curNode.right;
                level++;
            }
        }
        // the while loop terminates as curNode = null
        // so we are now at the end of the tree and
        // parentNode is leaf node
        count++; // Adding newNode to the tree is possible
        if (parentNode == null) {
            // parentNode is leaf node so if parentNode
            // is null then the tree was empty
            root = newNode; // the tree has one node
        } else {
            result = parentNode.nodeValue - newNode.nodeValue;
            if (result > 0) {
                // parentNode.NodeValue > newNode.NodeValue, add newNode
                // to parentNode's left subtree
                parentNode.left = newNode;
                parentNode.level = level-1;
            } else if (result < 0) {
                // parentNode.NodeValue < newNode.NodeValue, add newNode
                // to parentNode's right subtree
                parentNode.right = newNode;
                parentNode.level = level-1;
            }
        }
    }

    public void addRange(ArrayList<Integer> arrList) {
        for (int item : arrList) {
            this.add(item);
        }
    }

    public String inorderTraversal() {
        return this.inorderTraversal(this.root, " ");
    }

    // Inorder recursive output of the nodes in a binary
    // tree. Output separator after each node value.
    public String inorderTraversal(String separator) {
        return this.inorderTraversal(this.root, separator);
    }

    // Inorder recursive output of the nodes in a binary
    // tree. Output separator after each node value.
    public String inorderTraversal(BST_Node t, String separator) {
        // the scan terminates on an empty subtree
        if (t != null) {
            StringBuilder sb = new StringBuilder();

            // descend left
            sb.append(inorderTraversal(t.left, separator));
            // visit the node
            sb.append(t.nodeValue);
            sb.append(separator);
            // descend right
            sb.append(inorderTraversal(t.right, separator));
            return sb.toString();
        } else {
            return "";
        }
    }

    // Postorder traversal
    public String postorderTraversal() {
        return this.postorderTraversal(this.root, " ");
    }

    // Postorder recursive output of the nodes in a binary
    // tree. Output separator after each node value.
    public String postorderTraversal(String separator) {
        return this.postorderTraversal(this.root, separator);
    }

    // Postorder recursive output of the nodes in a binary
    // tree. Output separator after each node value.
    public String postorderTraversal(BST_Node t, String separator) {
        // the scan terminates on an empty subtree
        if (t != null) {
            StringBuilder sb = new StringBuilder();

            // descend left
            sb.append(postorderTraversal(t.left, separator));
            // descend right
            sb.append(postorderTraversal(t.right, separator));
            // visit the node
            sb.append(t.nodeValue);
            sb.append(separator);
            return sb.toString();
        } else {
            return "";
        }
    }

    // Preorder tranversal
    public String preorderTraversal() {
        return this.preorderTraversal(this.root, " ");
    }

    // Preorder recursive output of the nodes in a binary
    // tree. Output separator after each node value.
    public String preorderTraversal(String separator) {
        return this.preorderTraversal(this.root, separator);
    }

    // Preorder recursive output of the nodes in a binary
    // tree. Output separator after each node value.
    public String preorderTraversal(BST_Node t, String separator) {
        // the scan terminates on an empty subtree
        if (t != null) {
            StringBuilder sb = new StringBuilder();
            // visit the node
            sb.append(t.nodeValue);
            sb.append(separator);
            // descend left
            sb.append(preorderTraversal(t.left, separator));
            // descend right
            sb.append(preorderTraversal(t.right, separator));
            return sb.toString();
        } else {
            return "";
        }
    }

    public String FindNodeValuesAtLevel(int level){
        return this.FindNodeValuesAtLevel(level, this.root, " ");
    }

    public String FindNodeValuesAtLevel(int level, BST_Node node, String separator){
        StringBuilder sb = new StringBuilder();
        if (node != null){
            if (node.level == level){
                sb.append("node " + node.nodeValue + " -> ");
            } else {
                sb.append(FindNodeValuesAtLevel(level, node.left, separator));
                sb.append(FindNodeValuesAtLevel(level, node.right, separator));
            }
        }
        return sb.toString();
    }
}
