package logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner s=null;
        String current;
        int i=0;
        try {
            s = new Scanner(new FileReader("src/wordList/gre list.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()) {
            current=s.nextLine();
            i++;
        }
        System.out.println(i);
    }
}
