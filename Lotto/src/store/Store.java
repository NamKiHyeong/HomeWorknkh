package store;

public class Store {

	private String Hello; // 인사말
	private String storeName; // 가게 이름
	private String Repurchase; // 재구매

	public Store() {
		super();
	}

	public Store(String hello, String storeName, String repurchase) {
		super();
		Hello = hello;
		this.storeName = storeName;
		this.Repurchase = repurchase;
	}

	public String getHello() {
		return Hello;
	}

	public String setHello(String hello) {
		return Hello = hello;
	}

	public String getStoreName() {
		return storeName;
	}

	public String setStoreName(String storeName) {
		return this.storeName = storeName;
	}

	public String getRepurchase() {
		return Repurchase;
	}

	public String setRepurchase(String repurchase) {
		return this.Repurchase = repurchase;
	}

}
