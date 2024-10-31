package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ST7727 {
    /**
     * https://softeer.ai/practice/7727
     * 함께하는 효도 Lv. 3
     * @param args
     */
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] trees, friends;
    static boolean[][] isVisited;

    static int N, M, result;

    public static void main(String[] args) throws IOException {
        result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] setUpLine = br.readLine().split(" ");
        N = Integer.parseInt(setUpLine[0]);
        M = Integer.parseInt(setUpLine[1]);

        trees = new int[N+2][N+2];
        isVisited = new boolean[N+2][N+2];

        for(int i = 1; i <= N; i++){
            String[] sp = br.readLine().split(" ");
            for(int j = 1; j <= N; j++){
                trees[i][j] = Integer.parseInt(sp[j-1]);
            }
        }

        friends = new int[M][2];
        for(int i = 1; i <= M; i++){
            String[] sp = br.readLine().split(" ");
            int x = Integer.parseInt(sp[0]);
            int y = Integer.parseInt(sp[1]);
            friends [i-1] = new int[]{x,y};
            isVisited[x][y] = true;
            result += trees[x][y];
        }

        dfs(friends[0][0], friends[0][1], 0, 0, result);
        System.out.println(result);

    }

    private static void dfs(int x, int y, int fCnt, int time, int sum){
        result = Math.max(result, sum);

        if(time == 3){
            if(fCnt+1<M){
                dfs(friends[fCnt+1][0], friends[fCnt+1][1], fCnt+1, 0, sum);
            }
        } else{
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx > 0 && nx <= N && ny > 0 && ny <= N && !isVisited[nx][ny]){
                    isVisited[nx][ny] = true;
                    dfs(nx, ny, fCnt, time+1, sum + trees[nx][ny]);
                    isVisited[nx][ny] = false;
                }
            }
        }
    }
}
