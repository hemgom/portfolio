package CloneCoding.NaverCafe.security;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
public class AesUtil {

    private final String passwordKey;

    public String aesEncode(String plainText) {

        SecretKeySpec secretKey = new SecretKeySpec(passwordKey.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameter = new IvParameterSpec(passwordKey.substring(0, 16).getBytes());

        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, secretKey, ivParameter);

            byte[] encodeByte = c.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

            return Base64.encodeBase64String(encodeByte);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }

    }

    public String aesDecode(String encodeText) {

        SecretKeySpec secretKey = new SecretKeySpec(passwordKey.getBytes(StandardCharsets.UTF_8), "AES");
        IvParameterSpec ivParameter = new IvParameterSpec(passwordKey.substring(0, 16).getBytes());

        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, secretKey, ivParameter);

            byte[] decodeByte = c.doFinal(Base64.decodeBase64(encodeText));

            return new String(decodeByte, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }

    }

}
