import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Mikasa on 2017/5/17.
 */
public  class controler {
    static String[] words;
    static String[][] wordsWithChinese=new String[570][];

   static public void load(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src\\words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        words=br.lines().collect(Collectors.joining(",")).split(",");

       try {
           br = new BufferedReader(new FileReader("src\\wordsWithChinese.txt"));
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
        String[] cache=br.lines().collect(Collectors.joining(",")).split(",");
       for(int i=0;i<570;i++)
           wordsWithChinese[i]=cache[i].split(" ");
    }
    static public void test(){
        Scanner s=new Scanner(System.in);
        System.out.println("请输入数字选择测试模式");
        System.out.println("1.从头开始测试");
        System.out.println("2.从中间开始测试");
        //System.out.println("tips:随时输入0以停止程序");
        if(s.nextLine().equals("1")){
            testFromBegin();
        }
        else{
            int pointer=0;
            System.out.print("请输入开始的单词:");
            String input=s.nextLine();
            for(;pointer<570;pointer++){
                if(words[pointer].equals(input))
                    break;
            }
            testFromMiddle(pointer);
        }

    }
    public static void testFromBegin(){
        Scanner s=new Scanner(System.in);
        for(int pointer=0;pointer<570;pointer++){
            if(compare(pointer))
                System.out.println("回答正确");
            else{
                System.out.println("回答错误 请选择操作");
                System.out.println("1.重新回答");
                System.out.println("2.跳过本词");
                if(s.nextLine().equals("1"))
                    pointer--;
            }
        }
        System.out.print("单词没啦你tm的真厉害！");
    }
    public static void testFromMiddle(int pointer){
        Scanner s=new Scanner(System.in);
        for(;pointer<570;pointer++){
            if(compare(pointer))
                System.out.println("回答正确");
            else{
                System.out.println("回答错误 请选择操作");
                System.out.println("1.重新回答");
                System.out.println("2.跳过本词");
                if(s.nextLine().equals("1"))
                    pointer--;
            }
        }
        System.out.print("单词没啦你tm的真厉害！");
    }
    public static void search(){
        Scanner s=new Scanner(System.in);
        String word;
       k: while(s.hasNext()) {
            word=s.nextLine();
            for (int i = 0; i < 570; i++) {
                if (word.equals(words[i])) {
                    System.out.println(wordsWithChinese[i][1]);
                    continue k;
                }
            }
           System.out.println("查无此词");
        }
    }

    static public boolean compare(int pointer){
        System.out.println("请输入对应单词:"+wordsWithChinese[pointer][1]);
        Scanner s=new Scanner(System.in);
        if(wordsWithChinese[pointer][0].equals(s.nextLine()))
            return true;
        return false;
    }
}
