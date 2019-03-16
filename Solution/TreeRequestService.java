package Solution;

public class TreeRequestService {

    long sum;
     private Tree segmentTree;

    public TreeRequestService(Tree segmentTree) {
        this.segmentTree = segmentTree;
    }

    public void segmentModificationRequest(int leftCorner, int rightCorner, int number) {
        segmentModification(leftCorner, rightCorner, number, 0);

    }

    private void segmentModification(int leftCorner, int rightCorner, int number, int positionOfNode) {
        if ( (leftCorner <= segmentTree.tree[positionOfNode].leftBorder) && (rightCorner >= segmentTree.tree[positionOfNode].rightBorder) ) {
            segmentTree.tree[positionOfNode].hasPromises = true;
            segmentTree.tree[positionOfNode].promise = number;
            segmentTree.tree[positionOfNode].sum = number * (segmentTree.tree[positionOfNode].rightBorder - segmentTree.tree[positionOfNode].leftBorder + 1);
        } else {
            if ( !( (leftCorner > segmentTree.tree[positionOfNode].rightBorder) || (rightCorner < segmentTree.tree[positionOfNode].leftBorder) ) ) {
                segmentModification(leftCorner, rightCorner, number, positionOfNode * 2 + 1);
                segmentModification(leftCorner, rightCorner, number, positionOfNode * 2 + 2);
                segmentTree.tree[positionOfNode].sum = segmentTree.tree[positionOfNode * 2 + 1].sum + segmentTree.tree[positionOfNode * 2 + 2].sum;
            }
        }
    }



    public long segmentSumRequest(int leftCorner, int rightCorner) {
        return findSegmentSum(leftCorner, rightCorner, 0);
    }

    private long findSegmentSum(int leftCorner, int rightCorner, int positionOfNode) {
        if ( (leftCorner <= segmentTree.tree[positionOfNode].leftBorder) && (rightCorner >= segmentTree.tree[positionOfNode].rightBorder) ) {
            return segmentTree.tree[positionOfNode].sum;
        }
        if ( (leftCorner > segmentTree.tree[positionOfNode].rightBorder) || (rightCorner < segmentTree.tree[positionOfNode].leftBorder) ) {
            return 0;
        }
        if (segmentTree.tree[positionOfNode].hasPromises) {
            segmentTree.tree[positionOfNode * 2 + 1].hasPromises = true;
            segmentTree.tree[positionOfNode * 2 + 1].promise = segmentTree.tree[positionOfNode].promise;
            segmentTree.tree[positionOfNode * 2 + 1].sum = segmentTree.tree[positionOfNode * 2 + 1].promise * (segmentTree.tree[positionOfNode * 2 + 1].rightBorder - segmentTree.tree[positionOfNode * 2 + 1].leftBorder + 1);
            segmentTree.tree[positionOfNode * 2 + 2].hasPromises = true;
            segmentTree.tree[positionOfNode * 2 + 2].promise = segmentTree.tree[positionOfNode].promise;
            segmentTree.tree[positionOfNode * 2 + 2].sum = segmentTree.tree[positionOfNode * 2 + 2].promise * (segmentTree.tree[positionOfNode * 2 + 2].rightBorder - segmentTree.tree[positionOfNode * 2 + 2].leftBorder + 1);
        }
        return (findSegmentSum(leftCorner, rightCorner, positionOfNode * 2 + 1) + findSegmentSum(leftCorner, rightCorner, positionOfNode * 2 + 2 ) );
    }

}
