/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

/**
 *
 * @author profe
 */
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

    public static String senhamd5(String senha) {
        StringBuilder sb = new StringBuilder();
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(senha.getBytes(StandardCharsets.UTF_8));

            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }

        } catch (NoSuchAlgorithmException ex) {
           sb.append("");
        }
        return sb.toString();

    }

}
