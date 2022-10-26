package player;

public class Player {

	private int holdingAmount; // 구매자 보유 돈
	private String buyerName; // 구매자 이름

	public Player() {
		super();
	}

	public Player(int holdingAmount, String buyerName) {
		super();
		this.holdingAmount = holdingAmount;
		this.buyerName = buyerName;
	}

	public int getHoldingAmount() {
		return holdingAmount;
	}

	public int setHoldingAmount(int holdingAmount) {
		return this.holdingAmount = holdingAmount;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public String setBuyerName(String buyerName) {
		return this.buyerName = buyerName;
	}

}
