package pl.dashboard.nbp.exceptions;

public class TooMuchArgsException extends Exception {
	private int amount;

	public TooMuchArgsException(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
}
