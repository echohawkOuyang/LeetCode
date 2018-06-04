public class Test1 {
    public static int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] peak = new int[A.length];
        for (int i = 0;i < A.length; i++) {
            peak[i] = peak(A, i);
        }
        int maxNum = peak[0];
        for (int i = 0; i < peak.length; i++) {
            if (peak[i] > maxNum) {
                maxNum = peak[i];
            }
        }
        return maxNum;
    }
    public static int peak(int[] array, int peak) {
        int peakLeft = 0;
        int peakRight = 0;
        for (int index = peak - 1;index >= 0 && array[index + 1] > array[index]; index--) {
            peakLeft++;
        }
        for (int index = peak + 1;index < array.length && array[index - 1] > array[index]; index++) {
            peakRight++;
        }
        if (peakLeft > 0 && peakRight > 0) {
            return peakLeft + peakRight + 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2,1,4,7,3,2,5}));
    }
}
