package main;

public class BioInstitute extends Institute {

	public BioInstitute(Queue q) {
		super(q);
	}
	
	@Override
	protected void processQueue() {
		int cleared = queue.clearAllBio();
		System.out.println("bio " + cleared);
	}

}
