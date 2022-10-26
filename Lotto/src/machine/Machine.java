package machine;

import java.util.ArrayList;

public class Machine {

	private int lottoPaper; // 로또 용지
	private ArrayList<int[]> listNumber; // 로또 구매 수량에 대한 숫자들을 담을 배열
	private char orderNumber;
	private int[] inputNumber; // 로또 번호 자동 생성 (6개)
	private int[] outputNumber; // 출력 번호
	private int[] winningNumber; // 당첨 번호

	public Machine() {
		super();
	}

	public Machine(int lottoPaper, ArrayList<int[]> listNumber, char orderNumber, int[] inputNumber, int[] outputNumber,
			int[] winningNumber) {
		super();
		this.lottoPaper = lottoPaper;
		this.listNumber = listNumber;
		this.orderNumber = orderNumber;
		this.inputNumber = inputNumber;
		this.outputNumber = outputNumber;
		this.winningNumber = winningNumber;
	}

	public int getLottoPaper() {
		return lottoPaper;
	}

	public int setLottoPaper(int lottoPaper) {
		return this.lottoPaper = lottoPaper;
	}

	public ArrayList<int[]> getListNumber() {
		return listNumber;
	}

	public ArrayList<int[]> setListNumber(ArrayList<int[]> listNumber) {
		return this.listNumber = listNumber;
	}

	public char getOrderNumber() {
		return orderNumber;
	}

	public char setOrderNumber(char orderNumber) {
		return this.orderNumber = orderNumber;
	}

	public int[] getInputNumber() {
		return inputNumber;
	}

	public int[] setInputNumber(int[] inputNumber) {
		return this.inputNumber = inputNumber;
	}

	public int[] getOutputNumber() {
		return outputNumber;
	}

	public int[] setOutputNumber(int[] outputNumber) {
		return this.outputNumber = outputNumber;
	}

	public int[] getWinningNumber() {
		return winningNumber;
	}

	public int[] setWinningNumber(int[] winningNumber) {
		return this.winningNumber = winningNumber;
	}

}
