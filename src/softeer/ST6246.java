package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ST6246 {
    /**
     * https://softeer.ai/practice/6246
     * [HSAT 7회 정기 코딩 인증평가 기출] 순서대로 방문하기 Lv. 3
     * @param args
     */

    static int n, m;

    static int[][] maps;
    static boolean[][] isVisited;

    static int[][] target;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int answer;

    public static void main(String[] args) throws IOException {
        answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] setUpLine = br.readLine().split(" ");

        n = Integer.parseInt(setUpLine[0]);
        m = Integer.parseInt(setUpLine[1]);

        maps = new int[n][n];
        isVisited = new boolean[n][n];
        target = new int[m][2];

        for(int i = 0; i < n; i++){
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(row[j]);
            }
        }

        for(int i = 0; i < m; i++){
            String[] sp = br.readLine().split(" ");
            target[i][0] = Integer.parseInt(sp[0])-1;
            target[i][1] = Integer.parseInt(sp[1])-1;
        }

        isVisited[target[0][0]][target[0][1]] = true;
        dfs(target[0][0], target[0][1], 0);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count){
        if(count == m-1){
            answer++;
            return;
        }

        int targetX = target[count+1][0];
        int targetY = target[count+1][1];

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx == n || ny < 0 || ny == n || maps[nx][ny] == 1 || isVisited[nx][ny]) {
                continue;
            }

            isVisited[nx][ny] = true;
            if(nx == targetX && ny == targetY){
                dfs(nx, ny, count + 1);
            } else{
                dfs(nx, ny, count);
            }
            isVisited[nx][ny] = false;
        }
    }
}
