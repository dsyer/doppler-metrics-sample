package demo;

import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.ReflectionUtils;

/**
 * Created by vcarvalho on 4/18/15.
 */
public class Signer {

	private SecretKeySpec keySpec;
	
	public Signer(String secret) {
		try {
			this.keySpec = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
		}
		catch (Exception e) {
			ReflectionUtils.rethrowRuntimeException(e);
		}

	}

	public byte[] decrypt(byte[] input) {
		byte[] decrypted = null;
		try {
			Mac hmac = Mac.getInstance("HmacSHA256");
			hmac.init(this.keySpec);
			int len = hmac.getMacLength();
			byte[] message = new byte[input.length - len];
			System.arraycopy(input, len, message, 0, message.length);
			byte[] expected = hmac.doFinal(message);
			byte[] current = new byte[len];
			System.arraycopy(input, 0, current, 0, len);
			if (!Arrays.equals(expected, current)) {
				throw new RuntimeException("Invalid HMAC signature");
			}
			decrypted = message;
		}
		catch (Exception e) {
			ReflectionUtils.rethrowRuntimeException(e);
		}
		return decrypted;
	}

	public byte[] encrypt(byte[] input) {
		byte[] encrypted = null;
		try {
			Mac hmac = Mac.getInstance("HmacSHA256");
			hmac.init(this.keySpec);
			byte[] signature = hmac.doFinal(input);
			encrypted = new byte[signature.length + input.length];
			System.arraycopy(signature, 0, encrypted, 0, signature.length);
			System.arraycopy(input, 0, encrypted, signature.length, input.length);
		}
		catch (Exception e) {
			ReflectionUtils.rethrowRuntimeException(e);
		}
		return encrypted;
	}
}
