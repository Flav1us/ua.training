package main;

public class Rand {
	private static int secretValue;

	public static int setSecretValue(int minBarrier, int maxBarrier) {
	        secretValue = (int)Math.ceil(Math.random() * (maxBarrier - minBarrier - 1) + minBarrier);
	        return secretValue;
	}
}
