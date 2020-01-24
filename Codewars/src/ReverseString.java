public class ReverseString {

    public static String reverseString(String forward) {
        StringBuilder result = new StringBuilder();
        for (int i = forward.length() - 1; i >= 0; i--) {
            result.append(forward.charAt(i));
        }
        return result.toString();
    }

}
