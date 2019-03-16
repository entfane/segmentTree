package Solution;

import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfElements = in.nextInt();
        int[] source = new int[numberOfElements];
        source = getArrayOfNumbers(numberOfElements);
        Tree segmentTree = new Tree(source);
        TreeRequestService service = new TreeRequestService(segmentTree);
        int leftCorner = 0;
        int rightCorner = 4;
        int valForFilling = 1;
        System.out.println( service.segmentSumRequest(leftCorner, rightCorner) );
        leftCorner = 2;
        rightCorner = 3;
        service.segmentModificationRequest(leftCorner, rightCorner, valForFilling);
        leftCorner = 0;
        rightCorner = 4;
        System.out.println( service.segmentSumRequest(leftCorner, rightCorner) );

    }

    private static int[] getArrayOfNumbers(int numberOfElements) {
        int[] result = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            result[i] = in.nextInt();
        }
        return result;
    }

}
