
public class Gugudan {

	String result = "";

	void setGugudan(int inputNum) {
		for (int i = inputNum; i <= inputNum; i++) {
			for (int j = 1; j < 10; j++) {
				getGugudan();
				System.out.println(i + this.result + " * " + this.result + j 
									+ this.result + " =" + this.result + i * j);
			}
		}
	}

	String getGugudan() {
		this.result = result + " ";
		return result;

	}

}
