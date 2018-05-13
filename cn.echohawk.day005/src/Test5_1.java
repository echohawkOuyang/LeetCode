/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */

/**
 * 粗心还是难受啊，    48.75%   战胜
 */


public class Test5_1 {
    public static String longestPalindrome(String s) {
        int[] arr = new int[]{0, 0, 0};
        boolean flag;
        for (int i = 0; i < s.length(); i++) {
            flag = true;
            for (int l = i, r = i + 1; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) {
                flag = false;
                if ((r - l + 1) > arr[0]) {
                    arr[0] = r - l + 1;
                    arr[1] = l;
                    arr[2] = r + 1;
                }
            }
            for (int l = i - 1, r = i + 1; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) {
                flag = false;
                if ((r - l + 1) > arr[0]) {
                    arr[0] = r - l + 1;
                    arr[1] = l;
                    arr[2] = r + 1;
                }

            }
            if (flag) {
                if (arr[0] == 0 && s.length() != 0) {
                    arr[0] = 1;
                    arr[1] = i;
                    arr[2] = i + 1;
                }
            }
        }
        return s.substring(arr[1], arr[2]);

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cccc"));
    }
}
