package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1949_등산로조성_Solution_김우희 {
	static int N,K;
	static int result_Max;
	
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];
			
			int high = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					high = Math.max(high, map[i][j]);
				}
			}
			
			result_Max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == high) {
						dfs(i,j,1,0);
					}
				}
			}

			System.out.println("#"+testCase+" "+result_Max);
			
			
		} // end of testCase
	} // end of main

	private static void dfs(int i, int j, int num, int one) {
		result_Max = Math.max(result_Max, num);
		visited[i][j] = true;
		
		for (int k = 0; k < dx.length; k++) {
			int newX = i + dx[k];
			int newY = j + dy[k];
			
			if(isRange(newX, newY) && !visited[newX][newY]) {
				if(map[newX][newY] >= map[i][j]) {
					if(one == 1) {
//						if(result_Max < num) {
//							result_Max = num;
//							visited[newX][newY] = false;
//							return;
//						}
					} else {
						for (int l = 1; l <= K; l++) {
							if(map[newX][newY] - l >= 0 && map[newX][newY] - l < map[i][j]) {
								map[newX][newY] = map[newX][newY] - l;
								dfs(newX, newY, num+1, one+1);
								map[newX][newY] = map[newX][newY] + l;
								
							}
						}
					}
				} else if (map[newX][newY] < map[i][j]) {
					dfs(newX, newY, num+1, one);
				}
				
			}
		}
		visited[i][j] = false;


	} // end of dfs

	private static boolean isRange(int newX, int newY) {
		return newX >= 0 && newY >= 0 && newX < N && newY < N;
	}

} // end of class
