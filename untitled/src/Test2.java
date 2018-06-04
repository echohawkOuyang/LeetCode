public class Test2 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

    }
    public static boolean bubbleSort(int[] a, int W) {
        int temp, countW = W, doubleN, compare;
        for (int i = 0; i < a.length - 1; ++i) {
            for (int j = a.length - 1; j > i; --j) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            if (i == 0) {
                countW = W;
                doubleN = 1;
                continue;
            }
            if (countW != W && a[i] != a[i - 1] && a[i] != a[i - 1] + 1)
            if (a[i] == a[i - 1] + 1) {

            }
            if (a[i] == a[i-1]) {
                doubleN ++;
            }
            if (co)
            if (countW < W) {
                if (i == 0 || a[i] == a[i - 1] + 1) {
                    countW --;
                } else if (a[i] == a[i - 1]){
                    doubleN ++;
                }
            }

            count ++;
            if (count == W)
        }
    }

}
