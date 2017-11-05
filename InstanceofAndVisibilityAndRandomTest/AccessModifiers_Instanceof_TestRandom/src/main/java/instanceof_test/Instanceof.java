package instanceof_test;

public class Instanceof{
	public static String public_field = "public field of MyPackage";
	private static String private_field = "private field of MyPackage";
	protected static String protected_field = "protected field of MyPackage";
	static String default_field = "default field of MyPackage";
	
	public static void getDifferentFields() {
		System.out.println(Instanceof.public_field);
		System.out.println(Instanceof.protected_field);
		System.out.println(Instanceof.default_field);
		System.out.println(Instanceof.private_field);
		
		System.out.println(Instanceof.public_field);
		System.out.println(Instanceof.protected_field);
		System.out.println(Instanceof.default_field);
		System.out.println(Instanceof.private_field);
		
		System.out.println(Instanceof.public_field);
		System.out.println(Instanceof.protected_field);
		System.out.println(Instanceof.default_field);
		System.out.println(Instanceof.private_field);

		System.out.println(Instanceof.public_field);
		System.out.println(Instanceof.protected_field);
		System.out.println(Instanceof.default_field);
		System.out.println(Instanceof.private_field);
	}
	
}
