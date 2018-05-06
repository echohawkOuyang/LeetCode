/**
 * 这个版本结尾没处理好
 */


public class Test4_2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //首先去找中位数的位置
        int middle = (nums1.length + nums2.length) / 2;   //奇数的话，中就是middle   偶数的话，就是middle-1和middle
        boolean Odd = ((nums1.length + nums2.length) % 2 == 1) ? true : false;
        int sumflag = 0;
        float sum = 0;
        int num2f = 0;
        a:
        for (int i = 0; i < nums1.length; i++) {
            b:
            for (int j = num2f; j <nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    if (!Odd && sumflag == middle - 1) {
                        sum += nums1[i];
                    } else if (sumflag == middle){
                        if (sum == 0) {
                            sum = nums1[i];
                        } else {
                            sum += nums1[i];
                            sum /= 2;
                        }
                        break a;
                    }
                    sumflag++;
                    continue a;
                } else {
                    if (!Odd && sumflag == middle - 1) {
                        sum += nums2[j];
                    } else if (sumflag == middle){
                        if (sum == 0) {
                            sum = nums2[j];
                        } else {
                            sum += nums2[j];
                            sum /= 2;
                        }
                        break a;
                    }
                    sumflag++;
                    num2f++;
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.print(findMedianSortedArrays(a, b));
    }
}
