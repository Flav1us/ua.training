package util;

import org.apache.commons.codec.digest.DigestUtils;

public class Hash {
	public static String sha256(String arg) {
		return DigestUtils.sha256Hex(arg);
	}
}
