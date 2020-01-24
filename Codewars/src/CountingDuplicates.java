import java.util.List;
import java.util.Vector;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Vector<Character> duplicates = new Vector<Character>();
        for (int i = 0; i < text.length(); i++) {
            Character current = text.charAt(i);
            for (int j = 0; j < text.length(); j++) {
                if (Character.toLowerCase(current) == Character.toLowerCase(text.charAt(j)) && j != i && !alreadyFound(current, duplicates)) {
                    duplicates.add(current);
                    j = text.length();
                }
            }
        }
        return duplicates.size();
    }

    private static boolean alreadyFound(Character c, List<Character> ls) {
        for (int i = 0; i < ls.size(); i++) {
            if (Character.toLowerCase(c) == Character.toLowerCase(ls.get(i))) return true;
        }
        return false;
    }
}
