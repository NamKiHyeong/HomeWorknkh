package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ws02 {

	public static void main(String[] args) {
	
		// 당첨번호: 난수로 6개(중복 x)(1~45)
		Random r = new Random();
		int ar[] = new int[6];

		
		List<Integer> lucky = new ArrayList<>();
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = r.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				int t = ar[j];
		
				if(ar[i] == ar[j]) {
					i--;
				}
				lucky.add(t);
			}
		}
		System.out.println("당첨번호: " + Arrays.toString(ar));
		System.out.println("------------------");
		
		// 로또 번호 출력: 2x6사이즈, 1~45 (한 행에서 중복되지 않게)
		// 일치하는 수가 3개 이상이면 당첨
		// 3개: 4등 10만원, 4개: 3등 20만원, 5개: 2등 50만원, 6개: 1등 100만원
		
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		int[][] buy = new int[2][6];
		int count = 0;
		
		int first = 1000000;
		int second = 500000;
		int third = 200000;
		int fourth = 100000;
		
		// 마지막에 총 당첨금 나오게 하기
		int total = 0;
		
		for (int i = 0; i < buy.length; i++) {
			
			for (int j = 0; j < buy[0].length; j++) {
			
				int z = buy[i][j];
				buy[i][j] = r.nextInt(45) + 1;
				
				boolean same = list.contains(z);
				boolean same2 = list2.contains(z);
				boolean happy = lucky.contains(z);
				
				
				//1번째, 2번째에서는 중복 가능
				if(i == 0) {
					if(same || z == 0) {
						j--;
						continue;
					}else {
						buy[i][j] = z;
						list.add(z);
						
				} 	if (happy) {
					count++;

				}	if(j == (buy[0].length - 1)) {
					
					if(count >= 3) {
						System.out.println("First round: " + Arrays.toString(buy[0]));
						System.out.printf("%d개 일치. 당첨!\n",count);
						switch(count) {
						case 3:
							System.out.printf("4등. %d원\n",fourth);
							total += fourth;
							break;
						case 4:
							System.out.printf("3등. %d원\n",third);
							total += third;
							break;
						case 5:
							System.out.printf("2등. %d원\n",second);
							total += second;
							break;
						case 6:
							System.out.printf("1등. %d원\n",first);
							total += first;
							break;
						}
						System.out.println("");
						count = 0;
						
						continue;
					}else
					{System.out.println("First round: " + Arrays.toString(buy[0]));
						System.out.printf("%d개 일치. 다음 기회에...\n",count);
						System.out.println("");

						count = 0;
						continue;
					}
					} 
				
				
				}else {
					if(same2 || z == 0) {
						j--;
						continue;
					}else {
						buy[i][j] = z;
						list2.add(z);
				}
					if (happy) {
						count++;

					}	if(j == (buy[0].length - 1)) {
						
						if(count >= 3) {
							System.out.println("Second round " + Arrays.toString(buy[1]));
							System.out.printf("%d개 일치. 당첨!\n",count);
							switch(count) {
							case 3:
								System.out.printf("4등. %d원\n",fourth);
								total += fourth;
								break;
							case 4:
								System.out.printf("3등. %d원\n",third);
								total += third;
								break;
							case 5:
								System.out.printf("2등. %d원\n",second);
								total += second;
								break;
							case 6:
								System.out.printf("1등. %d원\n",first);
								total += first;
								break;
							}
						}
						else{
							System.out.println("Second round " + Arrays.toString(buy[1]));
							System.out.printf("%d개 일치. 다음 기회에...\n",count);
						}
					}
					
				}
				}
			
					}
		System.out.println("");
		System.out.println("Total " + total + "원");

				}

	}