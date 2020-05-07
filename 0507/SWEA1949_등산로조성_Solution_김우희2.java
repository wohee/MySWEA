package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1949_등산로조성_Solution_김우희2 {
	static int N,K;
	static int max;
	
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
			
			List<int[]> top = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == high) {
						top.add(new int[] {i,j});
					}
				}
			}
			
			
			max = -1;
			for (int i = 0; i < top.size(); i++) {
				int[] ij = top.get(i);
				
				dfs(ij[0], ij[1], 1, false);
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if(map[i][j] == high) {
//						dfs(i,j,1,false);
//					}
//				}
//			}
			System.out.println("#"+testCase+" "+max);
			
			
		} // end of testCase
	} // end of main

	private static void dfs(int i, int j, int cnt, boolean use) {
		max = Math.max(max, cnt); // 가장 긴 등산로 갱신
		visited[i][j] = true;
		
		for (int d = 0; d < dx.length; d++) {
			int ni = i + dx[d];
			int nj = j + dy[d];
			
			
			if(isRange(ni, nj) && !visited[ni][nj]) {
				if(map[ni][nj] < map[i][j]) {
					dfs(ni,nj,cnt+1,use);
				} else {
					if(!use) {
						
						for (int k = 1; k <= K; k++) {
							if(map[ni][nj] - k < map[i][j]) {
								map[ni][nj] -= k;
								dfs(ni,nj,cnt+1,true);
								map[ni][nj] += k;
							}
						}
						
						
					} 
					
				}
			}
			
			
		}
		

		visited[i][j] = false;


	} // end of dfs

	private static boolean isRange(int newX, int newY) {
		return newX >= 0 && newY >= 0 && newX < N && newY < N;
	}

} // end of class
