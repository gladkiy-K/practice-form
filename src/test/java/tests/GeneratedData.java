package tests;

import java.util.Random;

public class GeneratedData {
    public static String subjects() {
        String[] subjects = {"Maths", "Chemistry", "Commerce", "Accounting"};
        Random rand = new Random();
        int randInd = rand.nextInt(subjects.length);
        return subjects[randInd];
    }

    public static int hobbies() {
        int[] toThree = {1, 2, 3};
        Random rand = new Random();
        int randInd = rand.nextInt(toThree.length);
        return toThree[randInd];
    }
}
