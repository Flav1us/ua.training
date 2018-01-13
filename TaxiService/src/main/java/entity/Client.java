package entity;

public class Client {
	private String phoneNumber;
	private String login;
	private int discount;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getLogin() {
		return login;
	}

	public int getDiscount() {
		return discount;
	}
	
	public Client(String login, String phoneNumber, int discount) {
		this.phoneNumber = phoneNumber;
		this.login = login;
		this.discount = discount;
	}


	public static class Builder {
		private String phoneNumber;
		private String login;
		private int discount;
		
		public Builder setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		public Builder setLogin(String login) {
			this.login = login;
			return this;
		}
		public Builder setDiscount(int discount) {
			this.discount = discount;
			return this;
		}
		public Client build() {
			return new Client(login, phoneNumber, discount);
		}
	}
}
