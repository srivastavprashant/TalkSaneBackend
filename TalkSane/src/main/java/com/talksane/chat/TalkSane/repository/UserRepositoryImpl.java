import java.io.*;
import java.util.*;

public class UserRepositoryImpl {
    BufferedReader br;
    PrintWriter out;

    private void solve() throws Exception {
        
    }

    public static void main(String args[]) throws Exception {
        new UserRepositoryImpl().init();

    }

    private void init() throws Exception {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            File file = new File("./input.txt");
            br = new BufferedReader(new FileReader(file));
            out = new PrintWriter("./output.txt");
        } else {
            out = new PrintWriter(System.out);
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        solve();
        out.flush();
    }

    private int in() throws Exception {
        return (Integer.parseInt(br.readLine()));
    }

    private int[] in(int n) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return (arr);


    }
}
