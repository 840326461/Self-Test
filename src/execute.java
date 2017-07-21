import java.io.*;
import java.nio.Buffer;

/**
 * Created by Mikasa on 2017/7/21.
 */
public class execute {
    public static void main(String[] args){
        execute tool=new execute();
        try {
            tool.process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process() throws IOException {
        StringBuilder sb=new StringBuilder();
        BufferedReader br;
        FileWriter fr;
        String current;
        br=new BufferedReader(new FileReader("src/wordlist.txt"));
        fr=new FileWriter("src/level6.txt");
        while((current=br.readLine())!=null)
            sb.append(current);
        current=sb.toString().replaceAll(" ;",";").replaceAll("\\. ",".");
        sb=new StringBuilder();
        for(int i=0;i<current.length();i++){
            if(current.charAt(i)==' '&&!(current.charAt(i+2)=='.'||current.charAt(i+3)=='.')) {
                if(current.charAt(i+1)==')'||current.charAt(i-1)=='('){}
                else
                sb.append(System.lineSeparator());
            }
            else
                sb.append(current.charAt(i));
        }
        fr.write(sb.toString());
        fr.flush();
    }
}
