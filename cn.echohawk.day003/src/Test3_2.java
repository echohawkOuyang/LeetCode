public class Test3_2 {
    public static int lengthOfLongestSubstring(String s) {
        //先把相同字母相连替换成一个
        if ("".equals(s) || s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i+1]) {
                chars[i] = ' ';
            }
        }
        String str = String.valueOf(chars).replaceAll(" ","");
        StringBuilder fundation = createStr(str.length(), '0'); //初始字符串
        int flag,num=0,temp=0;
        boolean shift,lon1,change=false;
        for (char i = 'a'; i <= 'z'; i++) {
            StringBuilder add = createStr(str.length(), '0');
            lon1 = false;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == i) {
                    add = add.replace(j, j+1, "1");
                    lon1 = true;
                }
            }
            if (!lon1) {
                continue;
            }
            flag = 0;
            for (int z = 0; z < fundation.length(); z++) {

                if(fundation.charAt(z) == '1' || z == fundation.length() - 1) {
                    shift = false;

                    for (int x = flag; x <= z; x++) {//这里还要左右边遍历    开始字母左边为2  右边为3   左边头部加一2置0   右边头部加一3置零
                        if (add.charAt(x) == '1') {
                            if (shift || !change) {
                                fundation = fundation.replace(x, x + 1, "1");
                                change = true;
                            }
                            shift = true;
                        }
                    }
                    flag = z;
                }
            }

        }
        fundation = fundation.replace(0, 1, "1");
        for (int index = 0; index < fundation.length(); index++) {
            if (fundation.charAt(index) == '0') {
                temp += 1;
            } else {
                temp = 0;
            }
            if (temp > num) {
                num = temp;
            }
        }
        return num + 1;
    }

    public static StringBuilder createStr (int num, char ch) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(ch);
        }
        return sb;
    }
}
