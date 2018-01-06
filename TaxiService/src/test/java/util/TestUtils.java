package util;

import static org.junit.Assert.assertTrue;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestUtils {
	@Test
	public void testHash() {
		String input = "password";
		String hash = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";
		assertTrue(hash.equals(Hash.sha256(input)));
	}
}
