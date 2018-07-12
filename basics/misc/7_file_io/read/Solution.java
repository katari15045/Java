import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("sample.txt")));
        String line = null;
        StringBuilder sb = new StringBuilder();
        do{
            line = br.readLine();
            if(line == null){
                break;
            }else{
                sb.append(line).append("\n");
            }
        }while(true);
        br.close();
        System.out.print(sb.toString());
    }
}