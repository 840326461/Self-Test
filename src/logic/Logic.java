package logic;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Mikasa on 2017/5/17.
 */
//7512个词
public  class Logic {
    private static Logic ourInstance=new Logic();

    private ArrayList<String> words;
    private ArrayList<String> chinese;
    private ArrayList<Integer> random;
    private int orderCounter=-1;
    private int randomCounter=-1;

    private Logic(){
        init();
        load();
    }

    public static Logic getInstance() {
        return ourInstance;
    }

    private void init(){
        words=new ArrayList<>();
        chinese=new ArrayList<>();
        random=new ArrayList<>();
        Scanner s=null;
        try {
            s=new Scanner(new FileReader("src/wordList/counter.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String temp=s.nextLine();
        if(temp.charAt(0)==65279)
            temp=temp.substring(1);
        orderCounter=Integer.parseInt(temp);

        int[] source=new int[7512];
        Integer[] result=new Integer[7512];
        Random rd = new Random();
        int index = 0;
        int len=7512;
        for(int i=0;i<source.length;i++){
            source[i]=i;
        }
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-2)随机一个下标
            index = (int)(Math.random()*(len--));
            //将随机到的数放入结果集
            result[i] = source[index];
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        random.addAll(Arrays.asList(result));
    }

    public void reset(){
        orderCounter=-1;
    }

    public void load(){
       Scanner s=null;
       try {
           s=new Scanner(new FileReader("src/wordList/gre list.txt"));
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       while(s.hasNext()){
           words.add(s.nextLine());
           chinese.add(s.nextLine());
       }
    }

    public String find(String word){
        int index=words.indexOf(word);
        if(index==-1)
            return "未找到该词";
        return chinese.get(index);
    }

    public String getWord(int index){
        return words.get(index);
    }

    public String getChinese(int index){
        return chinese.get(index);
    }

    public String getRandomChinese(){
        int temp=(int) (Math.random() * 7512);
        while(temp==random.get(randomCounter)||temp==orderCounter)
            temp=(int) (Math.random() * 7512);
        return chinese.get(temp);
    }

    public String[] nextInOrder(){
        orderCounter++;
        if(orderCounter>7512)
            orderCounter=0;
        return new String[]{words.get(orderCounter),chinese.get(orderCounter)};
    }

    public String[] nextRandom(){
        randomCounter++;
        if(randomCounter>7512) {
            init();
            saveIndex();
        }
        return new String[]{words.get(random.get(randomCounter)),chinese.get(random.get(randomCounter))};
    }

    public void saveIndex(){
        FileWriter fw = null;
        try {
            fw=new FileWriter("src/wordList/counter.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.write(Integer.toString(orderCounter));
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
