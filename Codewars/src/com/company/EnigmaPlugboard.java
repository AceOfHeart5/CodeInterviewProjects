package com.company;

import java.util.Vector;

class InvalidPlugboardWiresException extends Exception {

}
public class EnigmaPlugboard {
    Vector<Character[]> connections;
    public EnigmaPlugboard(String wires) throws InvalidPlugboardWiresException {
        connections = new Vector();
        String charsUsed = "";
        if (wires.length() <= 1) throw new InvalidPlugboardWiresException();
        if (wires.length() > 20) throw new InvalidPlugboardWiresException();
        if (wires.length() % 2 != 0) throw new InvalidPlugboardWiresException();
        for (int i = 0; i < wires.length(); i++) {
            CharSequence current = String.valueOf(wires.charAt(i));
            CharSequence next = String.valueOf(wires.charAt(i + 1));
            if (charsUsed.contains(current) || charsUsed.contains(next) || current == next) {
                throw new InvalidPlugboardWiresException();
            } else {
                connections.add(new Character[] {current.charAt(0), next.charAt(0)});
                connections.add(new Character[] {next.charAt(0), current.charAt(0)});
                charsUsed += current;
                charsUsed += next;
                i++;
            }
        }
    }

    public String process(String wire) {
        for (int i = 0; i < connections.size(); i++) {
            String s1 = wire.toUpperCase();
            String s2 = connections.elementAt(i)[0].toString().toUpperCase();
            if (s1.compareToIgnoreCase(s2) == 0) {
                String result = connections.elementAt(i)[1].toString();
                return result;
            }
        }
        return wire;
    }
}
