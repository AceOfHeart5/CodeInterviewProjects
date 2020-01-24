import java.util.Vector;

public class Abbreviator {
    public String abbreviate(String string) {
        Vector<String> words = new Vector<String>();
        String word = "";
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isLetter(string.charAt(i))){
                words.add(word);
                words.add(Character.toString(string.charAt(i)));
                word = "";
            } else {
                word += string.charAt(i);
            }
        }
        if (word != "") words.add(word);
        Vector<String> abbrevs = new Vector<String>();
        for (int i = 0; i < words.size(); i++) {
            String current = words.elementAt(i);
            if (current.length() > 3) {
                String abbrev = Character.toString(current.charAt(0));
                abbrev += String.valueOf(current.length()-2);
                abbrev += Character.toString(current.charAt(current.length()-1));
                abbrevs.add(abbrev);
            } else abbrevs.add(words.elementAt(i));
        }
        String result = "";
        for (int i = 0; i < abbrevs.size(); i++) {
            result += abbrevs.elementAt(i);
        }
        return result;
    }
}
