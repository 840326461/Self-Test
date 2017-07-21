import java.util.Scanner;

/**
 * Created by Mikasa on 2017/5/17.
 */
public class main {
    public static void main(String[] args){
        System.out.println("这是一个简单的南大A级词自主听写+查询程序");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("下面会加载单词表，请耐心等待");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        controler.load();
        Scanner s=new Scanner(System.in);
        System.out.println("1.测试 2.查询");
        if(s.nextLine().equals("1")) {
            System.out.println("开始测试");
            controler.test();
        }
        else{
            System.out.println("开始查询");
            controler.search();
        }

    }
}
