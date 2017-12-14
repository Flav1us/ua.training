package main;

public class MathInstitute extends Institute {

	public MathInstitute(Queue q) {
		super(q);
	}

	@Override
	protected void processQueue() {
		int cleared = queue.clearAllMath();
		System.out.println("math " + cleared);
	}

}
