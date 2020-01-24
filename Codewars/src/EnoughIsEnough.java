import java.util.Vector;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (maxOccurrences <= 0) return new int[0];
        Vector<int[]> occurrences = new Vector();
        Vector<Integer> newElements = new Vector();
        for (int i = 0; i < elements.length; i++) newElements.add(elements[i]);
        for (int i = 0; i < newElements.size(); i++) {
            int current = newElements.elementAt(i);
            boolean found = false;
            int count = 0;
            for (int j = 0; j < occurrences.size(); j++) {
                if (current == occurrences.elementAt(j)[0]) {
                    occurrences.elementAt(j)[1]++;
                    found = true;
                    count = occurrences.elementAt(j)[1];
                    j = occurrences.size();
                }
            }
            if (!found) occurrences.add(new int[] {current, 1});
            if (found && count > maxOccurrences) {
                newElements.remove(i);
                i--;
            }
        }
        int[] results = new int[newElements.size()];
        for (int i = 0; i < newElements.size(); i++) results[i] = newElements.elementAt(i);
        return results;
    }
}