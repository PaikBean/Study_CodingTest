package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ST9657 {
    /**
     * https://softeer.ai/practice/9657
     * 나무공격 Lv. 2
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sp = br.readLine().split(" ");
        int N = Integer.parseInt(sp[0]);
        int M = Integer.parseInt(sp[1]);

        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i = 0; i < 2; i++){
            sp = br.readLine().split(" ");
            int l = Integer.parseInt(sp[0]);
            int r = Integer.parseInt(sp[1]);

            for(int j = l-1; j < r; j++){
                for(int k = 0; k < M; k++){
                    if(arr[j][k] == 1){
                        arr[j][k] = 0;
                        break;
                    }
                }
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 1) count++;
            }
        }

        System.out.print(count);
    }
}
