package easy;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/10
 * @time : 17:49
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\s", "");
        String regex = "[,.!?;:/@#$%^&*()_|`~<>\"{}\\[\\]'\\-+=\\\\]";
        s = s.toLowerCase().replaceAll(regex, "");

        int head = 0;
        int tail = s.length() - 1;
        char[] charArray = s.toCharArray();
        Boolean res = true;
        while (head < tail) {
            if (charArray[head] != charArray[tail]) {
                res = false;
            }
            head++;
            tail--;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(s));
    }

}
