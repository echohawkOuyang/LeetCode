/**
 * We are given a personal information string S, which may represent either an email address or a phone number.
 We would like to mask this personal information according to the following rules:

 1. Email address:
 We define a name to be a string of length ≥ 2 consisting of only lowercase letters a-z or uppercase letters A-Z.
 An email address starts with a name, followed by the symbol '@', followed by a name, followed by the dot '.' and followed by a name.
 All email addresses are guaranteed to be valid and in the format of "name1@name2.name3".
 To mask an email, all names must be converted to lowercase and all letters between the first and last letter of the first name must be replaced by 5 asterisks '*'.

 2. Phone number:
 A phone number is a string consisting of only the digits 0-9 or the characters from the set {'+', '-', '(', ')', ' '}. You may assume a phone number contains 10 to 13 digits.
 The last 10 digits make up the local number, while the digits before those make up the country code. Note that the country code is optional. We want to expose only the last 4 digits and mask all other digits.
 The local number should be formatted and masked as "***-***-1111", where 1 represents the exposed digits.
 To mask a phone number with country code like "+111 111 111 1111", we write it in the form "+***-***-***-1111".  The '+' sign and the first '-' sign before the local number should only exist if there is a country code.  For example, a 12 digit phone number mask should start with "+**-".
 Note that extraneous characters like "(", ")", " ", as well as extra dashes or plus signs not part of the above formatting scheme should be removed.

 Return the correct "mask" of the information provided.
 这是一个关于正则的联系
 */
import java.util.regex.*;
import java.util.*;

public class Competition001_2 {
    public static String maskPII(String S) {
		//先判断是否为email
		String emailRegex = "[a-zA-Z]{2,}@[a-zA-Z]{2,}\\.[a-zA-Z]{2,}";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(S);
		if (matcher.matches()) {
			String s = S.toLowerCase();
			char first = s.charAt(0);
			char end = s.charAt(s.indexOf("@") - 1);
			return first + "*****" + end + s.substring(s.indexOf("@"));
		} else {
			List<Character> list = new ArrayList<>();
			int count = 0;
			for (int i = S.length() - 1; i >= 0; i--) {
				if ('0' <= S.charAt(i) && S.charAt(i) <= '9') {
					if (list.size() < 4)
						list.add(S.charAt(i));
					count ++;
				}
			}
			if (14 > count && count > 10) {

				StringBuilder sb = new StringBuilder("+");
				for (int j = 0;j < count - 10;j ++) {
					sb.append("*");
				}
				sb.append("-***-***-");
				for (int k = list.size() - 1;k >= 0; k--) {
					sb.append(list.get(k));
				}
				return sb.toString();
			} else if (count <= 10){
				StringBuilder sb = new StringBuilder();
				for (int j = 0;j < count - 7;j++) {
					sb.append("*");
					if (j == count - 8) {
						sb.append("-");
						count = 7;
						break;
					}
				}
				for (int y = 0;y < count - 4;y++) {
					sb.append("*");
					if (y == count - 5) {
						sb.append("-");
					}
				}
				for (int k = list.size() - 1;k >= 0; k--) {
					sb.append(list.get(k));
				}
				return sb.toString();
			} else {
				return "";
			}
		}
    }

    public static void main(String[] args) {
		System.out.println(maskPII("86-(10)12345678"));
    }
}
