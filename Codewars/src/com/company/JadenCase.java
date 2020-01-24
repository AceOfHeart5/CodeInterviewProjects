package com.company;

public class JadenCase {

    public String toJadenCase(String phrase) {

        String results = null;

        if (phrase != null && phrase != "") {
            String[] words = phrase.split(" ");
            for (int i = 0; i < words.length; i++) {
                StringBuilder word = new StringBuilder(words[i]);
                char firstChar = word.charAt(0);
                word.setCharAt(0, Character.toUpperCase(firstChar));
                words[i] = word.toString();
            }
            results = String.join(" ", words);
        }
        return results;
    }
}
