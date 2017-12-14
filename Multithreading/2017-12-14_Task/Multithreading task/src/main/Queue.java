package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.management.monitor.Monitor;

public class Queue {
	
	
	
	List<doctype> docs = new LinkedList<>(Arrays.asList(getRandomDocs()));
	
	public enum doctype {math, bio};
	
	public synchronized int clearAllMath() {
		int removed = 0;
		while(docs.get(0) == doctype.math) {
			docs.remove(0);
			removed++;
		}
		return removed;
		
	}
	
	public synchronized int clearAllBio() {
		int removed = 0;
		while(docs.get(0) == doctype.bio) {
			docs.remove(0);
			removed++;
		}
		return removed;
	}
	
	public synchronized int clearRand() {
		int removed = 0;
		for(int i = 0; i< (new Random().nextInt(5) + 1); i++) {
			docs.remove(0);
			removed++;
		}
		return removed;
	}
	
	public static doctype[] getRandomDocs() {
		doctype[] res = new doctype[450];
		List<Integer> index = new LinkedList<>();
		Random rand = new Random();
		for(int i=0; i<200; i++) {
			Integer r;
			do {
				r = rand.nextInt(450);
			} while (index.contains(r));
			index.add(r);
		}
		index.stream().forEach(t -> res[t] = doctype.math);
		for(int i=0; i<res.length; i++) {
			if(res[i] == null) {
				res[i] = doctype.bio;
			}
		}
		return res;
	}
}
