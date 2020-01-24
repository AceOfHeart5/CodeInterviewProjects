public class DnaStrand {
    public static String makeComplement(String dna) {

        StringBuilder compliment = new StringBuilder(dna);

        for (int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {
                case 'A':
                    compliment.setCharAt(i, 'T');
                    break;
                case 'T':
                    compliment.setCharAt(i, 'A');
                    break;
                case 'G':
                    compliment.setCharAt(i, 'C');
                    break;
                case 'C':
                    compliment.setCharAt(i, 'G');
                    break;
            }
        }
        return compliment.toString();
    }
}
