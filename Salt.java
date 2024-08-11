///usr/bin/env jbang "$0" "$@" ; exit $?

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Salt {

  public static void main(String... args) throws NoSuchAlgorithmException, InvalidKeySpecException {
    SecureRandom rand = new SecureRandom();
    byte[] salt = new byte[16];
    rand.nextBytes(salt);
    String xPassword = "password";
    String nPassword = "password";

    KeySpec spec = new PBEKeySpec(xPassword.toCharArray(), salt, 65536, 256);
    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

    // byte[] hash = factory.generateSecret(spec).getEncoded();
    // String pw = Base64.getEncoder().encodeToString(hash);

    byte[] hash = factory.generateSecret(spec).getEncoded();
    String newHash = Base64.getEncoder().encodeToString(hash);
    String storedHash = "rVJzHJgB150BdpZZIY5uEmSVi6uFJj/oflnh4B5TSxA=";


    boolean tf = newHash.equals(storedHash);
    System.out.println(newHash);
    System.out.println(tf);
    System.out.println(storedHash);

  }
}
