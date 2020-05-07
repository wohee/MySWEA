package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA6109_추억의2048게임_Solution_김우희2 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	public static void move(int i, int j, int d) {
		int ni = i+di[d];
		int nj = j+dj[d];
		
		if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
			if(map[i][j] != 0 && map[i][j] == map[ni][nj] && !visited[i][j]){
				map[ni][nj] = map[i][j]*2;
				map[i][j] = 0;
				visited[ni][nj] = true;
			} else if(map[ni][nj] == 0) {
				map[ni][nj] = map[i][j];
				map[i][j] = 0;
			}
			move(ni,nj,d);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				 st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N][N];
			
			switch (s) {
			case "up": // 상 0
				for (int j = 0; j < N; j++) {
					for (int i = 1; i < N; i++) {
						move(i,j,0);
					}
				}
				break;
			case "down": // 하 1
				for (int j = 0; j < N; j++) {
					for (int i = N-2; i >= 0; i--) {
						move(i,j,1);
					}
				}
				break;
			case "left": // 좌 2
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						move(i,j,2);
					}
				}
				break;
			case "right": // 우 3
				for (int i = 0; i < N; i++) {
					for (int j = N-2; j >= 0; j--) {
						move(i,j,3);
					}
				}
				break;

			}
			sb.append("#"+testCase+"\n");
			for (int[] ma : map) {
				for (int m : ma) {
					sb.append(m+" ");
				}
				sb.append("\n");
			}
		} // end of testCase
		System.out.println(sb.toString());
		br.close();
	} // end of main
} // end of class


