package main;

public class RandomInstitute extends Institute {

	public RandomInstitute(Queue q) {
		super(q);
	}

	@Override
	protected void processQueue() {
		int cleared = queue.clearRand();
		System.out.println("rand " + cleared);
	}

}
