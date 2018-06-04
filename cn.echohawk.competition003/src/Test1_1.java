public class Test1_1 {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[][] point = new int[4][2];
        point[0][0] = rec1[0];
        point[0][1] = rec1[1];
        point[1][0] = rec1[2];
        point[1][1] = rec1[3];
        point[2][0] = rec1[0];
        point[2][1] = rec1[3];
        point[3][0] = rec1[2];
        point[3][1] = rec1[1];
        for (int i = 0; i < 4; i++) {
            if (compair(point[i], rec2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean compair(int[] point, int[] rec2) {
        if (point[0] - rec2[0] > 0 && rec2[2] - point[0] > 0) {
            if (point[1] - rec2[1] > 0 && rec2[3] - point[1] > 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] rec1 = new int[]{7,8,13,15
}, rec2 = new int[]{10,8,12,20};
        System.out.println(isRectangleOverlap(rec1, rec2));

    }
}
