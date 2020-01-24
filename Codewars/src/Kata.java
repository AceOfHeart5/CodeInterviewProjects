public class Kata {

    public static double findUniq(double arr[]) {
        double normal = 0;
        if (arr[0] == arr[1]) {
            normal = arr[0];
            for (int i = 0; i < arr.length; i++) if (arr[i] != normal) return arr[i];
        } else {
            if (arr[1] == arr[2]) return arr[0];
            else return arr[1];
        }
        return normal;
    }

    public static String encrypt(final String text, final int n) {
        //we could totally do this with recursion
        if (text == null) return null;
        String result = text;
        String code = text;
        for (int count = 0; count < n; count++) {
            result = "";
            for (int i = 1; i < code.length(); i += 2) {//first iteration will be all odd index
                result += code.charAt(i);
            }
            for (int i = 0; i < code.length(); i += 2) {//second is all even index
                result += code.charAt(i);
            }
            code = result;
        }
        return result;
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null) return null;
        StringBuilder result = new StringBuilder(encryptedText);
        String deCode = encryptedText;
        for (int count = 0; count < n; count++) {
            int charToDecode = 0;
            for (int i = 1; i < deCode.length(); i += 2) {
                result.setCharAt(i, deCode.charAt(charToDecode));
                charToDecode++;
            }
            for (int i = 0; i < deCode.length(); i += 2) {
                result.setCharAt(i, deCode.charAt(charToDecode));
                charToDecode++;
            }
            deCode = result.toString();
        }
        return result.toString();
    }


    public static double find_average(int[] array){
        double numberOfValues = array.length;
        double sum = 0;
        for (int i = 0; i < numberOfValues; i++) {
            sum += array[i];
        }
        return sum/numberOfValues;
    }

    public static int[] countPositivesSumNegatives(int[] input) {
        int[] array = {};

        if (input != null && input.length != 0) {
            array = new int[] {0, 0};
            for (int i = 0; i < input.length; i++) {
                if (input[i] <= 0) array[1] += input[i];
                else array[0]++;
            }
        }
        return array; //return an array with count of positives and sum of negatives
    }
}