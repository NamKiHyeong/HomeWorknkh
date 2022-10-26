package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import machine.Machine;
import player.Player;
import store.Store;

public class Lotto {
	public static void main(String[] args) {

		// 클래스 객체 생성 (가게, 구매자, 로또기계)
		Scanner scan = new Scanner(System.in);
		Store store = new Store();
		Player player = new Player();
		Machine machine = new Machine();

		// 가게 이름, 인사말, 재구매 설정
		String StoreName = store.setStoreName("★럭키로또점★");
		String Hello = store.setHello("어서오세요~");
		String Repurchase = store.setRepurchase("재구매 하시겠습니까? (Y / N)\t");

		// 구매자 이름, 보유 금액 설정
		String name = player.setBuyerName("남기형");
		int money = player.setHoldingAmount(50000);

		// 머신 로또 로또용지(수량), 구매수량마다 번호 저장 LIST, 맨 앞에 기호 초기값, 출력 번호, 당첨 번호
		int LottoPaper = machine.setLottoPaper(0);
		ArrayList<int[]> ListNumber = machine.setListNumber(new ArrayList<>());
		char OrderNumber = machine.setOrderNumber('A');
		int[] OutputNumber = machine.setOutputNumber(new int[6]);
		int[] WinningNumber = machine.setWinningNumber(null);

		// 유효성 검사
		try {
			System.out.println(StoreName + "\n" + Hello);
			System.out.println("구매자: " + name + "\n" + "보유금액: " + money);
			System.out.print("몇 장 구매 하실건가요? (1~10장만 구매 가능합니다): ");
			LottoPaper = scan.nextInt();
			if (!(LottoPaper > 0 && LottoPaper < 11)) {
				System.out.println("1~10 사이의 숫자만 입력해 주세요.");

				return;
			}
		} catch (Exception e) {
			System.out.println("정확한 숫자를 입력해 주세요.");

			return;
		}

		// 구매시 금액 차감
		System.out.println("구매장 수: " + LottoPaper + "장");
		int Deduction = LottoPaper * 1000;
		for (int i = 0; i < Deduction; i++) {
			money--;
		}
		System.out.println("차감금액은: " + Deduction + "원 입니다.");
		System.out.println("현재 보유금액은: " + money);

		for (int i = 0; i < LottoPaper; i++) {

			// 6개의 랜덤 로또 번호 생성
			ListNumber.add(i, lottoNumberCreate());
		}
		System.out.println();

		// 생성된 로또 번호 출력
		for (int i = 0; i < ListNumber.size(); i++) {
			for (int j = 0; j < OutputNumber.length; j++) {
				OutputNumber = ListNumber.get(i);
				if (j == 0) {
					System.out.printf("%s\t%02d", OrderNumber, OutputNumber[j]);
				} else if (j < OutputNumber.length - 1) {
					System.out.printf(",%02d", OutputNumber[j]);
				} else {
					System.out.printf(",%02d\n", OutputNumber[j]);
				}
			}
			if (i < ListNumber.size() - 1) {
				OrderNumber++;
			} else {
				System.out.println();
			}
		}

		// 로또 당청 번호 출력
		System.out.println("[오늘의 당첨 번호는?]");

		// 당첨 번호 랜덤 생성
		WinningNumber = lottoNumberCreate();

		for (int i = 0; i < WinningNumber.length; i++) {
			if (i == 0) {
				System.out.printf(" \t%02d", WinningNumber[i]);
			} else if (i < WinningNumber.length - 1) {
				System.out.printf(",%02d", WinningNumber[i]);
			} else {
				System.out.printf(",%02d\n\n", WinningNumber[i]);
			}
		}

		// 당첨 번호와 구매 로또 번호를 비교하여 숫자 일치 여부 판단
		System.out.println("[내 로또 결과]");
		for (int i = 0; i < ListNumber.size(); i++) {
			int cnt = 0;
			OutputNumber = ListNumber.get(i);

			for (int j = 0; j < OutputNumber.length; j++) {
				for (int k = 0; k < OutputNumber.length; k++) {
					if (OutputNumber[j] == WinningNumber[k]) {
						cnt++;
					}
				}
				if (j == 0) {
					System.out.printf("%s\t%02d", OrderNumber, OutputNumber[j]);
				} else if (j < OutputNumber.length - 1) {
					System.out.printf(",%02d", OutputNumber[j]);
				} else {
					System.out.printf(",%02d => %d개 일치\n", OutputNumber[j], cnt);
				}
			}
			if (i < ListNumber.size() - 1) {
				OrderNumber++;
			} else {
				OrderNumber = 'A';
				System.out.println();
			}
		}

		// 로또 재구매
		System.out.print(Repurchase);
		Repurchase = scan.next();
		if (Repurchase.equals("Y") || Repurchase.equals("y")) {

		} else if (Repurchase.equals("N") || Repurchase.equals("n")) {
			System.out.println("안녕히 가세요~");
		}

	}

	// 로또 번호 자동 생성
	public static int[] lottoNumberCreate() {
		Machine machine = new Machine();
		int[] InputNumber = machine.setInputNumber(new int[6]);

		for (int i = 0; i < InputNumber.length; i++) {
			InputNumber[i] = (int) (Math.random() * 45) + 1;
			// 증복 제거
			for (int j = 0; j < i; j++) {
				if (InputNumber[i] == InputNumber[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(InputNumber);
		return InputNumber;
	}

}
