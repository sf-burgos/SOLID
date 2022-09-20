import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;

public class UserRegistry {

  private void createUser(String email, String password)
      throws Exception {
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
    keyPairGen.initialize(2048);
    KeyPair pair = keyPairGen.generateKeyPair();
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
    byte[] input = password.getBytes();
    cipher.update(input);
    byte[] cipherText = cipher.doFinal();
    User newUser = new User(email, new String(cipherText, "UTF8"));
    UserRepository.save(newUser);
  }
}
