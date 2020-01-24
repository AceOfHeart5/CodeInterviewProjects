public class StreetFighterCharSelection {
    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves){
        String[] characters = new String[moves.length];
        for (int i = 0; i < moves.length; i++) {
            if (moves[i] == "up") position[0]--;
            if (moves[i] == "down") position[0]++;
            if (moves[i] == "left") position[1]--;
            if (moves[i] == "right") position[1]++;

            //Selection cursor is circular horizontally but not vertically!
            if (position[0] < 0) position[0] = 0;
            if (position[0] >= fighters.length) position[0] = fighters.length - 1;
            if (position[1] < 0) position[1] = fighters[position[0]].length - 1;
            if (position[1] >= fighters[position[0]].length) position[1] = 0;

            characters[i] = fighters[position[0]][position[1]];
        }
        return characters;
    }
}
