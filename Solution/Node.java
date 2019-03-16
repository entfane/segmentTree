package Solution;

public class Node {

    public Node root;
    public long sum;
    public int leftBorder;
    public int rightBorder;
    public boolean hasPromises = false;
    public int promise;

    public Node (int leftBorder, int rightBorder, Node root) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.root = root;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

}
