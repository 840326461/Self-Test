package logic;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Mikasa on 2017/7/21.
 */
public class execute {
    public static void main(String[] args) {
        execute tool = new execute();
        try {
            tool.process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process() throws IOException, StringIndexOutOfBoundsException {
        Scanner s;
        FileWriter fr;
        String current;
        s = new Scanner(new FileReader("src/wordList/excused.txt"));
        fr = new FileWriter("src/wordList/gre list.txt");
        while (s.hasNext()) {
            current = s.nextLine();
            if (Pattern.matches("[\u4E00-\u9FA5]", current.substring(0, 1)))
                fr.append(current);
            else
                fr.append(System.lineSeparator()+current);
                fr.flush();
        }
    }

    public boolean judge(String str){
        boolean result=true;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)<0x61||str.charAt(i)>0x7a){
                result=false;
                break;
            }
        }
        return result;
    }
}
