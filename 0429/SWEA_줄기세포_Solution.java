package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_줄기세포_Solution {
	
	static class Cell {
		private int i;
		private int j;
		private int x; //x줄기세포의 생명력(처음입력값보관용)
		
		private int life; // 활성화까지 시간 -> 살아있는 시간
		private int time; // 배양 시간
		private int flag; // 활성화 상태 (0: 비활성화, 1:활성화)
		
		public Cell(int i, int j, int x, int life, int time, int flag) {
			super();
			this.i = i;
			this.j = j;
			this.x = x;
			
			this.life = life;
			this.time = time;
			this.flag = flag;
		}

	}

	
	
	static int N,M,K;
	static int[][] map;
	static List<ArrayList<Cell>> list; //줄기세포생명력 (1<=X<=10)별 저장(인텍스0~9사용)
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {	
			
			list = new ArrayList<>();
			for (int i = 0; i <= 9; i++) {
				list.add(new ArrayList<>());
				
			}
			
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N+K][M+K]; 
			for (int i = (K/2); i < N+(K/2); i++) { // 배열의 중간을 계산(0,0) -> (K/2,K/2)
				st = new StringTokenizer(br.readLine());
				for (int j = (K/2); j < M+(K/2); j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						int idx = map[i][j]-1;
						list.get(idx).add(new Cell(i, j, map[i][j], map[i][j], K, 0));
						//i:세로,j:가로,x:줄기세포생명력, life:활성화까지시간->살아있는시간,time:배양시간,flag:비활성화(0)
			
					}
				}
			}
			
			bfs();
			
			int cnt = 0;
			for (int i = 0; i < N+K; i++) {
				for (int j = 0; j < M+K; j++) {
					if(map[i][j] != 0 && map[i][j] != -1) {
						cnt++;
					}
				}
			}
			
			System.out.println("#"+testCase+" "+cnt);
			
			
		} // end of testCase

	} // end of main
	
	static void bfs() {
		Queue<Cell> q = new LinkedList<Cell>();
		for (int x = 9; x >=0; x--) { // 생명력이 큰 순서로 번식
			if(list.get(x).size() != 0) {
				for (int s = 0; s < list.get(x).size(); s++) {
					q.offer(list.get(x).get(s));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Cell c = q.poll();
			if(c.life == 0 && c.flag == 1) {
				map[c.i][c.j] = -1; // 종료처리
				continue;
			}		
			if(c.time == 0) continue; // 배양시간이 지나면 넘어감
			if(c.life != 0) { // life != 0(비활성화상태), flag = 0(비활성화)
				q.offer(new Cell(c.i, c.j, c.x, c.life-1, c.time-1, c.flag));
				continue;
			}
			
			//life==0(비활성화끝남) -> life=x,flag=1(활성화됨)
			q.offer(new Cell(c.i, c.j, c.x, c.x, c.time, 1));
			for (int d = 0; d < dx.length; d++) {
				int ni = c.i + dx[d];
				int nj = c.j + dy[d];
				
				if(0 <= ni && ni < N+K && 0 <= nj &&  nj< M+K && map[ni][nj] == 0) {
					map[ni][nj] = c.x;
					q.offer(new Cell(ni, nj, c.x, c.x, c.time-1, 0)); //새로 번식된 세포는 비활성화 상태부터 시작
				}
			}
		}
	}

}
