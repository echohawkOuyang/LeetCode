/**
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 Example 1:
 Input: 5
 Output: 2
 Explanation: 5 = 5 = 2 + 3
 Example 2:
 Input: 9
 Output: 3
 Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
 Example 3:
 Input: 15
 Output: 4
 Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 Note: 1 <= N <= 10 ^ 9.

 一轮菜鸡操作，思路正确细节不够
 */


public class Competition001_3 {
    public static int consecutiveNumbersSum(int N) {
        //先通过一元二次找到可能的最大位数
        int max = (int)(Math.sqrt((double)(1 + (long)8 * N)) - 1) / 2;
        int result = 0;
        for (int i = 1; i <= max; i++) {
            if (i % 2 == 0 && ((N / (double)i) / 0.5) % 2 == 1) {
                result++;
            } else if (i % 2 == 1 && (N / (double)i % 1 == 0)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(933320757));
    }
}
