package baejoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1138 {
    /**
     * https://www.acmicpc.net/problem/1138
     * 한 줄로 서기 : 실버2
     * @param args
     *
     * 나보다 키큰사람이 왼쪽에 몇명인는지..
     * 키가 1인 사람 왼쪽에 자기보다 키큰 사람 2명이 있었음. >> 3번째!
     * 키가 2인 사람 왼쪽에 자기보다 키큰 사람 1명이 있었음. >> 2번째!
     * 키가 3인 사람 왼쪽에 자기보다 키큰 사람 1명이 있었음. >> 4번째!
     * 키가 4인 사람 왼쪽에 자기보다 키큰 사람 0명이 있었음. >> 1번째!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] person = new int[n+1];
        int[] result = new int[n+1];
        String[] tokens = str.split(" ");
        for(int i = 1; i <= n; i++) {
            person[i] = Integer.parseInt(tokens[i - 1]);
        }


        for(int i = 1; i <= n; i++) {
            int where = 1;
            while(true){
                if(person[i] == 0 && result[where] == 0){
                    result[where] = i;
                    break;
                }
                else if(result[where] == 0){
                    person[i]--;
                }
                where++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(result[i] + " ");
        }

        System.out.println(sb);
    }
}
