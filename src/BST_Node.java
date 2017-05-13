public class BST_Node {
    public int nodeValue, level;
    public BST_Node left, right;

    public BST_Node() {

    }

    public BST_Node(int nVal, int level) {
        this.nodeValue = nVal;
        this.left = null;
        this.right = null;
        this.level = level;
    }

    public BST_Node(int nVal, BST_Node left, BST_Node right, int level) {
        this.nodeValue = nVal;
        this.left = left;
        this.right = right;
        this.level = level;
    }
}
