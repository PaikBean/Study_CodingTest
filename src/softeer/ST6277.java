package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ST6277 {
    /**
     * https://softeer.ai/practice/6277
     * [HSAT 2회 정기 코딩 인증평가 기출] 사물인식 최소 면적 산출 프로그램 Lv. 3
     * @param args
     */
    static int N, k;
    static List<Point>[] colorPoints;
    static int minArea = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] setUpLine = br.readLine().split(" ");

        N = Integer.parseInt(setUpLine[0]);
        k = Integer.parseInt(setUpLine[1]);

        colorPoints = new ArrayList[k + 1];
        for(int i = 1; i <= k; i++){
            colorPoints[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            String[] point = br.readLine().split(" ");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            int color = Integer.parseInt(point[2]);
            colorPoints[color].add(new Point(x, y));
        }
        dfs(1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

        System.out.println(minArea);
    }

    static private void dfs(int color, int minX, int minY, int maxX, int maxY){
        if(color > k){
            minArea = Math.min(minArea, (maxX - minX) * (maxY - minY));
            return;
        }

        if((maxX - minX) * (maxY - minY) >= minArea){
            return;
        }

        for(Point p : colorPoints[color]){
            int newMinX = Math.min(minX, p.x);
            int newMinY = Math.min(minY, p.y);
            int newMaxX = Math.max(maxX, p.x);
            int newMaxY = Math.max(maxY, p.y);

            dfs(color + 1, newMinX, newMinY, newMaxX, newMaxY);
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
