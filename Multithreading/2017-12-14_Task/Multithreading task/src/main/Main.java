package main;

public class Main {

	

	public static void main(String[] args) {
		Queue q = new Queue();
		Institute mathIns = new MathInstitute(q);
		Institute bioIns = new BioInstitute(q);
		Institute randIns = new RandomInstitute(q);
		mathIns.start();
		System.out.println("M started");
		bioIns.start();
		System.out.println("B started");
		randIns.start();
		System.out.println("R started");
	}
	
	
	
}

