package baejoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ23971 {

    /**
     * https://www.acmicpc.net/problem/23971
     * ZOAC 4 : 브론즈3
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");

        int H = Integer.parseInt(sp[0]);
        int W = Integer.parseInt(sp[1]);
        int N = Integer.parseInt(sp[2]);
        int M = Integer.parseInt(sp[3]);

        int x = (W - 1) / (M + 1) + 1;
        int y = (H - 1) / (N + 1) + 1;

        System.out.println(x*y);
    }
}
