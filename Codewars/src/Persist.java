public class Persist {
    public static int persistence(long n) {
        StringBuilder number = new StringBuilder(Long.toString(n));
        long multiplied;
        int persistence = 0;
        while (number.length() > 1) {
            multiplied = Character.getNumericValue(number.charAt(0));
            for (int i = number.length() - 1; i > 0; i--) {
                multiplied = multiplied * Character.getNumericValue(number.charAt(i));
            }
            number = new StringBuilder(String.valueOf(multiplied));
            persistence++;
        }
        return persistence;
    }
}
