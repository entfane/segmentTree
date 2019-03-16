package Solution;

public class Tree {

    public Node[] tree;
    private int[] source;

    public Tree(int[] source) {
        this.source = source;
        createTree();
    }

    private void createTree() {
        tree = new Node[source.length * 2];
        buildNode(0, source.length - 1, null, 0);
    }

    private void buildNode(int leftBorder, int rightBorder, Node root, int treePos) {
        tree[treePos] = new Node(leftBorder, rightBorder, root);
        if (leftBorder == rightBorder) {        //check if the node is leaf
            tree[treePos].setSum(source[rightBorder]);
        } else /* not leaf */ {
            buildNode( leftBorder, (leftBorder + rightBorder) / 2, tree[treePos], treePos * 2 + 1);
            buildNode( (leftBorder + rightBorder) / 2 + 1, rightBorder, tree[treePos], treePos * 2 + 2);
            tree[treePos].setSum(tree[treePos * 2 + 1].sum + tree[treePos * 2 + 2].sum);
        }
    }

}
