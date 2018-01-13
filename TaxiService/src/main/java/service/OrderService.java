package service;

public class OrderService {

	public OrderResult calculate(String streetFrom, String streetTo, int hhArrive, int mmArrive, String carType) {
		
		OrderResult result = new OrderResult(111, 23.5, 123.4,"AA 23 43 BB");
		return result;
	}


	public OrderResult submitOrder(String orderNumber) {
		
		return getOrder(orderNumber);
	}

	public OrderResult getOrder(String orderNumber) {
		
		OrderResult result = new OrderResult(111, 23.5, 123.4,"AA 23 43 BB");
		return result;
	}

	public static class OrderResult {
		private long orderNumber;
		private double distance;
		private double price;
		private String carNumber;
		
		public OrderResult(long orderNumber, double distance, double price, String carNumber) {
			this.orderNumber=orderNumber;
			this.distance=distance;
			this.price=price;
			this.carNumber=carNumber;
		}

		public long getOrderNumber() {
			return orderNumber;
		}

		public double getDistance() {
			return distance;
		}

		public double getPrice() {
			return price;
		}

		public String getCarNumber() {
			return carNumber;
		}
		
		
	}
}
