/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *示例：
 *给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */


/**
 * 想法：用位标记来解决
 * 例如：abcabcbb  先替换相邻相同的字母  abcabcb
 * 以a为标记点   1001000
 * 以b为标记点   0100101
 * 以c为标记点   0010010
 * 以a为基准 如果1和1 之间出现了两个1或者两个以上1的话就把除第一个外的一全填上
 */

/**
 * 初步程序，对于二进制掌握不清;有点问题 明天解决
 */
public class Test3_1 {
    public static int lengthOfLongestSubstring(String s) {
        //先把相同字母相连替换成一个
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i+1]) {
                chars[i] = ' ';
            }
        }
        String str = String.valueOf(chars).replaceAll(" ","");
        long lon = 2^(str.length());
        StringBuilder fundation = new StringBuilder(Long.toBinaryString(lon).substring(0));
        long lon1;
        int flag,num=0,temp=0;
        boolean shift;
        for (char i = 'a'; i <= 'z'; i++) {
            lon1 = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == i) {
                    lon1 += 2^j;
                }
            }
            if (lon1 == 0) {
                continue;
            }
            StringBuilder add = new StringBuilder(Long.toBinaryString(lon1|lon).substring(0));
            for (int z = 0; z < fundation.length(); z++) {
                flag = 0;
                if(fundation.charAt(z) == '1' || z == fundation.length() - 1) {
                    shift = false;
                    flag = z;
                    for (int x = flag; x < z; x++) {
                        if (add.charAt(x) == '1') {
                            if (shift) {
                                fundation = fundation.replace(x, x + 1, "1");
                            }
                            shift = true;
                        }
                    }
                }
            }

        }
        for (int index = 0; index < fundation.length(); index++) {
            if (fundation.charAt(index) == '0') {
                temp += 1;
            } else {
                if (temp > num) {
                    num = temp;
                }
                temp = 0;
            }
        }
        return num + 1;
    }

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abcabcbb"));

    }
}
