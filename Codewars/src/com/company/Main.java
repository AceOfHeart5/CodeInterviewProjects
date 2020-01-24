package com.company;

import java.util.Scanner;

class Wizard {
    public int magic;

    public void castSpell() {
        System.out.println(magic);
    }
}

class Main {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3 ,4 ,5 ,6 ,7 ,8};
        setArrayIndex(myArray, 2, 1000);
        for (int value: myArray) {
            System.out.println(value);
        }

        System.out.println("Make Goblins");
        System.out.println("Right now there are " + Goblin.getNumOfGolbins() + " goblins.");
        Goblin steve = new Goblin("Steve", 20, 20);
        Goblin bob = new Goblin("Bob", 25, 15);
        Goblin joe = new Goblin("Joe", 40, 40);
        Goblin generic = new Goblin();

        System.out.println("Now there are " + Goblin.getNumOfGolbins() + " goblins!");
    }

    private static void testMethod(Wizard theWiz) {
        theWiz.castSpell(); // 3
        theWiz.magic = 99999;
        theWiz.castSpell(); // 99999
    }

    private static void setArrayIndex(int[] arr, int index, int value) {
        if (arr.length > index) {
            arr[index] = value;
        }
    }

    private static void changeArray(int[] arr) {
        if (arr.length > 3) {
            arr[3] = 100;
        }
    }

}

/*
class Wizard {
    public int magic;

    public void castSpell() {
        System.out.println(magic);
    }
}

class Main {
    public static void main(String[] args) {
        Wizard w = new Wizard();
        w.magic = 3;
        testMethod(w);
        w.castSpell(); // 99999
    }

    private static void testMethod(Wizard theWiz) {
        theWiz.castSpell(); // 3
        theWiz.magic = 99999;
        theWiz.castSpell(); // 99999
    }
}
*/