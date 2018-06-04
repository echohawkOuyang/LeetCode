public class Tested {
    public static boolean backspaceCompare(String S, String T) {
        if (doit(S).equals(doit(T))) {
            return true;
        }
        return false;
    }
    public static String doit(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ('#' == s.charAt(i)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }
}
