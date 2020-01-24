package com.company;

import java.util.Vector;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        Vector<String> directions = new Vector<>();
        for (int i = 0; i < arr.length; i++) directions.add(arr[i]);
        int index = 0;
        while (index < directions.size() - 1) {
            String current = directions.elementAt(index);
            String opposite = "";
            if (current == "NORTH") opposite = "SOUTH";
            if (current == "SOUTH") opposite = "NORTH";
            if (current == "WEST") opposite = "EAST";
            if (current == "EAST") opposite = "WEST";
            if (directions.size() > 1 && opposite == directions.elementAt(index + 1)) {
                directions.remove(index);
                directions.remove(index);
                index = 0;
            } else index++;
        }

        String[] result = new String[directions.size()];
        for (int i = 0; i < directions.size(); i++) {
            result[i] = directions.elementAt(i);
        }
        return result;
    }
}
