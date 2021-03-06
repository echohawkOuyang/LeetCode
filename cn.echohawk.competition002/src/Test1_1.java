/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 * Example 1:
 *
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * Example 2:
 *
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * Notes:
 *
 *     1 <= A.length = A[0].length <= 20
 *     0 <= A[i][j] <= 1
 *
 * Java
 */

public class Test1_1 {
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, s = A.length - 1; j <= s; j++, s--) {
                swap(A, i, j, i, s);
            }
        }
        return A;
    }

    public static void swap(int[][] arr, int x1, int x2, int y1, int y2) {
        int swap;
        if (arr[x1][x2] == arr[y1][y2]) {
            if (arr[y1][y2] == 0) {
                arr[x1][x2] = arr[y1][y2] = 1;
            } else {
                arr[x1][x2] = arr[y1][y2] = 0;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}}));
    }

}
