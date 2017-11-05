package main;

import instanceof_test.ChildChild;
import instanceof_test.Instanceof;
import instanceof_test.MyPackage;
import instanceof_test.MyPackageChild;
import instanceof_test.OtherChild;
import other_package.OtherPackage;
import other_package.OtherPackageChild;

public class Main {

	public static void main(String[] args) {
		MyPackageChild.getDifferentFields();
	}
	
	private static void getAllFields() {
		Instanceof.getDifferentFields();
		MyPackage.getDifferentFields();
		MyPackageChild.getDifferentFields();
		OtherPackage.getDifferentFields();
		OtherPackageChild.getDifferentFields();
	}
	
	private static void instanceofAll() {
		MyPackageChild c = new MyPackageChild();
		System.out.println(c instanceof Instanceof);
		ChildChild cc = new ChildChild();
		System.out.println(cc instanceof Instanceof);
		System.out.println(cc instanceof MyPackageChild);
		System.out.println(cc instanceof OtherChild);
	}
	
	private void exttt(Instanceof inst) {
		inst.getDifferentFields();
	}

}
